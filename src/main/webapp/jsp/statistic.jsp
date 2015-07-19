<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="currentUser" items="${usersVO}">

      <td><br><img src="${currentUser.user.profilePicture}"><br>${currentUser.user.username}<br>Coeff: ${currentUser.coeff}<br>${currentUser.user.user.mediaNumber}</td>

</c:forEach>