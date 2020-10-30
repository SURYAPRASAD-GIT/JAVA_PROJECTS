<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

    <head>
    <style>
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 7px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: blue;
}
</style>
    </head>
    
    
 <body style="background-color:#242424">
    
<h1 style="color: #69e6e1;text-align: center">All ${operation} Info</h1>

<a href="welcome">Home</a>
<br>
<br>
<c:choose>
  <c:when test="${ listInfo ne null && !empty listInfo}">
   
   <table align="center">
   
   <c:forEach var="country" items="${listInfo}" varStatus="rowCounter">
   
   <c:if test="${rowCounter.count % 5 == 1}">
   <tr>
   </c:if>
   <td style="background-color:pink;color:black;font-weight:50px;font-size: 20px;">${country}</td>
   <c:if test="${rowCounter.count % 5 == 0}">
      </tr>
    </c:if>
   </c:forEach>
   </table>
   <br>
  <br>
   <b style="background-color:cyan;color:black;font-weight:50px;font-size: 20px;">${operation} count::${countriesCount} </b>
 <br>
<br><br>
<br>
  </c:when>
   <c:otherwise>
   <h1 style="color:red;text-align:center;">No ${operation} Found</h1>
   </c:otherwise>

</c:choose>


</body>
