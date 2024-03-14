package com.forestdre4m.labelclub.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("lfm")
@Data
public class Lfm {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer rate;

    private Integer lid;

}
