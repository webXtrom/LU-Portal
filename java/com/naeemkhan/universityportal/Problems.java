package com.naeemkhan.universityportal;

public class Problems {

    String id;
    String prb1;
    String prb2;
    String spinner1;
    String spinner2;


    public Problems(String id, String prb1,String prb2,String spinner1,String spinner2) {
        this.id = id;
        this.prb1 = prb1;
        this.prb2 = prb2;
        this.spinner1 = spinner1;
        this.spinner2 = spinner2;
    }

    public String getId() {
        return id;
    }

    public String getPrb1() {
        return prb1;
    }

    public String getPrb2() {
        return prb2;
    }

    public String getSpinner1() {
        return spinner1;
    }

    public String getSpinner2() {
        return spinner2;
    }
}

