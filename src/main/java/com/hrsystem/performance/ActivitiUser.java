//package com.hrsystem.performance;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.activiti.engine.identity.Picture;
//import org.activiti.engine.impl.persistence.entity.ByteArrayRef;
//import org.activiti.engine.impl.persistence.entity.UserEntity;
///**
//*@项目名称: hrsystem
//*@作者: HyperMuteki
//*@文件名称: ActivitiUser.java
//  *@Date: 2018年9月26日
//*@Copyright: 2018 https://github.com/HyperMuteki Inc. All rights reserved.
// 
//*/
//public class ActivitiUser implements UserEntity{
//
//	 private static final long serialVersionUID = 1L;
//
//	  protected String firstName;
//	  protected String lastName;
//	  protected String email;
//	  protected String password;
//
//	  protected ByteArrayRef pictureByteArrayRef;
//
//	  protected String id;
//	  protected int revision = 1;
//	  
//	  protected boolean isInserted;
//	  protected boolean isUpdated;
//	  protected boolean isDeleted;
//	  
//	  public ActivitiUser() {
//	  }
//
//	  public Object getPersistentState() {
//	    Map<String, Object> persistentState = new HashMap<String, Object>();
//	    persistentState.put("firstName", firstName);
//	    persistentState.put("lastName", lastName);
//	    persistentState.put("email", email);
//	    persistentState.put("password", password);
//	    
//	    if (pictureByteArrayRef != null) {
//	      persistentState.put("pictureByteArrayId", pictureByteArrayRef.getId());
//	    }
//	    
//	    return persistentState;
//	  }
//
//	  public Picture getPicture() {
//	    if (pictureByteArrayRef != null && pictureByteArrayRef.getId() != null) {
//	      return new Picture(pictureByteArrayRef.getBytes(), pictureByteArrayRef.getName());
//	    }
//	    return null;
//	  }
//
//	  public void setPicture(Picture picture) {
//	    if(picture != null) {
//	      savePicture(picture);
//	    } else {
//	      deletePicture();
//	    }      
//	  }
//
//	  protected void savePicture(Picture picture) {
//	    if (pictureByteArrayRef != null) {
//	      pictureByteArrayRef = new ByteArrayRef();
//	    }
//	    pictureByteArrayRef.setValue(picture.getMimeType(), picture.getBytes());
//	  }
//	  
//	  protected void deletePicture() {
//	    if (pictureByteArrayRef != null) {
//	      pictureByteArrayRef.delete();
//	    }
//	  }
//	  
//	  public String getFirstName() {
//	    return firstName;
//	  }
//
//	  public void setFirstName(String firstName) {
//	    this.firstName = firstName;
//	  }
//
//	  public String getLastName() {
//	    return lastName;
//	  }
//
//	  public void setLastName(String lastName) {
//	    this.lastName = lastName;
//	  }
//
//	  public String getEmail() {
//	    return email;
//	  }
//
//	  public void setEmail(String email) {
//	    this.email = email;
//	  }
//
//	  public String getPassword() {
//	    return password;
//	  }
//
//	  public void setPassword(String password) {
//	    this.password = password;
//	  }
//
//	  public boolean isPictureSet() {
//	    return pictureByteArrayRef != null && pictureByteArrayRef.getId() != null;
//	  }
//
//	  public ByteArrayRef getPictureByteArrayRef() {
//	    return pictureByteArrayRef;
//	  }
//
//	  @Override
//	  public String getId() {
//	    return id;
//	  }
//	  
//	  @Override
//	  public void setId(String id) {
//	    this.id = id;
//	  }
//	  
//	  public int getRevisionNext() {
//	    return revision + 1;
//	  }
//
//	  public int getRevision() {
//	    return revision;
//	  }
//
//	  public void setRevision(int revision) {
//	    this.revision = revision;
//	  }
//
//	  public boolean isInserted() {
//	    return isInserted;
//	  }
//
//	  public void setInserted(boolean isInserted) {
//	    this.isInserted = isInserted;
//	  }
//
//	  public boolean isUpdated() {
//	    return isUpdated;
//	  }
//
//	  public void setUpdated(boolean isUpdated) {
//	    this.isUpdated = isUpdated;
//	  }
//
//	  public boolean isDeleted() {
//	    return isDeleted;
//	  }
//
//	  public void setDeleted(boolean isDeleted) {
//	    this.isDeleted = isDeleted;
//	  }
//
//}
