<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="userForm" commandName="user" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="User Name" />
          </div>
          <div class="pure-control-group">
               <label for="age">Age</label>
               <form:input path="age" placeholder="Age" />
          </div>

          <form:checkbox path="isAdmin" /> Is Admin

          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>