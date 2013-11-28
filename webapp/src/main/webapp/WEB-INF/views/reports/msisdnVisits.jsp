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
    <script type="text/javascript" src="resources/js/datatables_bootstrap-3.js"></script>

</head>

<body>

<div class="container">

	<jsp:include page="../includes/header.jsp" />

	<script>
	    /* Table initialisation */
	    $(document).ready(function() {
	    	var today = new Date();
	        var startDate = convertParamDate('${startDate}');
	        if (startDate == null) {
	        	startDate = "1/" + (today.getMonth()+1) + "/" +  today.getFullYear();
	        }
	        var endDate = convertParamDate('${endDate}');
	        if (endDate == null) {
	            endDate = today.getDate() + "/" + (today.getMonth()+1) + "/" + today.getFullYear();
	        }
	        $('#remediTable').dataTable( {
	            "sDom": 'lfr<"toolbar">tip',
	            "bProcessing": true,
	            "bServerSide": true,
	            "sAjaxSource": "service/msisdnVisits",
	            "fnServerParams": function ( aoData ) {
	                aoData.push( { "name": "startDate", "value": startDate } );
	                aoData.push( { "name": "endDate", "value": endDate } );
	            }
	        } );
	        $("div.toolbar").html('' +
	                '<form class="form-inline">' +
	                '<fieldset>' +
	                '<label>From:</label>' +
	                '<input id="date1" type="text" name="date1" value="${param.startDate}" onchange="fromDateSelected()" class="form-control form-remedi-date" /> ' +
	                '<label>To:</label>' +
	                '<input id="date2" type="text" name="date2" value="${param.endDate}" class="form-control form-remedi-date" />' +
	                '<button id="filter" type="button" class="btn btn-default" onclick="filterButtonClicked()">Apply</button>' +
	                '<button id="download" type="button" class="btn btn-primary pull-right" onclick="exportButtonClicked()">Export</button>' +
	                '</fieldset>' +
	                '</form>' );
	    });
	
	</script>

    <jsp:include page="../includes/datepicker.jsp">
        <jsp:param name="windowLocation" value="reports/msisdnVisits" />
        <jsp:param name="csvUrl" value="service/msisdnVisits/csvFormat" />
    </jsp:include>

	<h3>Report of Msisdn Details</h3>
    <table class="table table-bordered" id="remediTable">
        <thead>
        <tr>
            <th>USSD ID</th>
            <th>Session Date</th>
            <th>Start Time</th>
            <th>Duration</th>
            <th>Mobile Number</th>
            <th>Mobile Network</th>
        </tr>
        </thead>
    </table>

    </div>

    <jsp:include page="../includes/footer.jsp" />

</div>

</body>
</html>