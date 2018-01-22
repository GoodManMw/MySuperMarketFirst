package com.mysupermarket.pojo;

import java.util.List;

import com.mysupermarket.pojo.Good;
import com.mysupermarket.pojo.GoodEvaluate;
import com.mysupermarket.pojo.ShopAccount;

public class GoodDetailLoadEntity {
	
	private Integer gdId;
	private String gdUrl;
	private Double gdPrimeprice;
	private Double gdFreight;
	private String gdChoose;
	private ShopAccount gdShop;
	private Good gdGood;
	private List<GoodEvaluate> gdEvaluate;
	
	public Integer getGdId() {
		return gdId;
	}
	public void setGdId(Integer gdId) {
		this.gdId = gdId;
	}
	public String getGdUrl() {
		return gdUrl;
	}
	public void setGdUrl(String gdUrl) {
		this.gdUrl = gdUrl;
	}
	public Double getGdPrimeprice() {
		return gdPrimeprice;
	}
	public void setGdPrimeprice(Double gdPrimeprice) {
		this.gdPrimeprice = gdPrimeprice;
	}
	public Double getGdFreight() {
		return gdFreight;
	}
	public void setGdFreight(Double gdFreight) {
		this.gdFreight = gdFreight;
	}
	public String getGdChoose() {
		return gdChoose;
	}
	public void setGdChoose(String gdChoose) {
		this.gdChoose = gdChoose;
	}
	public ShopAccount getGdShop() {
		return gdShop;
	}
	public void setGdShop(ShopAccount gdShop) {
		this.gdShop = gdShop;
	}
	public Good getGdGood() {
		return gdGood;
	}
	public void setGdGood(Good gdGood) {
		this.gdGood = gdGood;
	}
	public List<GoodEvaluate> getGdEvaluate() {
		return gdEvaluate;
	}
	public void setGdEvaluate(List<GoodEvaluate> gdEvaluate) {
		this.gdEvaluate = gdEvaluate;
	}
	
}
