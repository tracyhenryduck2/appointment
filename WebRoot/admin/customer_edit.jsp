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
				Dialog.opener().location.reload(); //;= "<%=path%>/admin/Customer!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "customerBean.name":{            
			        CNRangeLength:[0,45]
			    },                              
			    "customerBean.appointDate":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "customerBean.phone":{            
			        required : true,CNRangeLength:[0,45]
			    },                              
			    "customerBean.number":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "customerBean.card":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "customerBean.code":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "customerBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/admin/Customer!addCustomer.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="customerBean.id" id="id" value="${customerBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            客户名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.name" id="name"  value="${customerBean.name}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            预约日期<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.appointDate" id="appointDate"  value="${customerBean.appointDate}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            联系方式<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.phone" id="phone"  value="${customerBean.phone}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            人数<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.number" id="number"  value="${customerBean.number}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            卡务类型<span class="mark">*</span>   
        </td>                            
        <td>                             
            <s:select list="#request.cList"  cssClass="GF-field" name="customerBean.card" id="card"   theme="simple" listKey="id" listValue="name"  value="#request.customerBean.card" ></s:select>
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            核销代码<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.code" id="code"  value="${customerBean.code}" class="GF-field"/>   
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
