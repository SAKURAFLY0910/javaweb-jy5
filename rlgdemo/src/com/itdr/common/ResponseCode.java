package com.itdr.common;

public class ResponseCode<T> {
    private Integer status;  //状态
    private T  data;
    private String mag;

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public String getMag()
    {
        return mag;
    }

    public void setMag(String mag) {

        this.mag = mag;
    }

//成功时只要返回状态码和成功的数据
    public static <T>ResponseCode successRS(Integer status,T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        return  rs;
    }

    public static <T>ResponseCode successRS(T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(data);
        return  rs;
    }


//   失败时只要返回状态码和失败信息就可以
public static <T>ResponseCode defeatedRS(Integer status,String mag){
    ResponseCode rs=new ResponseCode();
    rs.setStatus(status);
    rs.setMag(mag);
    return  rs;
}

    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }
}
