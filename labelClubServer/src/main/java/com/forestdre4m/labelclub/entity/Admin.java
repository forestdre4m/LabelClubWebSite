package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("admin")
@Data
public class Admin {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "username")
	private String username;
	@TableField(value = "password")
	private String password;
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
    public void setMima(String password) {
		this.password = password;
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