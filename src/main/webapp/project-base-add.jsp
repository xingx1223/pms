<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加项目信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">

	//查询所有的用户公司列表
	$.ajax({
		type:"GET",
		url:"${pageContext.request.contextPath}/cus/jsonList",
		success:function (msg) {
		    $(msg).each(function (index,item) {
                var option="<option value='"+item.id+"'>"+item.comname+"</option>";
                //alert(item.comname);
				$("#cusList").append(option);
            })
        }
	});

	//查询所有的项目经理列表
    $.ajax({
        type:"GET",
        url:"${pageContext.request.contextPath}/emp/manager",
        success:function (msg) {
            $(msg).each(function (index,item) {
                var option="<option value='"+item.eid+"'>"+item.ename+"</option>";
                //alert(item.ename);
                //alert(item.comname);
                $("#manager").append(option);
            })
        },
		error:function () {
			alert("失败")
        }
    });

	function parseLeader(cid) {
		/*var cid = $(this).val();
		alert(cid);*/
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/cus/info/"+cid,
            success:function (msg) {
				$("#cusLeader").val(msg.companyperson);
            }
        });
    }

    function change(){
    }
    function commit(){
        //alert(1);
        var form = document.getElementById("forms");
        form.submit();
    }
</script>
</head>
<%-- background='${pageContext.request.contextPath}/skin/images/frame/bottombg.gif'--%>
<body leftmargin="8" topmargin="8">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
	<%--background="${pageContext.request.contextPath}/skin/images/frame/--%>
 <td height="26">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="forms" action="${pageContext.request.contextPath}/pro/saveInfo" method="POST">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/frame/topbg.gif">&nbsp;添加新项目信息&nbsp;</td>
</tr>
<tr>
	<td align="right" bgcolor="#FAFAF1" height="22" >项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="pname"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--<input type="" name="cuscompany"/>--%>
		<select name="comname" id="cusList" onchange="parseLeader(this.value)">
			<option>--请选择--</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text"  id="cusLeader" name="comper" readonly/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--<input type="text "name="manager"/>--%>
		<select name="empFk" id="manager">
			<%--<option></option>--%>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="empcount"/>人
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--<input type="text" name="sdate"/>--%>
		<input type="text" name="starttime" onClick="WdatePicker({minDate:'%y-%M-{%d}'})"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--<input type="text" name="buildtime"/>--%>
		<input type="text" name="buildtime" onClick="WdatePicker({minDate:'%y-%M-{%d}'})"/>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="cost"/>万
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select  name="level">
			<option value="紧急">紧急</option>
			<option value="一般">一般</option>
			<option value="暂缓">暂缓</option>
		</select>
	</td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--<input type="text" name="endtime"/>--%>
		<input type="text" name="endtime" onClick="WdatePicker({minDate:'%y-%M-{%d}'})"/>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130 onchange="change()" name="remark">
		</textarea>
		<span id="number"></span>
	</td>
</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<A class="coolbg" onclick="commit()" >保存</A>
	<a href="javascript:history.go(-1)" class="coolbg">返回</a>
</td>
</tr>
</table>
</form>
</body>
</html>