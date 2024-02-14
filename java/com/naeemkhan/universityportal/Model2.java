package com.naeemkhan.universityportal;

public class Model2 {
    String typesofCourses;
    String NoofCourses;
    String creditHours;


    public Model2(String typesofCourses, String NoofCourses, String creditHours) {
        this.typesofCourses = typesofCourses;
        this.NoofCourses = NoofCourses;
        this.creditHours = creditHours;

    }
    public Model2() {
    }



    public String getTypesofCourses() {
        return typesofCourses;
    }

    public void setTypesofCourses(String typesofCourses) {
        this.typesofCourses = typesofCourses;
    }

    public String getNoofCourses() {
        return NoofCourses;
    }

    public void setNoofCourses(String noofCourses) {
        NoofCourses = noofCourses;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }
}

