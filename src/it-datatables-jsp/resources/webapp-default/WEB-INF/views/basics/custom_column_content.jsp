<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
   <datatables:table id="myTableId" data="${persons}" row="person">
      <datatables:column title="Id" property="id" />
      <datatables:column title="FirstName" property="firstName" />
      <datatables:column title="LastName" property="lastName" />
      <datatables:column title="City" property="address.town.name" />
      <datatables:column title="Mail">
         <a href="mailto:${person.mail}"><c:out value="${person.mail}" /></a>
      </datatables:column>
   </datatables:table>
</body>
</html>