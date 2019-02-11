package com.beskilled.entity;


import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3, max = 30)
    private String name;
    @Min(18)
    private byte age;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String round;

    @NotEmpty
    private String[] subject;
    @NotEmpty
    private String gender;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private Date lastModifi = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Size(min = 5, max = 10)
    private String userName;
    @NotEmpty
    private String password;

    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;



    public User() {
    }

    public User(@Size(min = 3, max = 30) String name, @Min(18) byte age, @NotBlank String phone, @NotBlank String email, @NotBlank String round, @NotEmpty String[] subject, @NotEmpty String gender, Date regDate, Date lastModifi, Date birthday, @Size(min = 5, max = 10) String userName, @NotEmpty String password) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.round = round;
        this.subject = subject;
        this.gender = gender;
        this.regDate = regDate;
        this.lastModifi = lastModifi;
        this.birthday = birthday;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastModifi() {
        return lastModifi;
    }

    public void setLastModifi(Date lastModifi) {
        this.lastModifi = lastModifi;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(round, user.round) &&
                Arrays.equals(subject, user.subject) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(regDate, user.regDate) &&
                Objects.equals(lastModifi, user.lastModifi) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, age, phone, email, round, gender, regDate, lastModifi, birthday, userName, password);
        result = 31 * result + Arrays.hashCode(subject);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", round='" + round + '\'' +
                ", subject=" + Arrays.toString(subject) +
                ", gender='" + gender + '\'' +
                ", regDate=" + regDate +
                ", lastModifi=" + lastModifi +
                ", birthday=" + birthday +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

