package com.naeemkhan.universityportal;

public class MainModel

{
    String name,email,number,type,surl;

    public  MainModel(){

    }

    public MainModel(String name, String email,String number, String type, String surl) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.type = type;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getSurl() {
        return surl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
