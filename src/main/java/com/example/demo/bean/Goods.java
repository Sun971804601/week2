package com.example.demo.bean;

import java.io.Serializable;

public class Goods implements Serializable{
	private int gid;
	private String gname;
	private double price;
	private int bfb;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBfb() {
		return bfb;
	}
	public void setBfb(int bfb) {
		this.bfb = bfb;
	}
	
}
