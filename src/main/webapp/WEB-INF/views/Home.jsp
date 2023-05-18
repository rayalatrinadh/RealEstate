<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h2>Enter User Details!</h2>
	<p>Please Enter user name and email to register</p>
	<div class="container">
		<!-- <form action="getInformation" method="post">
			Instructor ID:<input type="text" name="ID" required />
			<div>
				<input class="btn btn-success" type="submit" value="submit" />
			</div>
		</form> -->
		
			<form action="getPersonInfoFromUser" method="post">
			user/Agent Name:<input type="text" name="name" required />
			user/Agent emailID:<input type="text" name="emailID" required />

			<div>
				<input class="btn btn-success" type="submit" value="Register" />
			</div>
		</form>
	</div>
</div>
<%@ include file="common/footer.jspf"%>