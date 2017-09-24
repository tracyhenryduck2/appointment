package com.admin.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 规则
 * @author xin.chou
 *
 */
@Table(name="rules")
public class RulesBean {

	/**
	 * id 
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 规则日期 
	*/
	@Column(name="date")
	private Long date;


	/**
	 * 类型 
	*/
	@Column(name="type")
	private Long type;

	/**
	 * 最大人数 
	*/
	@Column(name="number")
	private Long number;
    	
    /** 
     * id
     * @return 
     */ 
    public Long getId() {
    	return id;
    }
    
    /** 
     * id
     * @param 
     */ 
    public void setId(Long id) {
    	this.id = id;
    }
    	
    	
    /** 
     * 结束日期
     * @return 
     */ 
    public Long getDate() {
    	return date;
    }
    
    /** 
     * 结束日期
     * @param 
     */ 
    public void setDate(Long date) {
    	this.date = date;
    }
    	
    /** 
     * 类型
     * @return 
     */ 
    public Long getType() {
    	return type;
    }
    
    /** 
     * 类型
     * @param 
     */ 
    public void setType(Long type) {
    	this.type = type;
    }
    	
    /** 
     * 最大人数
     * @return 
     */ 
    public Long getNumber() {
    	return number;
    }
    
    /** 
     * 最大人数
     * @param 
     */ 
    public void setNumber(Long number) {
    	this.number = number;
    }
    	
}