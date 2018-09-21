package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity: Leave
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

   // private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date createTime;
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}