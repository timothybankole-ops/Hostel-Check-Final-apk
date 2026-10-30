package com.hostelcheck.backend.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="property_listings")
public class PropertyListing {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title; @Column(nullable=false,length=1200) private String address;
 @Column(nullable=false) private String propertyType; @Column(nullable=false) private Long annualRentNaira;
 @Column(length=3000) private String description; @Column(length=2000) private String facilities; @Column(length=3000) private String photoUrls;
 @Column(nullable=false) private Long agentId; @Column(nullable=false) private String agentName;
 @Column(nullable=false) private String status="PENDING"; @Column(nullable=false) private boolean propertyVerified=false;
 private LocalDateTime createdAt=LocalDateTime.now();
 public PropertyListing(){} public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;} public String getPropertyType(){return propertyType;} public void setPropertyType(String v){propertyType=v;}
 public Long getAnnualRentNaira(){return annualRentNaira;} public void setAnnualRentNaira(Long v){annualRentNaira=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getFacilities(){return facilities;} public void setFacilities(String v){facilities=v;} public String getPhotoUrls(){return photoUrls;} public void setPhotoUrls(String v){photoUrls=v;}
 public Long getAgentId(){return agentId;} public void setAgentId(Long v){agentId=v;} public String getAgentName(){return agentName;} public void setAgentName(String v){agentName=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;} public boolean isPropertyVerified(){return propertyVerified;} public void setPropertyVerified(boolean v){propertyVerified=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}
