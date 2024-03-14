package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;


@TableName("liuyanban")
@Data
public class Liuyanban {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

	@TableField(value = "username")
	private String username;
	@TableField(value = "cheng")
	private String cheng;
	@TableField(value = "icon")
	private String icon;
	@TableField(value = "title")
	private String title;
	@TableField(value = "content")
	private String content;
	@TableField(value = "reply")
	private String reply;



    @TableField(value = "addtime")
    private Date addtime;
    @TableField(exist = false)
    private List<Liuyanban> children;
    private Integer parent;

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
	public String getCheng() {
        return cheng;
    }
    public void setCheng(String cheng) {
		this.cheng = cheng;
    }
	public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
		this.icon = icon;
    }
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
		this.title = title;
    }
	public String getContent() {
        return content;
    }
    public void setContent(String content) {
		this.content = content;
    }
	public String getReply() {
        return reply;
    }
    public void setReply(String reply) {
		this.reply = reply;
    }



    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}
