package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "categorius")
public class Category {
   
	private int id;
	private String title;
	private String des;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String title, String des) {
		super();
		this.id = id;
		this.title = title;
		this.des = des;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title + ", des=" + des + "]";
	}
	
}
