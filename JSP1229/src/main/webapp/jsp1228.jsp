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
	$('#title-date').text(moment(firstDate).format("YYYY�� MM��"));
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
	
	let restDaysWeekNumber = "60"; /* ��������(��:0,��:1,ȭ:2, ... ,��:5,��:6) */
	while (currentDate <= lastDate) {
		tempCurrentDate = new moment(currentDate);
		let daysTr = $("<tr></tr>");
		
		for (let i = 0; i < 7; i++) { // ���⼭ i�� ����
			let td = $("<td></td>");
			
			if (restDaysWeekNumber.includes(i)) {
				td.addClass("blocked"); // �ָ�ǥ�ð� �� class�� �߰��� �� ����
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
// �޷� ������ �̵�
const makePreCalender = () => {
	preDateString = moment($('#title-date').data('firstdate')).add('-1','M').format("YYYY-MM-DD");
	createMonthTable(new Date(preDateString));
}
// �޷� ������ �̵�
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
		<a href="javascript:makePreCalender();"><i class="fa fa-arrow-left" aria-hidden="true"></i>������</a>
		<p id="title-date">----�� -��</p>
		<a href="javascript:makeNextCalender();"><i class="fa fa-arrow-right" aria-hidden="true"></i>������</a>
	</div>
	<div>
		<table id="month-table">
			<thead>
			<tr>
				<th>��</th>
				<th>��</th>
				<th>ȭ</th>
				<th>��</th>
				<th>��</th>
				<th>��</th>
				<th>��</th>
			</tr>
			</thead>
		</table>
	</div>
</div>
</script>
<script src="/moment.js"></script>
</body>
</html>