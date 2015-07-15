<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="follower" items="${followedBy}">
  <table border="1">
    <tr>
      <td><br><img src="${follower.profilePicture}"><br>${follower.username}</td>
    </tr>
  </table>
</c:forEach>
