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
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
</head>

<body>

<div class="container">

    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="j_spring_cas_security_logout">Logout</a>
        </ul>
        <h2><img class="ohsc-logo" src="resources/img/logo.png"></h2>
    </div>

    <h2>USSD Analysis Web Page</h2>

    <hr>

    <h3>Aggregated Data</h3>

    <table class="table table-bordered" >
        <thead>
        <tr>
            <th>Theme / Service</th>
            <th>Page Views</th>
            <th>SMSs</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${hits}" var="hit">

        <script>
            console.log(${hit.service});
        </script>

            <tr>
                <td>${hit.serviceName}</td>
                <td>${hit.serviceHits}</td>
                <td>${hit.smsHits}</td>
        </c:forEach>

        </tbody>
    </table>

    <hr>

    <div class="footer">
        <p>&copy; Cell-Life (NPO) - 2013</p>
    </div>

    <script>
        console.log(${hits});
    </script>

</div>

</body>
</html>