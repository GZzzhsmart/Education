<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("msgContent") != null ? request.getParameter("msgContent") : "";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻公告</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/kindeditor/plugins/code/prettify.js"></script>
	<jsp:include page="/IncludeJS.jsp"></jsp:include>
	<link href="style/style.css" rel="stylesheet" type="text/css">
	<script>
		var editor1;
		KindEditor.ready(function(K) {
				editor1 = K.create('textarea[name="msgContent"]', {
				cssPath : '${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.request.contextPath}/jsp1/upload_json.jsp',
				fileManagerJson : '${pageContext.request.contextPath}/jsp1/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['newsform'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['newsform'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body onload="init();">
<%=htmlData%>
   <script type="text/javascript">
		function check(){
			if(form1.msgName.value=="")
			{
				alert("请输入新闻标题");
				form1.msgName.focus();
				return false;
			}
			if(form1.oneWord.value=="")
			{
				alert("请输入一句话");
				form1.oneWord.focus();
				return false;
			}
			if(editor1.isEmpty())
			{
				alert("请输入新闻内容");
				form1.msgContent.focus();
				return false;
			}
			return true;
		}
   		function init(){
			var d = new Date();
			var y = d.getFullYear();
			var m = d.getMonth()+1;
			var d =  d.getDate();
			$("#publishDate").datebox("setValue",y+"-"+m+"-"+d);
   		}
		function back(){
			location.href="${pageContext.request.contextPath }/newsAction!list.action";
		}
		if("${msg}"!=null&&"${msg}".length>0){
				alert("${msg}");
		}	
	</script>
		<table class="tablelist2">   	
	        <tbody>     
			<tr>
	        <td class="tableselect2" style="border-bottom:none;">
			 <div class="tools">
			  <ul class="toolbar">
			    <li class="click"><a href="${pageContext.request.contextPath }/newsMsgServlet?action=list"><i></i>返回</a></li>
			  </ul>
			 </div>
			</td>
	        </tr>        
	        </tbody>
		</table>
		<form name="form1" action="${pageContext.request.contextPath }/newsMsgServlet?action=add" id="newsform" method="post" enctype="multipart/form-data" onsubmit="return check();">
			<input type="hidden" name="newMsgId" id="id"/>
				 <table cellpadding="0" cellspacing="0" width="1000" style="margin: 0 auto">
	 				<tr height="30">
	 					<td align="right" width="90">公告名称</td>
	 					<td><input type="text" name="msgName" id="msgName"  style="width:100%"/></td>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">一句话</td>
	 					<td><input type="text" name="oneWord" id="oneWord"  style="width:100%"/></td>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">图片网址</td>
	 					<td><input type="file"  name="file1"/></td>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">类别</td>
	 					<td>
	 						<select name="newsType" id="newsType" style="width:155px">
								<option value="0" selected="selected">通知</option>
								<option value="1">公告</option>
							</select>
	 					</td>
	 				</tr>
	 				<tr>
	 					<td>&nbsp;</td>
	 					<td><textarea name="msgContent" id="msgContent" cols="100" rows="8" style="width:100%;height:500px;visibility:hidden;">
	 					<%=htmlspecialchars(htmlData)%></textarea>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">发布时间</td>
	 					<td><input type="text" name="publishDate" id="publishDate" class="easyui-datebox" style="width:155px"/><font size="2" color="red">*</font></td>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">排序</td>
	 					<td><input type="text" name="seq" id="seq"  style="width:155px"/><font size="2" color="red">大号排前</font></td>
	 				</tr>
	 				<tr height="30">
	 					<td align="right">状态</td>
	 					<td>
						<select name="effective" id="effective" style="width:155px">
							<option value="1" selected="selected">有效</option>
							<option value="0">无效</option>
						</select>
						</td>
	 				</tr>
	 				<tr style="background-image: url('images/maintitle.jpg')">
	 					<td></td>
	 					<td align="center"><input type="submit" value="  发  布  " name="isEmpty"></td>
	 				</tr>
	 			</table>
		</form>
	</body>
</html>

<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>