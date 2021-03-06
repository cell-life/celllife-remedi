<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cell Life Remedi</title>

    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

    <link href="resources/css/bootstrap-3.0.0.css" rel="stylesheet" media="screen">
    <link href="resources/css/datatables_bootstrap.css" rel="stylesheet">
    <link href="resources/css/jquery-ui-1.10.2.css" rel="stylesheet">
    <link href="resources/css/remedi.css" rel="stylesheet">

    <script type="text/javascript" src="resources/js/jquery-1.8.2.js"></script> <!-- This is the version of jQuery that came with DataTables -->
    <script type="text/javascript" src="resources/js/bootstrap-3.0.0.min.js"></script>
    <script type="text/javascript" src="resources/js/jquery-ui-1.9.1.min.js"></script>
     <script type="text/javascript" src="resources/js/jquery.dataTables-1.9.4.js"></script>
    <script type="text/javascript" src="resources/js/jquery.dataTablHOes-1.9.4.js"></script>
    <script type="text/javascript" src="resources/js/datatables_bootstrap-3.js"></script>

</head>

<body>

<div class="container">

    <div class="masthead">
    
    	<div class="btn-toolbar pull-right">
        <a class="btn btn-primary" href="j_spring_cas_security_logout">Logout</a>
     	</div>
        
        <h2><img class="ohsc-logo" src="resources/img/logo.png"></h2>
    </div>
    
    <hr>
    <h1>Error</h1>
	<p>
	<c:out value="${errorMessage}" />
	</p>

   
    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

</div>

</body>
</html>
