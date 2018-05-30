<%@page import="com.inflinx.blog.springfuture.service.ReportServiceImpl"%>
<html>
<head>
	<title>Home</title>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			// Check The Status Every 2 Seconds
			var timer = setInterval(function() {
				alert("ajax");
				$.ajax({
					  url: 'reportstatus.json',
					  success: function(data) {
						
						if(data === 'COMPLETE') {
							$('#reportLink').html("<button id='final' onclick='ajax()''>report</button>");	
							clearInterval(timer);
							
						}
					  }
				});
			    
				
			}, 5000);
			
		});
		
		function ajax() {
			alert("ajax2");
			var timer = setInterval(function() {
				$.ajax({
					  url: 'reportfinal.json',
						  success: function(data) {
							  if(data === 'COMPLETE2') {
								var String = "Number : ${r.number} <br/>"
												+"Description: ${r.description}<br/>"
												+"Name :  ${r.name} <br />";
								$('#reportLink2').html(String);	
								clearInterval(timer);
						  }
					  }
				});
			    
			}, 2000);
		}
		
	</script>

</head>
<body>
<h1>
  Report Generator
</h1>

<div id="reportLink"> ajax </div>
<div id="reportLink2"></div>
</body>
</html>
