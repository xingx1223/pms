<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<base href="${pageContext.request.contextPath}">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">

        //查询所有的项目
        $(function () {
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/pro/jsonList",
				success:function (msg) {
					$(msg).each(function (index, item) {
						var option="<option value='"+item.pid+"'>"+item.pname+"</opiton>";
						$("#projects").append(option);
                    });
                }
			});
			$.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/emp/getEnameList",
                success:function (msg) {
                    $(msg).each(function (index, item) {
                        var option="<option value='"+item.eid+"'>"+item.ename+"</opiton>";
                        $("#emps").append(option);
                    });
                }
            })
        })
		function selectAnalysis(pid) {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/analysis/selectAnalById/"+pid,
                success:function (msg) {
                    $("#analysis").html("<option value=''>请选择</option>");
                    var option="<option value='"+msg.id+"'>"+msg.title+"</opiton>";
                    $("#analysis").append(option);
                }
            });
        }
        function selectModules(aid) {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/model/selectModelsById/"+aid,
                success:function (msg) {
                    $("#modules").html("<option value=''>请选择</option>");
                    $(msg).each(function (index, item) {
                        var option="<option value='"+item.id+"'>"+item.modname+"</opiton>";
                        $("#modules").append(option);
                    });
                }
            });
        }
        function selectFunctions(mid) {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/func/selectFuncsById/"+mid,
                success:function (msg) {
                    $("#funFk").html("<option value=''>请选择</option>");
                    $(msg).each(function (index, item) {
                        var option="<option value='"+item.id+"'>"+item.functionname+"</opiton>";
                        $("#funFk").append(option);
                    });
                }
            });
        }
        function commit() {
            $("#form2").submit();
        }
	</script>

    <base href="${pageContext.request.contextPath}">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/task/addTask" method="POST">

    <input type="hidden" name="empFk" value="${loginUser.eid}">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="" id="projects" onchange="selectAnalysis(this.value)">
			<option>请选择</option>
			<%--<option value=1>农业银行自助管理系统</option>--%>
		</select>
		-
		<select name="" id="analysis" onchange="selectModules(this.value)">
			<option value=1>请选择</option>
			<%--<option value=1>帐户管理需求分析</option>--%>
		</select>
		-
		<select id="modules" onchange="selectFunctions(this.value)">
			<option value=1>请选择</option>
			<%--<option value=1>帐户管理模块</option>--%>
		</select>
		-
		<select name="funFk" id="funFk">
			<option value=1>请选择</option>
			<%--<option value=1>添加帐户功能</option>--%>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
        <input name="tasktitle"/></td>
</tr>
<tr>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="starttime"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input name="endtime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="empFk2" id="emps">
			<%--<option value=1>张含馨--初级程序员</option>
			<option value=1>张&nbsp;&nbsp;伟--中级程序员</option>
			<option value=1>孙传杰--项目经理</option>--%>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level">
			<option value="高">高</option>
			<option value="中">中</option>
			<option value="低">低</option>
			<option value="暂缓">暂缓</option>
		</select>
	</td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark"></textarea>
	</td>
</tr>

<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>