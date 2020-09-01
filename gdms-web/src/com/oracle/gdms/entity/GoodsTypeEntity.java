package com.oracle.gdms.entity;

import java.io.Serializable;

public class GoodsTypeEntity implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = -3592866979910654044L;
private int gtid;
   public int getGtid() {
	return gtid;
}
public GoodsTypeEntity(int gtid, String name, String description) {
	super();
	this.gtid = gtid;
	this.name = name;
	this.description = description;
}
public void setGtid(int gtid) {
	this.gtid = gtid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "GoodsTypeEntity [gtid=" + gtid + ", name=" + name + ", description=" + description + "]";
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
private String  name;
   private String  description;
public GoodsTypeEntity() {
	super();
	// TODO 自动生成的构造函数存根 
}
}
