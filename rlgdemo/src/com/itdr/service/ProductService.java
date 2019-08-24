package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;

import java.util.List;

public class ProductService {

    private ProductDao pd = new ProductDao();
//产品列表
    public ResponseCode selectAll(String pageNum, String pageSize) {
        ResponseCode rs = new ResponseCode();
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }

        List<Product> li = pd.selectAll(pageNum, pageSize);
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }

    //产品搜索
    public ResponseCode searchDo(String src) {
        ResponseCode rs = new ResponseCode();
        if (src == null || src.equals("")) {
            rs = ResponseCode.defeatedRS(Const.USER_PARAMETER_CODE, Const.USER_PARAMETER_MSG);
            return rs;
        }

        //字符串转数值
        Product li = null;
        Integer src1 = 0;
        try {
            src1 = Integer.parseInt(src);
            li = pd.searchDo(src1);
            rs.setData(li);
            return rs;
        } catch (Exception e) {
            li = pd.searchDo(src);
            rs.setData(li);
            return rs;
        }
    }

    //产品详情
    public ResponseCode detailDo(String det) {
        ResponseCode rs = new ResponseCode();
        if (det == null || det.equals("")) {
            rs = ResponseCode.defeatedRS(Const.PRODUCT_PARAMETER_CODE, Const.PRODUCT_PARAMETER_MSG);
            return rs;
        }
        //字符串转数值
        Product li = null;
        Integer det1 = 0;
        try {
            det1 = Integer.parseInt(det);
            li = pd.detailDo(det1);
            rs.setData(li);
            return rs;
        } catch (Exception e) {
            li = pd.detailDo(det);
            rs.setData(li);
            return rs;
        }
    }

    //产品上下架
    public ResponseCode set_sale_statusDo(String productId, String status) {
        ResponseCode rs = new ResponseCode();
        if (productId == null || productId.equals("")) {
            rs = ResponseCode.defeatedRS(Const.PRODUCT_PARAMETER_CODE, Const.PRODUCT_PARAMETER_MSG);
            return rs;
        }

        if (status == null || status.equals("")) {
            rs = ResponseCode.defeatedRS(Const.PRODUCT_PARAMETER_CODE, Const.PRODUCT_PARAMETER_MSG);
            return rs;
        }

        Integer ids = 0;
        Integer tus = 0;
        try {
            ids = Integer.parseInt(productId);
            tus = Integer.parseInt(status);

        } catch (Exception e) {
            rs.setStatus(105);
            rs.setMag("输入参数非法");
            return rs;
        }

        Product pr = pd.selectOne(ids);

        //如果产品不存在

        if (pr == null) {
            rs.setStatus(Const.PRODUCT_NO_CODE);
            rs.setMag(Const.PRODUCT_NO_MSG);
            return rs;
        }

        int li = pd.set_sale_statusDo(ids,tus);


        if (li <= 0) {
            rs.setStatus(106);
            rs.setMag(Const.UPDATE_STATUS_DEFAULT);
            return rs;
        }
        rs.setStatus(0);
        rs.setMag(Const.UPDATE_STATUS_SUCCESS);
        return rs;

    }

    //增加产品
    public ResponseCode saveDo(String pname, String categoryId, String subtitle, String imageHost, String price, String status) {
        ResponseCode rs = new ResponseCode();
        Integer cId=0;
        Integer pri=0;
        Integer tus=0;

        try{
            cId = Integer.parseInt(categoryId);
            pri = Integer.parseInt(price);
            tus = Integer.parseInt(status);
        }catch (Exception e){
            rs.setMag(Const.PRODUCT_STATUS_DEFAULT);
        }

        int li = pd.saveDo(pname,  cId,  subtitle,  imageHost,  pri,  tus);

        if (li <= 0) {
            rs.setStatus(106);
            rs.setMag(Const.UPDATE_THING_DEFAULT);
            return rs;
        }
        rs.setStatus(0);
        rs.setMag(Const.UPDATE_THING_SUCCESS);
        return rs;
    }
}
