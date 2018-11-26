<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Danh sách tỉnh </title>
    <s:head/>
</head>
<body>
<s:if test="proList.size() > 0">
    <div class="content">
        <table class="provinceTable" cellpadding="5px">
            <tr class="even">
                <th>Name</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <s:iterator value="cList" status="cStatus">
                <tr class="<s:if test="#cStatus.odd == true ">odd</s:if><s:else>even</s:else>">
                    <td><s:property value="name"/></td>
                    <td><s:url id="editURL" action="editClass">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url> <s:a href="%{editURL}">Edit</s:a></td>
                    <td><s:url id="deleteURL" action="deleteClass">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
</body>
</html>