package com.itdr.pojo;

public class Product {
 private  Integer id;
 private String pname;
 private Integer categoryId;//种类ID
 private String subtitle;//副标题
 private String imageHost;//图片地址
 private Integer price;  //
 private Integer status;
 private long createTime;   //产品上架时间
 private long updateTime;  //产品更新时间

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getPname() {
  return pname;
 }

 public void setPname(String pname) {
  this.pname = pname;
 }

 public Integer getCategoryld() {
  return categoryId;
 }

 public void setCategoryld(Integer categoryld) {
  this.categoryId = categoryld;
 }

 public String getSubtitle() {
  return subtitle;
 }

 public void setSubtitle(String subtitle) {
  this.subtitle = subtitle;
 }

 public String getImageHost() {
  return imageHost;
 }

 public void setImageHost(String imageHost) {
  this.imageHost = imageHost;
 }

 public Integer getPrice() {
  return price;
 }

 public void setPrice(Integer price) {
  this.price = price;
 }

 public Integer getStatus() {
  return status;
 }

 public void setStatus(Integer status) {
  this.status = status;
 }

 public long getCreateTime() {
  return createTime;
 }

 public void setCreateTime(long createTime) {
  this.createTime = createTime;
 }

 public long getUpdateTime() {
  return updateTime;
 }

 public void setUpdateTime(long updateTime) {
  this.updateTime = updateTime;
 }

 @Override
 public String toString() {
  return "Product{" +
          "id=" + id +
          ", pname='" + pname + '\'' +
          ", categoryld=" + categoryId +
          ", subtitle='" + subtitle + '\'' +
          ", imageHost='" + imageHost + '\'' +
          ", price=" + price +
          ", status=" + status +
          ", createTime=" + createTime +
          ", updateTime=" + updateTime +
          '}';
 }
}
