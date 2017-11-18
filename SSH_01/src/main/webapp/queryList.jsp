<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'queryList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table border="1" width="50%">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>password</th>
			<th>birthday</th>
		</tr>
		<s:if test="list.size>0">
			<s:iterator value="list">
				<tr>
					<th><s:property value="id"/></th>
					<th><s:property value="username"/></th>
					<th><s:property value="password"/></th>
					<th><s:property value="birthday"/></th>
				</tr>

			</s:iterator>
		</s:if>
		

	</table>
	<s:if test="zys!=0">
		   <s:iterator begin="1" step="1" end="zys" var="i">
		     <a href="queryList.action?ym=<s:property value='#i'/>"><s:property value="#i"/></a>&nbsp;&nbsp;&nbsp;
		   
		   </s:iterator>
		
		</s:if>
</body>
</html>
