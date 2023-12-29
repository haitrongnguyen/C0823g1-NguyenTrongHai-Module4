package com.example.validateuser.model;


import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "Không được để trống")
    @Size(min = 5,max = 45,message = "Độ dài từ 5-45")
    private String firstName;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5,max = 45,message = "Độ dài từ 5-45")
    private String LastName;

    @Pattern(regexp = "^0[0-9]{9}$",message = "Phải là số và có 10 chữ số")
    private String phoneNumber;
    @Min(value = 18,message = "Tuô phải lớn hơn 18")
    private int age;
    @Email(message = "Email không đúng định dạng")
    private String email;

    public User(@NotBlank
                @Size(min = 5,max = 45)String firstName,@NotBlank
    @Size(min = 5,max = 45) String lastName,@Pattern(regexp = "^0[0-9]{9}$") String phoneNumber,@Min(value = 18) int age,@Email String email) {
        this.firstName = firstName;
        LastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
