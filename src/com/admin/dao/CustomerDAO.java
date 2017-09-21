package com.admin.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.admin.bean.CustomerBean;
                        
/**                     
 *                      
 * 客户表 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class CustomerDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, CustomerBean customerBean) {   
    	String sql ="select a.* from customer a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(customerBean!=null) { 
    		if(customerBean.getId() != null) { 
    			objectList.add(customerBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(customerBean.getName() != null && customerBean.getName().trim().length()>0) { 
    			objectList.add(customerBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(customerBean.getAppointDate() != null) { 
    			objectList.add(customerBean.getAppointDate());
    			sqlWhere += " AND a.appoint_date = ? ";
    		} 
    		if(customerBean.getPhone() != null && customerBean.getPhone().trim().length()>0) { 
    			objectList.add(customerBean.getPhone());
    			sqlWhere += " AND a.phone = ? ";
    		} 
    		if(customerBean.getNumber() != null) { 
    			objectList.add(customerBean.getNumber());
    			sqlWhere += " AND a.number = ? ";
    		} 
    		if(customerBean.getCard() != null) { 
    			objectList.add(customerBean.getCard());
    			sqlWhere += " AND a.card = ? ";
    		} 
    		if(customerBean.getCode() != null && customerBean.getCode().trim().length()>0) { 
    			objectList.add(customerBean.getCode());
    			sqlWhere += " AND a.code = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from customer a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }  
    
    public List<Map<String,Object>> getList(){
    	  
    	return j.queryForList("select * from card");
    }
}                       
