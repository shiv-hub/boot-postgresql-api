package com.shiv.springpostgres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	@Column
	private String pwd;
	public long getUid() {
		return uid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String pwd) {
		super();
		this.pwd = pwd;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
