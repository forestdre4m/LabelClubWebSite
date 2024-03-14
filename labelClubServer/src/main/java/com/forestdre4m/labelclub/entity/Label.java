package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("label")
@Data
public class Label {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "username")
	private String username;
	@TableField(value = "password")
	private String password;
	@TableField(value = "lid")
	private String lid;
	@TableField(value = "labelname")
	private String labelname;
	@TableField(value = "email")
	private String email;
	@TableField(value = "place")
	private String place;
	@TableField(value = "doe")
	private String doe;
	@TableField(value = "genre")
	private String genre;
	@TableField(value = "labelpic")
	private String labelpic;
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
	public String getLid() {
        return lid;
    }
    public void setLid(String lid) {
		this.lid = lid;
    }
	public String getLabelname() {
        return labelname;
    }
    public void setLabelName(String labelname) {
		this.labelname = labelname;
    }
	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
		this.email = email;
    }
	public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
		this.place = place;
    }
	public String getDoe() {
        return doe;
    }
    public void setDoe(String doe) {
		this.doe = doe;
    }
	public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
		this.genre = genre;
    }
	public String getLabelpic() {
        return labelpic;
    }
    public void setLabelpic(String labelpic) {
		this.labelpic = labelpic;
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

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}