package com.admin.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.admin.bean.RulesBean;
import com.admin.dao.RulesDAO;
import com.common.Common;
import com.common.BaseActionSupport;
import com.common.Static;

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
	 * XXXX-XX月的规则列表
	 * http://SERVER[:PORT]/PROJECTNAME/admin/Rules!monthRulesList.action?month=xxxx-xx
	 * @return
	 */
	public void monthRulesList(){
        
		String month = request.getParameter("month")+"";
		
		String timestart = month+"-01 00:00:00";
		Date datestart = null;
		try {
			datestart = df.parse(timestart);

		Long timechuo_start = datestart.getTime()/1000;
		Calendar   calendar   =   Calendar.getInstance();
		calendar.setTime(datestart);
		calendar.add(Calendar.MONTH, 1);
		
		Long timechuo_end = calendar.getTime().getTime()/1000;
		
		
		List<Map<String,Object>> list=dao.getRuleslist(timechuo_start,timechuo_end);
		calendar.add(Calendar.MONTH, -1);
		System.out.println("calendar.get(Calendar.MONTH):"+calendar.get(Calendar.MONTH));
		int monthday = 0;
		if(calendar.get(Calendar.YEAR)%400 == 0 || calendar.get(Calendar.YEAR)%4 == 0){
			
			monthday = Static.PER_MONTH_DAYS_LEAP[calendar.get(Calendar.MONTH)];	
		}else{
			monthday = Static.PER_MONTH_DAYS[calendar.get(Calendar.MONTH)];
		}
		List<Map<String,Object>> listnew = new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<monthday;i++){
			boolean flag = false;
			Map<String,Object> map2 = new HashMap<String,Object>();
			for(Map<String,Object> map : list){
				
		
				Integer ds =(Integer)map.get("date");
				long ds2 = ((long)ds)*1000l;
				Date date = new Date(ds2);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				int d = c.get(Calendar.DAY_OF_MONTH);
				if((i+1)== d){
					flag = true;
					map2.put("type", map.get("type"));
					map2.put("number", map.get("number"));
					map2.put("date",i);
					break;
				}
			}
			if(!flag){
				map2.put("type", 0);
				map2.put("number", 0);
				map2.put("date",i);
			}
			listnew.add(map2);
		}

		outPrintJSON(listnew);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
