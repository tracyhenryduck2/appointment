package com.admin.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private String date = null;
    private final  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddRules() {
    	
        List<Map<String, Object>> cList = dao.getList();
        request.setAttribute("cList", cList);
        if ("1".equals(oper)) {   
    	    rulesBean = dao.select(RulesBean.class,rulesBean.getId());  
    	}else if(date!=null){
    		try {
				System.out.println("date == "+date);
				Date date2 = df.parse(date+" 00:00:00");
				Long d =date2.getTime()/1000;
				rulesBean = dao.getRulesByDate(d);
				if(rulesBean == null){
					rulesBean = new RulesBean();
					rulesBean.setDate(d);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                showMessage += "时间格式有误";  
                return error;  
			}
    	}    
    	return "toAddRules";    
    } 
 
    /**    
     * 新增
     */    
    public String addRules() {  
        try {   
            showMessage = "制定"+tableDesc; 
            boolean result = false;  
            
            int d = dao.getRulesNumByDate(rulesBean.getDate());
            if(d>0){
                result = dao.update(rulesBean); 
            }else{
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
