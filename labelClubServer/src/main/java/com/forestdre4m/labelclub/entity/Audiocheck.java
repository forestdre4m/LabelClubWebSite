package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("audiocheck")
@Data
public class Audiocheck {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "author")
	private String author;
	@TableField(value = "labelname")
	private String labelname;
	@TableField(value = "audioname")
	private String audioname;
	@TableField(value = "issh")
	private Boolean issh;
	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
		this.author = author;
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
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}