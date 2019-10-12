package com.tianzhuan.netease_mvp_02.bean;

public class UserInfo extends BaseEntitiy{
    private String company;
    private String name;

    public UserInfo(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public String getCompany() {
        return company == null ? "" : company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "company='" + company + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
