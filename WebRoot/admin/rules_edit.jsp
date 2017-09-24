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
 var isCommit=false 
	function save(){                        
		if($("#form1").valid()) {           
        if(isCommit==false){   
         isCommit=true       
			form1.submit();                     
      }                 
		}                                     
	}                                       
	                                        
	function result(messageType, message){  
		if(messageType=="error"){           
			Dialog.error(message);				      
		} else if (messageType == "reload_success") {   
			Dialog.alert(message,function(){    
				Dialog.opener().location.reload(); //;= "<%=path%>/admin/Rules!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "rulesBean.date":{            
			        required : true,number:true,range:[0,9999999999]
			    },                                                          
			    "rulesBean.type":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "rulesBean.number":{            
			        required : true,number:true,range:[0,9999999999]
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
<form name="form1" id="form1" action="<%=path %>/admin/Rules!addRules.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="rulesBean.id" id="id" value="${rulesBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            规则日期<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.date" id="date"  value="${rulesBean.date}" class="GF-field"/>   
        </td>                            
  </tr>                                                                
  <tr>                                    
    	<td align="right" > 
                            类型<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.type" id="type"  value="${rulesBean.type}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            最大人数<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="rulesBean.number" id="number"  value="${rulesBean.number}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="提交" value="提交" onclick="save();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
