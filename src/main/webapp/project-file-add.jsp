<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加附件</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//查询所有项目列表
	$(function () {
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/pro/jsonList",
			success:function (msg) {
				$(msg).each(function (index, item) {
					var option="<option value='"+item.pid+"'>"+item.pname+"</option>";
					$("#proList").append(option);
                })
            }
		})
    })
	function commit() {
		/*$("#form2").submit();*/
		//异步
		//获取数据
		var pid=$("#proList").val();
        var attname=$("#attname").val();
        var attdis=$("#attdis").val();
        var file=$("#file")[0].files[0];
        var remark=$("#remark").val();

		var formdata=new FormData();

		//存储在formdata里
		formdata.append("proFk",pid);
		formdata.append("attname",attname);
        formdata.append("attdis",attdis);
        formdata.append("attachment",file);
        formdata.append("remark",remark);

        $.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/attachment/addAttach",
			data:formdata,
			cache:false,
			processData:false,
			contentType:false,
			success:function (msg) {
				if (msg.statusCode == 200) {
				    window.location.href="${pageContext.request.contextPath}/project-file.jsp";
                }else {
                    if (confirm("确定要离开该页面吗？")) {
                        window.location.href="${pageContext.request.contextPath}/project-file.jsp";
                    }
                }
            }
		})
    }
	/*导出文件*/
    function importExcel(){
        var formData=new FormData();
        //定时器判断是否获取到文件
        var result =setInterval(function () {
            var file= $("#file")[0].files[0];
            //获取到文件之后，取消定时器，并异步文件上传
            if(file != undefined){
                clearInterval(result);
                formData.append("excel",file);
                //异步上传excel
                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/cust/importExcel",
                    cache: false,
                    processData: false,
                    contentType:false,
                    data:formData,
                    success:function(msg){
                        alert(msg.message);
                    }
                });
            }
        },1000)
        return false;
    }
</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>添加附件
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<%--
1.查询所有项目:项目ajax请求
上传的前后端要求：
--%>
<form name="form2" id="form2" action="${pageContext.request.contextPath}/attachment/addAttach" method="post" enctype="multipart/form-data">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加附件&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="proFk" id="proList">
			<option>--请选择--</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="26" name="attname" id="attname"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件信息描述：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input size="52" name="attdis" id="attdis"/>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">附件：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="file" name="attachment" id="file"/>
	</td>
</tr>


<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark" id="remark"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
	<a href="project-file.jsp" class="coolbg">返回</a>

</td>
</tr>
</table>

</form>
  

</body>
</html>