package com.sty.ne.mvpmode.login.bean;

/**
 * @Author: tian
 * @UpdateDate: 2020-08-12 22:23
 */
public class UserInfo extends BaseEntity {
    private String company;
    private String name;

    public UserInfo() {
    }

    public UserInfo(String company, String name) {
        this.company = company;
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
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
