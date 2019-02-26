package com.bjdvt.wx.controller.vo;

import java.util.List;

public class SkimDayNumVo {
 private int total;
 private List<String> categories;
 private List<Series> series;
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public List<String> getCategories() {
	return categories;
}
public void setCategories(List<String> categories) {
	this.categories = categories;
}
public List<Series> getSeries() {
	return series;
}
public void setSeries(List<Series> series) {
	this.series = series;
}


}
