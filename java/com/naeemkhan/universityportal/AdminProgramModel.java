package com.naeemkhan.universityportal;

public class AdminProgramModel {


    String typesofCourses;
    String NoofCourses;
    String creditHours;


    public AdminProgramModel() {
    }


    public String getTypesofCourses() {
        return typesofCourses;
    }

    public String getNoofCourses() {
        return NoofCourses;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public void setTypesofCourses(String typesofCourses) {
        this.typesofCourses = typesofCourses;
    }

    public void setNoofCourses(String noofCourses) {
        NoofCourses = noofCourses;
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }
}


