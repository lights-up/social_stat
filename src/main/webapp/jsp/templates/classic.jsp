<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/buttons.css" rel="stylesheet">
    <link rel="Shortcut Icon" type="image/x-icon" href="img/favicon.ico">
  </head>
  <body>
  	<!-- Header -->
  	<tiles:insertAttribute name="navMenu" />
  	
  	<table width="1200px" align="center">
      		<tr>    
      			<!-- Personal Menu -->
      			<td width="20%" align="center">
      				<tiles:insertAttribute name="menu" />  
      			</td> 
      			<!-- Body of Page -->
      			<td width="80%" align="center">   
         			<tiles:insertAttribute name="body" />  
        		</td>      
      		</tr>
    </table>
    	
   	<!-- Footer -->
  	<tiles:insertAttribute name="footer" />
  </body>
</html>