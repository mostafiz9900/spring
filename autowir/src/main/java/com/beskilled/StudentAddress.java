package com.beskilled;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentAddress {
    @Autowired
    private Student student;
public void studentCall(){
    student.studentlist();
}
}
