package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("artist")
@Data
public class Artist {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "username")
	private String username;
	@TableField(value = "password")
	private String password;
	@TableField(value = "uid")
	private String uid;
	@TableField(value = "email")
	private String email;
	@TableField(value = "sex")
	private Boolean sex;
	@TableField(value = "age")
	private String age;
	@TableField(value = "text")
	private String text;
	@TableField(value = "icon")
	private String icon;
	@TableField(exist = false)
	private String newPassword;
	

    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
		this.username = username;
    }
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
		this.password = password;
    }
	public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
		this.uid = uid;
    }
	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
		this.email = email;
    }
	public Boolean getSex() {
        return sex;
    }
    public void setSex(Boolean sex) {
		this.sex = sex;
    }
	public String getAge() {
        return age;
    }
    public void setAge(String age) {
		this.age = age;
    }
	public String getText() {
        return text;
    }
    public void setText(String text) {
		this.text = text;
    }
	public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
		this.icon = icon;
    }
	public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
    }
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}