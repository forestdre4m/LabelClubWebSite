package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("audio")
@Data
public class Audio {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "aid")
	private String aid;
	@TableField(value = "labelname")
	private String labelname;
	@TableField(value = "audioname")
	private String audioname;
	@TableField(value = "author")
	private String author;
	@TableField(value = "file")
	private String file;
	@TableField(value = "genre")
	private String genre;
	@TableField(value = "remark")
	private String remark;
	@TableField(value = "udt")
	private String udt;
	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getAid() {
        return aid;
    }
    public void setAid(String aid) {
		this.aid = aid;
    }
	public String getLabelname() {
        return labelname;
    }
    public void setLabelname(String labelname) {
		this.labelname = labelname;
    }
	public String getAudioname() {
        return audioname;
    }
    public void setAudioname(String audioname) {
		this.audioname = audioname;
    }
	public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
		this.author = author;
    }
	public String getFile() {
        return file;
    }
    public void setFile(String file) {
		this.file = file;
    }
	public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
		this.genre = genre;
    }
	public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
		this.remark = remark;
    }
	public String getUdt() {
        return udt;
    }
    public void setUdt(String udt) {
		this.udt = udt;
    }
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}