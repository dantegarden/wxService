package com.bjdvt.wx.serviceImp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author like
 * @date 2018-7-9 11:03:04
 * @version V1.0
 * @desc
 */
@Service
public class HttpServiceImp {
	
    public static final String get(final String url, final Map<String, Object> params) {
        StringBuilder sb = new StringBuilder("");

        if (null != params && !params.isEmpty()) {
            int i = 0;
            for (String key : params.keySet()) {
                if (i == 0) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key).append("=").append(params.get(key));
                i++;
            }
        }
        
        CloseableHttpClient httpClient = createSSLClientDefault();

        CloseableHttpResponse response = null;
        System.out.println(url + sb.toString());
        HttpGet get = new HttpGet(url + sb.toString());
        
        String result = "";

        try {
            response = httpClient.execute(get);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return result;
    }

    public static final String post(final String url, final Map<String, Object> params) {
        CloseableHttpClient httpClient = createSSLClientDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");
        CloseableHttpResponse response = null;

        if (null != params && !params.isEmpty()) {
            List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair nvp = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                nvpList.add(nvp);
            }
            post.setEntity(new UrlEncodedFormEntity(nvpList, Charset.forName("UTF-8")));
        }
       
        String result = "";

        try {
            response = httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return result;
    }
    public static final String post(final String url, final String params) {
        CloseableHttpClient httpClient = createSSLClientDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");
        CloseableHttpResponse response = null;
        StringEntity entity = new StringEntity(params, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);
    
        String result = "";

        try {
            response = httpClient.execute(post);
            System.out.println("result="+response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entityResult = response.getEntity();
                if (null != entityResult) {
                    result = EntityUtils.toString(entity, "UTF-8");
                   
                } 
                   
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                	ex.printStackTrace();
                    Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return result;
    }

   
    private static CloseableHttpClient createSSLClientDefault() {

        SSLContext sslContext;
        try {
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                @Override
                public boolean isTrusted(X509Certificate[] xcs, String string){
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyStoreException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(HttpServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return HttpClients.createDefault();
    }

    public static void main(String[] args) {
        System.out.println("Result:" + get("https://github.com/", null));
    }
}