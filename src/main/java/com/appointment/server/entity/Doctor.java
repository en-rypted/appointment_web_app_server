package com.appointment.server.entity;


import jakarta.validation.constraints.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Document(collection = "doctor")
public class Doctor {
    @Id
    private ObjectId id;
    private User user;
    @NotBlank(message = "Name required")
    private String name;
    @NotNull(message = "Birthdate is required")
    @Past(message = "Birthdate must be in the past")
    private Date birthDate;
    @NotBlank(message = "Name email")
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$", message = "Invalid email format")
    private String email;
    @Min(value = 26, message = "Age must be at least 26")
    @Max(value = 70, message = "Age must not exceed 70")
    private Integer age;
   private String address;
   private String specialisation;
  private Integer experience;
  @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number")
  private String mobileNo;
  private String pic;

  public Doctor(){

  }

    public  User getUser() {
        return user;
    }

    public void setUser( User user) {
        this.user = user;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        LocalDate localDate = birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = new Date().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.age = now.getYear()-localDate.getYear();
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        LocalDate localDate = this.birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = new Date().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.age = now.getYear()-localDate.getYear();
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
