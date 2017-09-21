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
	 * 起始日期 
	*/
	@Column(name="start_date")
	private Long startDate;

	/**
	 * 结束日期 
	*/
	@Column(name="end_date")
	private Long endDate;

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
     * 起始日期
     * @return 
     */ 
    public Long getStartDate() {
    	return startDate;
    }
    
    /** 
     * 起始日期
     * @param 
     */ 
    public void setStartDate(Long startDate) {
    	this.startDate = startDate;
    }
    	
    /** 
     * 结束日期
     * @return 
     */ 
    public Long getEndDate() {
    	return endDate;
    }
    
    /** 
     * 结束日期
     * @param 
     */ 
    public void setEndDate(Long endDate) {
    	this.endDate = endDate;
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
    	
    public String getStartDateStr() {
    	return Common.DateLongToStr(startDate);
    }
    
    public void setStartDateStr(String startDate) {
    	this.startDate = Common.DateStrToLong(startDate);
    }
    	
    public String getEndDateStr() {
    	return Common.DateLongToStr(endDate);
    }
    
    public void setEndDateStr(String endDate) {
    	this.endDate = Common.DateStrToLong(endDate);
    }
}