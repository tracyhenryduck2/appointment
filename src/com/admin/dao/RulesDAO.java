package com.admin.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.admin.bean.RulesBean;
                        
/**                     
 *                      
 * 规则 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class RulesDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, RulesBean rulesBean) {   
    	String sql ="select a.* from rules a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(rulesBean!=null) { 
    		if(rulesBean.getId() != null) { 
    			objectList.add(rulesBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(rulesBean.getDate() != null) { 
    			objectList.add(rulesBean.getDate());
    			sqlWhere += " AND a.date = ? ";
    		} 
    		if(rulesBean.getType() != null) { 
    			objectList.add(rulesBean.getType());
    			sqlWhere += " AND a.type = ? ";
    		} 
    		if(rulesBean.getNumber() != null) { 
    			objectList.add(rulesBean.getNumber());
    			sqlWhere += " AND a.number = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from rules a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }
    
    public RulesBean getRulesByDate(Long date){
    	String sql = "select * from rules where date = "+ date;
    	
    	return j.queryForBean(RulesBean.class, sql);
    	
    }
    
    public int getRulesNumByDate(Long date){
    	String sql = "select count(*) from rules where date = "+ date;
    	
    	return j.queryForInteger(sql);
    	
    }
    
    
    public List<Map<String,Object>> getList(){
  	  
    	return j.queryForList("select * from card");
    }
    
    public List<Map<String,Object>> getRuleslist(Long starttime,Long endtime){
    	
    	Object[] ds = {starttime,endtime};
    	
    	String sql = "select type,number,date from rules where date >=? and date <?";
    	
    	return j.queryForList(sql, ds);
    }
}                       
