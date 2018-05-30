function submit() { //'출력'버튼을 눌렀을때 실행되도록
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    
    /*이름, 월급 배열*/
    var namedata=new Array();
    var saldata=new Array();
	
    /*테이블 tr개수 구하기(부서원만큼 tr이 생성되서)*/
	var trRow = $('#searchTable tr').length;
	
	/*이름배열에 각각의 이름 넣기 - 단 tr중 맨 위는 제목줄이라 개수에서 -1을 함*/
	for(var i=0; i<trRow-1 ; i++){
		namedata[i] = $('#searchTable tr td:eq('+ (1+(10*i)) +')').text();
		console.log(i + ":" + namedata[i]);
	}
	
	/*월급배열에 각각의 월급 넣기 - 단 tr중 맨 위는 제목줄이라 개수에서 -1을 함*/
	for(var i=0; i<trRow-1 ; i++){
		saldata[i] =$('#searchTable tr td:eq('+ (5+(10*i)) +')').text();
		console.log(i + ":" +saldata[i]);
	}
	console.log(typeof(saldata[0]));
	
	/*차트그리기*/
	function drawChart() {
		   // Define the chart to be drawn.
		   var data = new google.visualization.DataTable();
		   data.addColumn('string', '이름');
		   data.addColumn('number', '월급');
		   
		   for(var i=0; i<trRow-1; i++){
			   data.addRows([
				      [namedata[i], Number(saldata[i])] //배열에서 숫자는 문자형숫자이므로 숫자형으로 형변환
				]);
		   }
		   
		   var depth = $('#dept option:selected').text();
		   
		   // Set chart options
		   var options = {'title': depth + '번 부서',
		      'width':600,
		      'height':400};

		   // Instantiate and draw the chart.
		   var chart = new google.visualization.BarChart(document.getElementById('container'));
		   chart.draw(data, options);
		} 
    
}
    

    