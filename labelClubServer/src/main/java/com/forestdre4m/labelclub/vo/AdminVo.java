package com.forestdre4m.labelclub.vo;
import com.forestdre4m.labelclub.entity.Admin;
import lombok.Data;
import java.util.List;
@Data
public class AdminVo extends Admin {
	private List<Admin> list;//所有数据
    private long pages;//总页数
    private long total;//总记录数
    private long current;//当前页
    private long currentNum = 10;//当前页数据数

}