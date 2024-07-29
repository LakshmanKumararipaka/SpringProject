<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Online Examination System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="login">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
	   <div class="row">
	     <div class="col-md-6 offset-md-3">
	       <div class="card">
	         <div class="card-header text-center">
	           <h3>Register</h3>
	         </div>
	         <div class="card-body">
	           <form:form action="updateProcess" modelAttribute="Student" method="post">
	             <div class="mb-3">
	               <h4>Enter Personal Details:</h4>
	             </div>
	             <div class="mb-3">
	               <label>First Name:</label>
	               <form:input type="text" name="firstname" class="form-control" path="firstname"/>
	             </div>
	             <div class="mb-3">
	               <label>Middle Name:</label>
	               <form:input type="text" name="middlename" class="form-control" path="middlename"/>
	             </div>
	             <div class="mb-3">
	               <label>Last Name:</label>
	               <form:input type="text" name="lastname" class="form-control" path="lastname"/>
	             </div>
	             <div class="mb-3">
	               <label> Birth Date(dd-mm-yyy):</label>
	               <form:input type="text" name="dob" class="form-control" path="dob"/>
	             </div>
	             <div class="mb-3">
	             <label>Sex:</label>
				 <form:select class="form-select form-control" name="sex" aria-label="Default select example" path="sex">
					<option selected value="Male">Male</option>
					<option value="Female">Female</option>
				   </form:select>
				</div>
				<div class="mb-3">
	               <label>Email Id:</label>
	               <form:input type="text" name="email" class="form-control" path="email"/>
	             </div>
	             <div class="mb-3">
	               <label>Phone Number:</label>
	               <form:input type="text" name="phnno" class="form-control" path="phnno"/>
	             </div>
	             <div class="mb-3">
	               <h4>Enter Address Details:</h4>
	             </div>
	             <div class="mb-3">
	               <label>House Number:</label>
	               <form:input type="text" name="houseno" class="form-control" path="houseno"/>
	             </div>
	             <div class="mb-3">
	               <label>Street:</label>
	               <form:input type="text" name="street" class="form-control" path="street"/>
	             </div>
	             <div class="mb-3">
	               <label>City:</label>
	               <form:input type="text" name="city" class="form-control" path="city"/>
	             </div>
	             <div class="mb-3">
	               <label>State:</label>
	               <form:input type="text" name="state" class="form-control" path="state"/>
	             </div>
	             <div class="mb-3">
	               <label>Country:</label>
	               <form:input type="text" name="country" class="form-control" path="country"/>
	             </div>
	             <div class="mb-3">
	               <label>Pincode:</label>
	               <form:input type="text" name="pincode" class="form-control" path="pincode"/>
	             </div>
	             
	             <div class="mb-3">
	               <button class="btn btn-primary">Update</button>
	             </div>
	             <div></div>
	           </form:form>
	         </div>
	       </div>
	     </div>
	   </div>
	</div>
</body>
</html>