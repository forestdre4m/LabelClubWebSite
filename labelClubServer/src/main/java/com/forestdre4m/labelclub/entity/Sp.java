package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("sp")
@Data
public class Sp {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "name")
	private String name;
	@TableField(value = "pic")
	private String pic;
	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
        return name;
    }
    public void setName(String name) {
		this.name = name;
    }
	public String getPic() {
        return pic;
    }
    public void setPic(String tupian) {
		this.pic = pic;
    }
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}