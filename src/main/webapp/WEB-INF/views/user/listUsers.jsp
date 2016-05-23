<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Users</title>


<link rel="stylesheet" href='<c:url value="http://yui.yahooapis.com/pure/0.4.2/pure-min.css"/>'>
<link rel="stylesheet"
       href='<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css"/>'>
<link rel="stylesheet"
       href='<c:url value="/resources/css/jquery-ui.css"/>'>

<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/font-awesome.min.css"/>'>

<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>

   <div style="width: 95%; margin: 0 auto;">

        <div id="userDialog" style="display: none;">
            <%@ include file="userForm.jsp"%>
        </div>

        <h1>List Of Users</h1>

        <button class="pure-button pure-button-primary" onclick="addUser()">
            <i class="fa fa-plus"></i> Add User
         </button>

        <br>
        <br>

        <form class="pure-form pure-form-aligned" action="searchUser">
                <input type="text" name="name" id="name" placeholder="User name"/>
                <button class="pure-button pure-button-primary" type="submit">
                    <i class="fa fa-search"></i> Search User
                </button>

        </form>

         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">S.N</th>
                  <th width="12%">Name</th>
                  <th width="12%">Age</th>
                  <th width="12%">Is Admin</th>
                  <th width="12%">Created Date</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${userList}" var="user" varStatus="loop">
               <tr>
                   <td><c:out value="${offset + loop.index + 1 }" /></td>
                   <td><a href="/userslist/user/userdata/${user.id}" target="_blank"><c:out value="${user.name}" /></a></td>
                   <td><c:out value="${user.age}" /></td>
                   <td><c:out value="${user.isAdmin}" /></td>
                   <td><c:out value="${user.createdDate}" /></td>

                   <td>
                     <nobr>
                        <button onclick="editUser(${user.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${user.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this user?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>

         <tag:paginate max="15" offset="${offset}" count="${count}"
            uri="/user/listUsers" next="&raquo;" previous="&laquo;" />
     </div>

    <script type="text/javascript" src='<c:url value="/resources/js/jquery.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js"/>'></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <script type="text/javascript"
       src='<c:url value="/resources/js/js-for-listBooks.js"/>'></script>
</body>
</html>