<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="currentUser" items="${users}">

      <td><br><img src="${currentUser.profilePicture}"><br>${currentUser.username}</td>

</c:forEach>