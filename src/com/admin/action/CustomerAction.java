package com.admin.action;

import java.util.List;
import java.util.Map;
import com.admin.bean.CustomerBean;
import com.admin.dao.CustomerDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 客户表
 * @author xin.chou
 *
 */
public class CustomerAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private CustomerDAO dao = new CustomerDAO(); 
    private CustomerBean customerBean = new CustomerBean();    
    private final String tableDesc = "客户表";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddCustomer() {
        List<Map<String, Object>> cList = dao.getList();
        request.setAttribute("cList", cList);
        if ("1".equals(oper)) {   
    	    customerBean = dao.select(CustomerBean.class,customerBean.getId());  
    	}    
    	return "toAddCustomer";    
    } 
 
    /**    
     * 新增
     */    
    public String addCustomer() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(customerBean); 
            } else { 
                result = dao.insert(customerBean); 
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
            "id","name","appointDate","phone","number","card"
            ,"code"
        };
        boolean result=dao.update(customerBean,param);
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
    public String delCustomer() {  
    	try {
    		boolean result = dao.delete(CustomerBean.class,customerBean.getId());  
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
    public String delCustomers() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(CustomerBean.class,ids);
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
    	List<Map<String, Object>> list = dao.getPageList(page, customerBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public CustomerBean getCustomerBean() { 
    	return customerBean;    
    } 
 
    public void setCustomerBean(CustomerBean customerBean) {   
    	this.customerBean = customerBean;
    } 
}
