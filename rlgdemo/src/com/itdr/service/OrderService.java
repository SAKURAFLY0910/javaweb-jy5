package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Order;
import com.itdr.pojo.Product;

import java.util.List;

public class OrderService {
    //数据层对象
      private OrderDao pd=new OrderDao();
  //订单详情
    public ResponseCode detailDo(String orderNo) {
        ResponseCode rs = new ResponseCode();
        if (orderNo == null || orderNo.equals("")) {
            rs = ResponseCode.defeatedRS(Const.PRODUCT_PARAMETER_CODE, Const.PRODUCT_PARAMETER_MSG);
            return rs;
        }

        Order li = pd.detailDo(orderNo);

       if (li==null){
           rs.setStatus(1);
           rs.setData("没有找到订单！");
           return rs;
       }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }

    //查询订购单

    public ResponseCode searchDo(String orderNo) {
        ResponseCode rs = new ResponseCode();
        if (orderNo == null || orderNo.equals("")) {
            rs = ResponseCode.defeatedRS(Const.PRODUCT_PARAMETER_CODE, Const.PRODUCT_PARAMETER_MSG);
            return rs;
        }

        Order li = pd.detailDo(orderNo);

        if (li==null){
            rs.setStatus(1);
            rs.setData("没有找到订单！");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//订单列表
    public ResponseCode listDo(String pageNum, String pageSize) {

        ResponseCode rs = new ResponseCode();

        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        List<Order> li = pd.listDo(pageNum, pageSize);
        rs.setStatus(0);
        rs.setData(li);
        return  rs;
    }
//发货
    public ResponseCode send_goodsDo(String OR) {
        ResponseCode rs = new ResponseCode();
        int row=0;
        row=pd.send_goodsDo(OR);

        if (row <= 0) {
          rs.setStatus(1);
          rs.setMag("发货状态修改失败！");
        }
        rs.setStatus(0);
        rs.setMag("发货状态修改成功！");
        rs.setData(row);
        return  rs;
    }
}
