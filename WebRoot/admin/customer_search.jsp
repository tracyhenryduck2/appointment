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
			Dialog.opener().document.getElementById("name").value = $("#name").val()||"";    
			Dialog.opener().document.getElementById("appointDate").value = $("#appointDate").val()||"";    
			Dialog.opener().document.getElementById("phone").value = $("#phone").val()||"";    
			Dialog.opener().document.getElementById("number").value = $("#number").val()||"";    
			Dialog.opener().document.getElementById("card").value = $("#card").val()||"";    
			Dialog.opener().document.getElementById("code").value = $("#code").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "customerBean.name":{            
			        CNRangeLength:[0,45]
			    },                              
			    "customerBean.appointDate":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "customerBean.phone":{            
			        CNRangeLength:[0,45]
			    },                              
			    "customerBean.number":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "customerBean.card":{            
			        number:true,range:[0,9999999999]
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
<form name="form1" id="form1" action="#" method="post" target="fram" >   
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
    	<td align="right" width="30%" > 
                            预约日期<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.appointDate" id="appointDate"  value="${customerBean.appointDate}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            联系方式<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.phone" id="phone"  value="${customerBean.phone}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            人数<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.number" id="number"  value="${customerBean.number}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            卡务类型<span class="mark"></span>   
        </td>                            
        <td>                             
            <s:select list="#request.cList" emptyOption="true" cssClass="GF-field" name="customerBean.card" id="card"   theme="simple" listKey="id" listValue="name"  value="#request.customerBean.card" ></s:select>
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            核销代码<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="customerBean.code" id="code"  value="${customerBean.code}" class="GF-field"/>   
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
