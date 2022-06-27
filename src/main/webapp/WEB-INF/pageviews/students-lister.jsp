<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Students Lister</title>

<script type="text/javascript">
	function deleteLinkOnClick() {

		var answer = confirm("Do you really want to delete the Student?");
		if (answer) {
			console.log('user has pressed ok/yes')
		} else {
			console.log('user has pressed no/cancel')
		}
		return answer;
	}
</script>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body style="background-color: LightCyan;">
	<div class="container">
		<h1 class="text-center"
			; style="background-color: Lavender; font-family: Helvetica;">List
			of enrolled students</h1>
		<hr>


		<div class="container">

			<form action="/StudentManagement/student/search" class="form-inline">


				<!-- Add a button -->
				<a href="/StudentManagement/student/begin-add"
					class="btn btn-primary btn-sm mb-3"> Add Student </a>
					<input
				type="search" name="name" placeholder="Name"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="department" placeholder="Department"
				class="form-control-sm mr-2 mb-3" />
				<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>

			</form>

			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Department</th>
						<th>Country</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${students}" var="tempStudent">
						<tr>
							<td><c:out value="${tempStudent.id}" /></td>
							<td><c:out value="${tempStudent.name}" /></td>
							<td><c:out value="${tempStudent.department}" /></td>
							<td><c:out value="${tempStudent.country}" /></td>
							<td>
								<!-- Add "update" button/link --> <a
								href="/StudentManagement/student/begin-update?studentId=${tempStudent.id}"
								class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
								<a
								href="/StudentManagement/student/delete?studentId=${tempStudent.id}"
								class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
									Delete </a>

							</td>

						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>

	</div>

</body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<footer>
	<p class="text-center">Made with ❤️ by Shubham</p>
</footer>
</html>