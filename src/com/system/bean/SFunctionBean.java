package com.system.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 功能
 * @author xin.chou
 *
 */
@Table(name="s_function")
public class SFunctionBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 名称 
	*/
	@Column(name="name")
	private String name;

	/**
	 * 地址 
	*/
	@Column(name="url")
	private String url;

	/**
	 * 模块 
	*/
	@Column(name="group_id")
	private Long groupId;

	/**
	 * 排序 
	*/
	@Column(name="sort_id")
	private Long sortId;

    /** 
     * 
     * @return 
     */ 
    public Long getId() {
    	return id;
    }
    
    /** 
     * 
     * @param 
     */ 
    public void setId(Long id) {
    	this.id = id;
    }
    	
    /** 
     * 名称
     * @return 
     */ 
    public String getName() {
    	return name;
    }
    
    /** 
     * 名称
     * @param 
     */ 
    public void setName(String name) {
    	this.name = name;
    }
    	
    /** 
     * 地址
     * @return 
     */ 
    public String getUrl() {
    	return url;
    }
    
    /** 
     * 地址
     * @param 
     */ 
    public void setUrl(String url) {
    	this.url = url;
    }
    	
    /** 
     * 模块
     * @return 
     */ 
    public Long getGroupId() {
    	return groupId;
    }
    
    /** 
     * 模块
     * @param 
     */ 
    public void setGroupId(Long groupId) {
    	this.groupId = groupId;
    }
    	
    /** 
     * 排序
     * @return 
     */ 
    public Long getSortId() {
    	return sortId;
    }
    
    /** 
     * 排序
     * @param 
     */ 
    public void setSortId(Long sortId) {
    	this.sortId = sortId;
    }

    
    
}