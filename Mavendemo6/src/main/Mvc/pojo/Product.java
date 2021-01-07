package main.Mvc.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product  {
    private Integer id;

    private Integer category_id;

    private String name;

    private String subtitle;

    private String mainImage;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Boolean isnew;

    private Boolean ishot;

    private Boolean isbanner;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsnew() {
        return isnew;
    }

    public void setIsnew(Boolean isnew) {
        this.isnew = isnew;
    }

    public Boolean getIshot() {
        return ishot;
    }

    public void setIshot(Boolean ishot) {
        this.ishot = ishot;
    }

    public Boolean getIsbanner() {
        return isbanner;
    }

    public void setIsbanner(Boolean isbanner) {
        this.isbanner = isbanner;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", isnew=" + isnew +
                ", ishot=" + ishot +
                ", isbanner=" + isbanner +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}