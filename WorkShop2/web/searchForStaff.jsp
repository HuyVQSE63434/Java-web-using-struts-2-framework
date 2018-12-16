<%-- 
    Document   : searchForStaff
    Created on : Jun 19, 2018, 11:47:22 AM
    Author     : huyvqse63434
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP searchForStaff</title>
    </head>
    <body>
        welcome,        
        <s:property value="%{#session.username}"/><br/>
        <s:if test="%{#session.isEmpty()}">
            <jsp:forward page="login.html"/>
        </s:if>
        <s:a href="signout">sign out</s:a>
        <s:a href="newMobile.html">Create new mobile</s:a>
        <s:form action="searchMobile">
            <s:textfield name="txtSearch" value="%{txtSearch}" label="Search:"/>
            <s:submit value="Search Mobile"/>
        </s:form>

        <s:if test="%{!resultList.isEmpty()}">
            <s:if test="%{!txtSearch.isEmpty()}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>mobile Id</th>
                            <th>description</th>
                            <th>price</th>
                            <th>mobile Name</th>
                            <th>year Of Production</th>
                            <th>quantity</th>
                            <th>not Sale</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="%{resultList}" status="counter">
                            <s:form action="Updatemobile" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{mobileId}"/>
                                        <s:hidden name="mobileId" value="%{mobileId}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="txtdescription" value="%{description}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="txtprice" value="%{price}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{mobileName}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{yearOfProduction}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="txtquantity" value="%{quantity}"/>
                                    </td>
                                    <td>
                                        <s:checkbox name="checkNotSale" value="%{notSale}" />
                                    </td>
                                    <s:hidden name="lastSearchValue" value="%{txtSearch}"/>
                                    <s:url id="deletelink" action="deleteMobile">
                                        <s:param name="mobileId" value="%{mobileId}"/>
                                        <s:param name="lastSearchValue" value="%{txtSearch}"/>
                                    </s:url>
                                    <td><s:a href="%{deletelink}">Delete</s:a></td><br/>
                            <td><s:submit value="Update"/></td>
                        </tr>
                    </s:form>
                </s:iterator>
            </tbody>
        </table>
    </s:if>
</s:if>
<s:if test="%{txtSearch.isEmpty()}">
    <font color='red'>No cord is Matched!!!</font>
</s:if>
</body>
</html>
