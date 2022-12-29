<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="/moment.js"></script>

<script>
const createMonthTable = async (date) => {	
	let firstDate = new Date(date.getFullYear(), date.getMonth(), 1);
	let lastDate = new moment(firstDate).add(1, 'months').subtract(1, 'days');
	let currentDate = firstDate;
	$('#title-date').text(moment(firstDate).format("YYYY년 MM월"));
	$('#title-date').data("firstdate", firstDate);
	let table = $("#month-table");
	let calenderTable = $("<table id='month-table'></table>");
	calenderTable.empty();
	
	const today = moment();
	let tempCurrentDate;
	let daysNumber = 0;
	
	let theadTr = $("<thead></thead>");
	theadTr.appendTo(calenderTable);

	let headTr = $("<tr></tr>");
	for (let i = 0; i < 7; i++) {
		let th = $("<th>" + moment().day(i).format("ddd") + "</th>");
		headTr.append(th);
	}
	headTr.appendTo(theadTr);
	
	let restDaysWeekNumber = "60"; /* 정기휴일(일:0,월:1,화:2, ... ,금:5,토:6) */
	while (currentDate <= lastDate) {
		tempCurrentDate = new moment(currentDate);
		let daysTr = $("<tr></tr>");
		
		for (let i = 0; i < 7; i++) { // 여기서 i는 요일
			let td = $("<td></td>");
			
			if (restDaysWeekNumber.includes(i)) {
				td.addClass("blocked"); // 주말표시가 된 class를 추가할 수 있음
			}
			
			if (tempCurrentDate.day() == i && firstDate <= tempCurrentDate && tempCurrentDate <= lastDate) {
				let p = $("<p>"+tempCurrentDate.date()+"</p>");
				p.appendTo(td);
				
				let span = $("<span></span>");
				span.appendTo(td);
				
				tempCurrentDate.add(1, 'days');
			}
			
			td.appendTo(daysTr);
		}
		daysTr.appendTo(calenderTable);
		currentDate = new moment(tempCurrentDate);
	}
	
	let parent = table.parent();
	table.remove();
	calenderTable.appendTo(parent);
};
// 달력 이전달 이동
const makePreCalender = () => {
	preDateString = moment($('#title-date').data('firstdate')).add('-1','M').format("YYYY-MM-DD");
	createMonthTable(new Date(preDateString));
}
// 달력 다음달 이동
const makeNextCalender = () => {
	nextDateString = moment($('#title-date').data('firstdate')).add('1','M').format("YYYY-MM-DD");
	createMonthTable(new Date(nextDateString));
}

$(document).ready( () => {

	var data = createMonthTable(new Date());
	
});
</script>

<div>
	<div>
		<a href="javascript:makePreCalender();"><i class="fa fa-arrow-left" aria-hidden="true"></i>이전달</a>
		<p id="title-date">----년 -월</p>
		<a href="javascript:makeNextCalender();"><i class="fa fa-arrow-right" aria-hidden="true"></i>다음달</a>
	</div>
	<div>
		<table id="month-table">
			<thead>
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			</thead>
		</table>
	</div>
</div>
</script>
<script src="/moment.js"></script>
</body>
</html>