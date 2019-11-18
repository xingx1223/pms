<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>项目信息管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function selectAll() {
            $("input:checkbox").prop("checked","true");
        }
        function reverseChoose() {
            $("input:checkbox").each(function () {
                var checked=$(this).prop("checked");
                $(this).prop("checked",!checked);
            })
        }
        function batchDel() {
            var ids=[];
            $("input:checked").each(function () {
                var id=$(this).val();
                ids.push(id);
                //alert(id)
            })

            alert(ids);

            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/pro/del",
                data:{"_method":"DELETE","ids":ids},
                success:function (msg) {
                    if (msg.statusCode == 200) {
                        window.location="${pageContext.request.contextPath}/pro/list";
                    }else{
                        alert(msg.message);
                        window.location="${pageContext.request.contextPath}/pro/list";
                    }
                },
                error:function () {
                    alert("删除失败")
                    window.location="${pageContext.request.contextPath}/pro/list";
                }
            })
        }

        function exprotExcel() {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/pro/exportExcel",
                success:function (msg) {
                    if (msg.code==200){
                        alert(msg.message)
                        //window.location.href="${pageContext.request.contextPath}/project-base.jsp";
                    }else{
                        alert("失败")
                    }
                }
            })
        }
    </script>
</head>
<%--background='${pageContext.request.contextPath}/skin/images/allbg.gif'--%>
<body leftmargin="8" topmargin="8" >

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
    <%--background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif"
     background="${pageContext.request.contextPath}/skin/images/frame/sp_bg.gif"--%>
 <td height="26">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>基本信息管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/project-base-add.jsp';" value='添加新项目' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='${pageContext.request.contextPath}/pro/search' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='${pageContext.request.contextPath}/skin/images/frame/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150px'>
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>项目经理</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='0'>正序</option>
            <option value='1'>倒序</option>
<%--            <option value='pubdate'>计划完成时间</option>--%>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/frame/topbg.gif">&nbsp;项目信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">项目名称</td>
	<td width="10%">客户公司名称</td>
	<td width="10%">客户方负责人</td>
	<td width="5%">项目经理</td>
	<td width="8%">开发人员数</td>
	<td width="6%">立项时间</td>
	<td width="8%">最近更新时间</td>
	<td width="8%">计划完成时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>

    <c:forEach items="${list}" var="project" varStatus="index" >
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td><input name="id" type="checkbox" id="id" value="${project.pid}" class="np"></td>
            <td>${index.count}</td>
            <td align="left"><a href=''><u>${project.pname}</u></a></td>
            <td>${project.customer.comname}</td>
            <td>${project.customer.companyperson}</td>
            <td>${project.employee.ename}</td>
            <td>${project.empcount}</td>
            <td>
                <fmt:formatDate value="${project.starttime}" pattern="yyyy-MM-dd"/>
            </td>
            <td>
                <fmt:formatDate value="${project.buildtime}" pattern="yyyy-MM-dd"/>
            </td>
            <td>
                <fmt:formatDate value="${project.endtime}" pattern="yyyy-MM-dd"/>
            </td>
            <td>${project.remark}</td>
            <td><a href="${pageContext.request.contextPath}/pro/selectProById/${project.pid}">编辑</a> | <a href="${pageContext.request.contextPath}/pro/proDetialById/${project.pid}">查看详情</a></td>
        </tr>
    </c:forEach>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:selectAll()" class="coolbg">全选</a>
	<a href="javascript:reverseChoose()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:batchDel()" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="javascript:exprotExcel()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<%--<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>--%>
    <%--<jsp:include page="page.jsp"></jsp:include>--%>
</table>

</form>
</body>
</html>