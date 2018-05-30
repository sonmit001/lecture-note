<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">    
    <!-- <link rel="shortcut icon" href="favicon.ico"> -->  
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,500,500italic,700,700italic,900,900italic,300italic,300' rel='stylesheet' type='text/css'> 
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,700,300,100' rel='stylesheet' type='text/css'>
    <!-- Global CSS -->
    <link rel="stylesheet" href="resources/assets/plugins/bootstrap/css/bootstrap.min.css">   
    <!-- Plugins CSS -->    
    <link rel="stylesheet" href="resources/assets/plugins/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="resources/assets/plugins/flexslider/flexslider.css">
    <!-- Theme CSS -->
    <link id="theme-style" rel="stylesheet" href="resources/assets/css/styles.css">

</head> 

	<!-- Header  영역  -->
	<tiles:insertAttribute name="header" />
	<!-- Main 영역 -->
	<div id="main">
		<div class="top-wrapper clear">
			<tiles:insertAttribute name="content" />
		</div>	
	</div>
	<!-- Footer  영역  -->
	<tiles:insertAttribute name="footer" />
	
    <!-- Javascript -->          
    <script type="text/javascript" src="resources/assets/plugins/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="resources/assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
    <script type="text/javascript" src="resources/assets/plugins/bootstrap-hover-dropdown.min.js"></script>
    <script type="text/javascript" src="resources/assets/plugins/back-to-top.js"></script>
    <script type="text/javascript" src="resources/assets/plugins/jquery-placeholder/jquery.placeholder.js"></script>
    <script type="text/javascript" src="resources/assets/plugins/FitVids/jquery.fitvids.js"></script>
    <script type="text/javascript" src="resources/assets/plugins/flexslider/jquery.flexslider-min.js"></script>     
    <script type="text/javascript" src="resources/assets/js/main.js"></script>

</body>
</html> 