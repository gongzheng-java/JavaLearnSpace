package com.gongzheng.app.domain.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 公共字段类
 * @Author: gongZheng
 * @Date:   2020年2月29日   下午6:30:57 
 * @Description: 作用：1）多个实体类中有些公共字段，避免多个类中重复编写
 *                    2）当修改、添加某个公共字段的时候，不需要查找每个类依次修改，只需修改公共类即可
 *    @Embeddable 注解表示可嵌入对象(必不可少的注解)，表明该类可以以对象嵌入到其他类中                
 */
@Embeddable
public class Common implements Serializable{
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date createtime=new Date();
	
	private Date updatetime;
	
	@Column(name="del_flag")
	private int del_flag;

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public int getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}

	
	

}
