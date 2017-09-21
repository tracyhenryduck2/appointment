package com.admin.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 客户表
 * @author xin.chou
 *
 */
@Table(name="customer")
public class CustomerBean {

	/**
	 * id 
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 客户名称 
	*/
	@Column(name="name")
	private String name;

	/**
	 * 预约日期 
	*/
	@Column(name="appoint_date")
	private Long appointDate;

	/**
	 * 联系方式 
	*/
	@Column(name="phone")
	private String phone;

	/**
	 * 人数 
	*/
	@Column(name="number")
	private Long number;

	/**
	 * 卡务类型 
	*/
	@Column(name="card")
	private Long card;

	/**
	 * 核销代码 
	*/
	@Column(name="code")
	private String code;
    	
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
     * 客户名称
     * @return 
     */ 
    public String getName() {
    	return name;
    }
    
    /** 
     * 客户名称
     * @param 
     */ 
    public void setName(String name) {
    	this.name = name;
    }
    	
    /** 
     * 预约日期
     * @return 
     */ 
    public Long getAppointDate() {
    	return appointDate;
    }
    
    /** 
     * 预约日期
     * @param 
     */ 
    public void setAppointDate(Long appointDate) {
    	this.appointDate = appointDate;
    }
    	
    /** 
     * 联系方式
     * @return 
     */ 
    public String getPhone() {
    	return phone;
    }
    
    /** 
     * 联系方式
     * @param 
     */ 
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    	
    /** 
     * 人数
     * @return 
     */ 
    public Long getNumber() {
    	return number;
    }
    
    /** 
     * 人数
     * @param 
     */ 
    public void setNumber(Long number) {
    	this.number = number;
    }
    	
    /** 
     * 卡务类型
     * @return 
     */ 
    public Long getCard() {
    	return card;
    }
    
    /** 
     * 卡务类型
     * @param 
     */ 
    public void setCard(Long card) {
    	this.card = card;
    }
    	
    /** 
     * 核销代码
     * @return 
     */ 
    public String getCode() {
    	return code;
    }
    
    /** 
     * 核销代码
     * @param 
     */ 
    public void setCode(String code) {
    	this.code = code;
    }
    	
    public String getAppointDateStr() {
    	return Common.DateLongToStr(appointDate);
    }
    
    public void setAppointDateStr(String appointDate) {
    	this.appointDate = Common.DateStrToLong(appointDate);
    }
}