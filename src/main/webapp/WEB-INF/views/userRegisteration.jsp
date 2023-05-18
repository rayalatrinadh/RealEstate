<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<meta charset="UTF-8">
<style>
table {
	margin: auto;
	background-color: #f0f0f0;
	color: black;
	font-weight: bold;
	padding: 10px;
	text-align: center;
}

td {
	padding: 8px;
	font-weight: bold;
	color: black;
}
</style>
<script>
	function getTableData() {
		var table = document.getElementById('myTable');
		var rows = table.getElementsByTagName('tr');
		var rowData = [];
		for (var i = 0; i < rows.length; i++) {
			var cells = rows[i].getElementsByTagName('td');
			var cellData = [];
			for (var j = 0; j < cells.length; j++) {
				cellData.push(cells[j].innerText);
			}
			rowData.push(cellData);
		}
		return rowData;
	}

	function onSubmitForm() {
		document.getElementById('tableData').value = JSON
				.stringify(getTableData());
		return true;
	}
</script>

<div>
	<form name="myForm" action="" method="post"
		onsubmit="return onSubmitForm();">
		<table id="myTable">
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="" size="50" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="" size="50" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="" size="50" required></td>
			</tr>
			<tr>
				<td>User Type:</td>
				<td><input type="radio" name="userType" value="Renter" checked>Renter
					<input type="radio" name="userType" value="Agent">Agent</td>
			</tr>
			<tr>
				<td><input  class = "btn-success" type="submit" value="register" name="register">
				</td>
			</tr>
		</table>
		<input type="hidden" name="tableData" id="tableData" value="">
	</form>
</div>

<div>
	<form action="getPersonInfoFromDBAjax" method="post">
			

			<div>
				<input class="btn btn-success" type="submit" value="getPersonsList" />
			</div>
		</form>
	</div>

<%@ include file="common/footer.jspf"%>