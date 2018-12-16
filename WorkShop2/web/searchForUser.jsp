<%-- 
    Document   : searchForUser
    Created on : Jun 18, 2018, 8:50:51 PM
    Author     : huyvqse63434
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP searchForUser</title>
    </head>
    <body>
        welcome,
        <s:property value="%{#session.username}"/>
        <s:if test="%{#session.isEmpty()}">
            <jsp:forward page="login.html"/>
        </s:if>
        <s:a href="signout">sign out</s:a>
        <s:form action="searchInRange">
            <s:textfield name="txtRangeBegin" value="%{txtRangeBegin}" size="10" label="From" />
            <s:textfield name="txtRangeEnd" value="%{txtRangeEnd}" size="10" label="To"/>
            <s:submit value="Search In Range"/>
        </s:form>
        <s:a href="viewCart.jsp">View Carts</s:a>
        <s:if test="%{!resultList.isEmpty()}">
            <s:if test="%{txtRangeBegin !=null}">
                <s:if test="%{txtRangeEnd !=null}">


                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Mobile Name</th>
                                <th>Discription</th>
                                <th>Price</th>
                                <th>Year of Production</th>
                                <th>Add to cart</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="%{resultList}" status="counter">
                                <s:form action="addtocart" theme="simple">
                                    <tr>
                                        <td> <s:property value="%{#counter.count}"/> </td>
                                        <s:hidden name="mobileId" value="%{mobileId}"/>
                                        <td> <s:property value="mobileName"/> </td>
                                        <s:hidden value="%{mobileName}" name="mobileName"/>
                                        <td> <s:property value="description"/> </td>
                                        <td> <s:property value="price"/> </td>
                                        <td> <s:property value="yearOfProduction"/> </td>
                                        <s:hidden name="rangeBegin" value="%{txtRangeBegin}"/>
                                        <s:hidden name="rangeEnd" value="%{txtRangeEnd}"/>
                                        <td> <s:submit value="Add to cart"/> </td>
                                    </tr>
                                </s:form>
                            </s:iterator>
                        </tbody>
                    </table> 
                </s:if>
            </s:if>
        </s:if>
        <s:if test="%{resultList.isEmpty()}">
            <font color='red'>No cord is Matched!!!</font>
        </s:if>
    </body>
</html>
