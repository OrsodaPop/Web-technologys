package com.it.pojo;

import java.sql.Date;

public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private String education;
    private String job;
    private String phoneNumber;
    private String address;

    public Emp() {
    }

    public Emp(Integer id, String name, String gender, Date birthday, String education, String job, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.education = education;
        this.job = job;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


}
