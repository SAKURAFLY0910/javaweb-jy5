package com.itdr.pojo;

public class Order {
    private  Integer id;
    private  Integer status;
    private String orderNo;
    private double payment;
    private Integer paymentType;
    private String paymentTypeDesc;
    private String productName;
//    private Integer status;
//    private long createTime;
//    private long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderNo='" + orderNo + '\'' +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", paymentTypeDesc='" + paymentTypeDesc + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }

}
