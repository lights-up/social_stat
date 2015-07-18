<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="currentUser" items="${users}">
  <table border="1">
    <tr>
      <td><br><img src="${currentUser.profilePicture}"><br>${currentUser.username}</td>
    </tr>
  </table>
</c:forEach>