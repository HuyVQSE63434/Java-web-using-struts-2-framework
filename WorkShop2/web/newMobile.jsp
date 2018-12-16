<%-- 
    Document   : newMobile
    Created on : Jun 20, 2018, 9:43:16 AM
    Author     : huyvqse63434
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Mobile jsp Page</title>
        <s:head/>
    </head>
    <body>        
        <h1>New Mobile</h1>
        <s:if test="%{#session.isEmpty()}">
            <jsp:forward page="login.html"/>
        </s:if>
        <s:form action="newMobile">
            <s:textfield name="txtNewMobileId" value="%{txtNewMobileId}" label="Mobile ID"/><br/>
            <s:textfield name="txtNewDescription" value="%{txtNewDescription}" label="Description"/><br/>
            <s:textfield name="txtNewPrice" value="%{txtNewPrice}"  label="Price"/><br/>
            <s:textfield name="txtNewMobileName" value="%{txtNewMobileName}" label="Mobile Name"  /><br/>
            <s:textfield name="txtNewYearOfProduction" value="%{txtNewYearOfProduction}" label="Year of production"/><br/>
            <s:textfield name="txtNewQuantity" value="%{txtNewQuantity}" label="Quantity" /><br/>
            <s:label value="Not Sale:"/>
            <s:checkbox name="chkNewNoteSale" value="%{chkNewNoteSale}"/><br/>
            <s:submit value="Add new mobile"/>
        </s:form><br/>
        <s:a href="searchForStaff.jsp">Back to Search Page</s:a><br/>
        <s:if test="%{exception.message.contains('duplicate')}">
            <font color="red"> <s:property value="%{txtNewMobileId}"/> is existed!!!!</font>
        </s:if>
        <s:if test="%{exception.message.contains('string')}">
            <font color="red">Price, Year of production,quantity must be number!!!!</font>
        </s:if>
        <s:if test="%{status !=null}">
            <font color="red"><s:property value="%{status}"/></font>
        </s:if>
    </body>
</html>
