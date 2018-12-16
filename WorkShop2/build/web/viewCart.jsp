<%-- 
    Document   : viewCart
    Created on : Jun 20, 2018, 8:00:48 PM
    Author     : huyvqse63434
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>viewCart Page</title>
    </head>
    <body>
        welcome,
        <s:property value="%{#session.username}"/>
        <s:if test="%{#session.isEmpty()}">
            <jsp:forward page="login.html"/>
        </s:if>
        <s:url id="signout" action="signout"/><br/>
        <s:a href="signout">sign out</s:a>
            <h3><font color="red">YOUR CARTS</font></h3>
            <s:if test="%{#session.carts !=null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <s:form action="removeItem" theme="simple">
                        <s:iterator value="%{#session.carts.items}" status="counter">
                            <tr>
                                <td> <s:property value="%{#counter.count}" /> </td>
                                <td> <s:property value="%{key[0]}"/> </td>
                                <td> <s:property value="%{key[1]}"/> </td>
                                <td> <s:property value="%{value}"/> </td>
                                <td><s:checkbox name="chkItem" fieldValue="%{key[0]}"/></td>
                            </tr>
                        </s:iterator>
                        <tr>
                            <td colspan="4">
                                <s:a href="savetoDatabase">Save Carts to Database</s:a>
                                </td>
                                <td> <s:submit value="Remove Item"/> </td>
                        </tr>
                    </s:form>
                </tbody>
            </table>
        </s:if>
        <s:a href="searchForUser.jsp">Add more to carts</s:a>
        <s:if test="%{saved!=null}">
            <font color="red"><s:property value="%{saved}"/></font>
        </s:if>
    </body>
</html>
