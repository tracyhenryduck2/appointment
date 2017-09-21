package com.admin.action;

import java.util.List;
import java.util.Map;
import com.admin.bean.RulesBean;
import com.admin.dao.RulesDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 规则
 * @author xin.chou
 *
 */
public class RulesAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private RulesDAO dao = new RulesDAO(); 
    private RulesBean rulesBean = new RulesBean();    
    private final String tableDesc = "规则";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddRules() {
        if ("1".equals(oper)) {   
    	    rulesBean = dao.select(RulesBean.class,rulesBean.getId());  
    	}    
    	return "toAddRules";    
    } 
 
    /**    
     * 新增
     */    
    public String addRules() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(rulesBean); 
            } else { 
                result = dao.insert(rulesBean); 
            }
            if (result) {  
                showMessage += "成功";  
                return reload_success; 
            } else {
                showMessage += "失败";  
                return error;   
            }  
        } catch (Exception e) {    
            showMessage = "数据异常，操作失败";   
            return error;  
        } 
    } 
 
    /**    
     * 编辑部分字段专用
     * @return
     */
    public String addTest2(){
        showMessage = "编辑2"+tableDesc;
        String[] param={
            "id","startDate","endDate","type","number"
        };
        boolean result=dao.update(rulesBean,param);
        if (result) { 
            showMessage += "成功";
            return reload_success;
        } else {
            showMessage += "失败"; 
           return error; 
        }
    }
    /**    
     * 删除操作 
     */    
    public String delRules() {  
    	try {
    		boolean result = dao.delete(RulesBean.class,rulesBean.getId());  
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
 
 
    /**    
     * 删除操作 
     */    
    public String delRuless() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(RulesBean.class,ids);
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
    public String search() {
        return "search"; 
    }
 
    /**    
     * 查询列表页面  
     * @return  
     */    
    public String list() {
    	page.execute(request, "ID", "desc");
    	List<Map<String, Object>> list = dao.getPageList(page, rulesBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public RulesBean getRulesBean() { 
    	return rulesBean;    
    } 
 
    public void setRulesBean(RulesBean rulesBean) {   
    	this.rulesBean = rulesBean;
    } 
}
