<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>规则</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">  
	<link href="../datewidget/all.css" rel="stylesheet" type="text/css"/>
    <link href="../datewidget/skin.css" rel="stylesheet" type="text/css"/>
    <link href="../datewidget/fontSize12.css" rel="stylesheet" type="text/css"/>
    <link href="../datewidget/calendar.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
#operation td {
	padding: 5px;
    border: 1px solid black;
}
input.button6{
	box-sizing: border-box;
	    align-items: flex-start;
    text-align: center;
    cursor: default;
    color: buttontext;
    background-color: buttonface;
    box-sizing: border-box;
    padding: 2px 6px 3px;
    border-width: 2px;
    border-style: outset;
    border-color: buttonface;
    border-image: initial;
}

    </style>
    <script type="text/javascript" src="../js/jquery1.9.js"></script>
    <script type="text/javascript" src="../js/calendar.js"></script>
    <script type="text/javascript" src="../js/layer.js"></script>  
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:600, Height:360, URL:"<%=path%>/admin/Rules!toAddRules.action"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:600, Height:360, URL:"<%=path%>/admin/Rules!toAddRules.action?oper=1&rulesBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:500, Height:360, URL:"<%=path%>/admin/Rules!toAddRules.action?read=1&oper=1&rulesBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/admin/Rules!delRuless.action";
				form1.target = "fram";
				form1.submit();  
				form1.action = action_tmp;     
				form1.target = "";    
			}, function(){     
				//�?      
			});  
		}      
		
		function result(type, message) {   
			if("reload_success" == type) { 
				Dialog.alert(message,function(){      
					form1.submit();
				});
			} else if("error" == type) {   
				Dialog.error(message);  
			}    
		}      
		function search() {  
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/admin/Rules!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("date").value = $("#date").val();
			     this.innerDoc.getElementById("type").value = $("#type").val();
			     this.innerDoc.getElementById("number").value = $("#number").val();
           }
			});    
		}      
		




	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="规则" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">     
	  	<GF:ToolBarItem id="search" label="查询" ico="images/ico/search.gif" onclick="search();" />    
	  	<GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> 
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="export" label="导出" ico="images/ico/export.gif" onclick="exportExcel();"/>
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>  
	</GF:ToolBar>   
<div class="main">
    <div class="pathBar" style="margin-bottom:2px;">
        <div class="pathBarPos">

        </div>
    </div>

    <div id="myrl" style="width:820px; margin-left:auto; margin-right:auto; height:840px; overflow:hidden;">
        <form name=CLD>
            <TABLE id="func" class="biao" width="800px">
                <TBODY>
                <TR>
                    <TD class="calTit" colSpan=7 style="height:30px;padding-top:3px;text-align:center;">

                        <a href="#" title="上一年" id="nianjian" class="ymNaviBtn lsArrow"></a>
                        <a href="#" title="上一月" id="yuejian" class="ymNaviBtn lArrow"></a>

                        <div style="width:250px; float:left; padding-left:230px;">
                                            <span id="dateSelectionRili" class="dateSelectionRili"
                                                  style="cursor:hand;color: white; border-bottom: 1px solid white;"
                                                  onclick="dateSelection.show()">
											<span id="nian" class="topDateFont"></span><span
                                                    class="topDateFont">年</span><span id="yue"
                                                                                      class="topDateFont"></span><span
                                                    class="topDateFont">月</span>
											<span class="dateSelectionBtn cal_next"
                                                  onclick="dateSelection.show()">▼</span></span> &nbsp;&nbsp;<font id=GZ
                                                                                                                   class="topDateFont"></font>
                        </div>

                        <!--新加导航功能-->
                        <div style="left: 250px; display: none;" id="dateSelectionDiv">
                            <div id="dateSelectionHeader"></div>
                            <div id="dateSelectionBody">
                                <div id="yearList">
                                    <div id="yearListPrev" onclick="dateSelection.prevYearPage()">&lt;</div>
                                    <div id="yearListContent"></div>
                                    <div id="yearListNext" onclick="dateSelection.nextYearPage()">&gt;</div>
                                </div>
                                <div id="dateSeparator"></div>
                                <div id="monthList">
                                    <div id="monthListContent"><span id="SM0" class="month"
                                                                     onclick="dateSelection.setMonth(0)">1</span><span
                                            id="SM1" class="month" onclick="dateSelection.setMonth(1)">2</span><span
                                            id="SM2" class="month" onclick="dateSelection.setMonth(2)">3</span><span
                                            id="SM3" class="month" onclick="dateSelection.setMonth(3)">4</span><span
                                            id="SM4" class="month" onclick="dateSelection.setMonth(4)">5</span><span
                                            id="SM5" class="month" onclick="dateSelection.setMonth(5)">6</span><span
                                            id="SM6" class="month" onclick="dateSelection.setMonth(6)">7</span><span
                                            id="SM7" class="month" onclick="dateSelection.setMonth(7)">8</span><span
                                            id="SM8" class="month" onclick="dateSelection.setMonth(8)">9</span><span
                                            id="SM9" class="month" onclick="dateSelection.setMonth(9)">10</span><span
                                            id="SM10" class="month" onclick="dateSelection.setMonth(10)">11</span><span
                                            id="SM11" class="month curr" onclick="dateSelection.setMonth(11)">12</span>
                                    </div>
                                    <div style="clear: both;"></div>
                                </div>
                                <div id="dateSelectionBtn">
                                    <div id="dateSelectionTodayBtn" onclick="dateSelection.goToday()">今天</div>
                                    <div id="dateSelectionOkBtn" onclick="dateSelection.go()">确定</div>
                                    <div id="dateSelectionCancelBtn" onclick="dateSelection.hide()">取消</div>
                                </div>
                            </div>
                            <div id="dateSelectionFooter"></div>
                        </div>
                        <a href="#" id="nianjia" title="下一年" class="ymNaviBtn rsArrow" style="float:right;"></a>
                        <a href="#" id="yuejia" title="下一月" class="ymNaviBtn rArrow" style="float:right;"></a>
                        <!--	<a id="jintian" href="#" title="今天" class="btn" style="float:right; margin-top:-2px; font-size:12px; text-align:center;">今天</a>-->

                    </TD>
                </TR>
                <TR class="calWeekTit" style="font-size:12px; height:20px;text-align:center;">
                    <TD width="100" class="red">星期日</TD>
                    <TD width="100">星期一</TD>
                    <TD width="100">星期二</TD>
                    <TD width="100">星期三</TD>
                    <TD width="100">星期四</TD>
                    <TD width="100">星期五</TD>
                    <TD width="100" class="red">星期六</TD>
                </TR>
                <SCRIPT language="JavaScript">

                    var gNum;
                    for (var i = 0; i < 6; i++) {
                        document.write('<tr align=center height="50" id="tt">');
                        for (var j = 0; j < 7; j++) {
                            gNum = i * 7 + j ;
                            <!--onMouseOver="mOvr(this,' + gNum + ');"  onMouseOut="mOut(this);"-->
                            document.write('<td  id="GD' + gNum + '" on="0" ><font  id="SD' + gNum + '" style="font-size:22px;"  face="Arial"');
                            if (j == 0)  document.write('color=red');
                            if (j == 6)
                                if (i % 2 == 1)  document.write('color=red');
                                else  document.write('color=red');
                            document.write('  TITLE="">  </font><br><font  id="LD' + gNum + '"  size=2  style="white-space:nowrap;overflow:hidden;cursor:default;">  </font></td>');
                        }
                        document.write('</tr>');
                    }
                </SCRIPT>
                </tbody>
            </TABLE>
            <table class="biao" width="800px">
            <tr>
              <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr align="center">
                    <td><input type=button value="元旦节" class="button6"  onclick=dateSelection.goHoliday(0)></td>
                    <td><input type=button value='春  节' class="button6"  onclick=dateSelection.goHoliday(1)></td>
                    <td><input type=button value='清明节' class="button6"  onclick=dateSelection.goHoliday(3)></td>
                    <td><input type=button value='五一节' class="button6"  onclick=dateSelection.goHoliday(4)></td>
                    <td><input type=button value='端午节' class="button6"  onclick=dateSelection.goHoliday(5)></td>
                    <td><input type=button value='中秋节' class="button6"  onclick=dateSelection.goHoliday(8)></td>
                    <td><input type=button value="国庆节" class="button6"  onclick=dateSelection.goHoliday(9)></td>
                  </tr>
              </table></td>
            </tr>
          </table>
          <table id="operation"  border="1"  cellpadding="5" cellspacing="5">
            <tr align="center">
            	<td><input type=button value='提交' class="button6"  onclick=h_submit()></td>
              <td><input type=button value="重置" class="button6"  onclick=rebuild()></td>
              <td width="25" height="25" bgcolor="#FBBB67">&nbsp;</td>
              <td>假　期&nbsp;&nbsp;</td>
              <td width="25" bgcolor="#FFFFFF">&nbsp;</td>
              <td>工作日&nbsp;&nbsp;</td>
              <td width="25" bgcolor="#CFDFF0">&nbsp;</td>
              <td>今 日</td>
              </tr>
          </table>
        </form>
    </div>
</div>
<SCRIPT language="JavaScript">
	//提交
function h_submit(){
	alert(hDays);
}
  //重置
 function rebuild(){
	hDays=[];
  layer.alert(layer.v + ' - 贤心出品 sentsin.com');
}     


 </SCRIPT>
<div id="details" style="margin-top:-1px;"></div>
   </GF:BodyCaption>    
   <iframe name="fram" id="fram" style="display:none"></iframe>    
  </body> 
</html>   
