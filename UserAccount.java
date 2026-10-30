package com.hostelcheck.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="user_accounts", uniqueConstraints={@UniqueConstraint(columnNames="email"),@UniqueConstraint(columnNames="token")})
public class UserAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String fullName;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String phone;
 @Column(nullable=false) private String role;
 @Column(nullable=false,length=512) private String passwordHash;
 @Column(nullable=false,unique=true,length=80) private String token;
 private String institution; private String matricNumber; private String department; private String academicLevel;
 private String businessName; private String businessAddress; private String operatingArea;
 @Column(length=1500) private String businessDescription;
 @Column(nullable=false) private boolean identityVerified=false;
 @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now();
 public UserAccount(){}
 public Long getId(){return id;} public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v==null?null:v.trim().toLowerCase();}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public String getRole(){return role;} public void setRole(String v){role=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;} public String getToken(){return token;} public void setToken(String v){token=v;}
 public String getInstitution(){return institution;} public void setInstitution(String v){institution=v;} public String getMatricNumber(){return matricNumber;} public void setMatricNumber(String v){matricNumber=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public String getAcademicLevel(){return academicLevel;} public void setAcademicLevel(String v){academicLevel=v;}
 public String getBusinessName(){return businessName;} public void setBusinessName(String v){businessName=v;} public String getBusinessAddress(){return businessAddress;} public void setBusinessAddress(String v){businessAddress=v;}
 public String getOperatingArea(){return operatingArea;} public void setOperatingArea(String v){operatingArea=v;} public String getBusinessDescription(){return businessDescription;} public void setBusinessDescription(String v){businessDescription=v;}
 public boolean isIdentityVerified(){return identityVerified;} public void setIdentityVerified(boolean v){identityVerified=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}
