<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Đăng nhập</title>
</head>
<body>
<h3>Đăng nhập</h3>
<s:form action="processLogin">
    <s:textfield name="email" label="Email"></s:textfield>
    <s:textfield name="password" label="Mật khẩu" type="password"></s:textfield>
    <s:submit value="Đăng nhập"></s:submit>
</s:form>
</body>
</html>