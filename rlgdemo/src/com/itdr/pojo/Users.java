package com.itdr.pojo;

public class Users {
    private Integer id;
    private String uname;
    private String psd;
    private String tel;
    private Integer stats=0;
    private Integer type=0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {

        this.type = type;
    }

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", psd='" + psd + '\'' +
                ", tel='" + tel + '\'' +
                ", stats=" + stats +
                ", type=" + type +
                '}';
    }


}
