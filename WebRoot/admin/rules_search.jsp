<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%                                       
String path = request.getContextPath();  
%>                                       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>                                   
<title></title>                          
<script type="text/javascript">        
	function search(){                          
			Dialog.opener().document.getElementById("startDate").value = $("#startDate").val()||"";    
			Dialog.opener().document.getElementById("endDate").value = $("#endDate").val()||"";    
			Dialog.opener().document.getElementById("type").value = $("#type").val()||"";    
			Dialog.opener().document.getElementById("number").value = $("#number").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "rulesBean.startDate":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "rulesBean.endDate":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "rulesBean.type":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "rulesBean.number":{            
			        number:true,range:[0,9999999999]
			    }                              
			},                                  
			messages:{                          
//			    "rulesBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="#" method="post" target="fram" >   
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            起始日期<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.startDate" id="startDate"  value="${rulesBean.startDate}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            结束日期<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.endDate" id="endDate"  value="${rulesBean.endDate}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            类型<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.type" id="type"  value="${rulesBean.type}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            最大人数<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.number" id="number"  value="${rulesBean.number}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="查询" value="查询" onclick="search();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
