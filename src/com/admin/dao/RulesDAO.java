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
}                       
