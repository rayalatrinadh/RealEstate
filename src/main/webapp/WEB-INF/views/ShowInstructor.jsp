<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>


<div class="container">

	<%@ include file="common/header.jspf"%>


	<script type="text/javascript">
		function doAjaxPost() {
			alert('doAjaxPost() called:');
			// get the form values
			//var name = $('#name').val();
			//var lastname = $('#lastname').val();

			var json = {
				"name" : "trinadh",
				"lastname" : "rayala"
			}; //sample json Data 
			//console.log(json);
			alert('onClickingButton ajaxCalled');
			$.ajax({
				type : "POST",
				url : "getInformationAjax",
				data : JSON.stringify(json),
				//data: "{\"name\":name}",
				//data: {"name":name},
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				cache : false,

				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},

				success : function(data) {
					alert('success');
					alert(data.toString());
					alert(data.toString());
					alert(data.name);
					alert(data.num);
				},
				error : function(data, status, er) {
					alert('error');
				}
			});
		}
	</script>
	
		
	<!-- ajaxFunction to get the personDeatils from Controller -->
  <!-- <script type="text/javascript">
	function getPersonDetailsFromController(){
	
		alert('getPersonDetailsFromController start');
		
		$.ajax({
			type : "POST",
			url : "getPersonInfoFromDBAjax",
			cache : false,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},

			success : function(data) {
				alert(${personsList});
				alert('success');
			},
			error : function(data, status, er) {
				alert(${products});
				alert(data);
				alert('error');
			}
		});
		
		  alert('getPersonDetailsFromController end');
	}
	
	
	</script>  -->



	<marquee width="100%" direction="left" height="100px">
		<h2 style="color: #00FF00";>Hey these are the details of your
			Instructor...!</h2>
	</marquee>


	<%-- <%
    
    Instructor ob2 = (Instructor) request.getAttribute("Instructor");
    	out.println(ob2);	
    
  %> --%>

 
	<div class="container">
		<pre>
		${Instructor}
</pre>
	</div>
	

	<input type="button" value="Update" onclick="doAjaxPost()">
</div>


	
	
	
	<div class = "container">
	<%-- <select name="person">
    <c:forEach items="${personsList}" var="person">
        <option value="${person.name}">${person.name}</option>
        <option value="${person.emailID}">${person.emailID}</option>
    </c:forEach>
</select> --%>

<%-- <c:forEach items="${personsList}" var="person">
    <p>Title:</p> 
    <c:out value="${person.name}"></c:out> <br>
</c:forEach>
 --%>

	<%-- <table>
    <c:forEach items="${personsList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${personsList.name}" /></td>
            <td><c:out value="${personsList.emailID}" /></td>
            <td><fmt:formatNumber value="${product.price}" type="currency" currencyCode="USD" /></td>
        </tr>
    </c:forEach>
</table> --%>

	</div>
	
	
<%@ include file="common/footer.jspf"%>