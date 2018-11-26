<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Danh sách lớp</title>
    <s:head/>
</head>
<body>
<s:form action="saveOrUpdateClass">
    <s:push value="c">
        <s:hidden name="id"/>
        <s:textfield name="name" label="Class Name"/>
        <s:submit/>
    </s:push>
</s:form>
</body>
</html>