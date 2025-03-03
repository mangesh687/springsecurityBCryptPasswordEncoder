package com.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer cid;
	private String name;
	private String email;
	private String pwd;
	private long phon;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public long getPhon() {
		return phon;
	}
	public void setPhon(long phon) {
		this.phon = phon;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", phon=" + phon + "]";
	}
	public Customer(Integer cid, String name, String email, String pwd, long phon) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phon = phon;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


}
