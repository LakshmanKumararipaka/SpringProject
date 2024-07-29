<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
   <%
   String regnumber = null;
   regnumber = (String) session.getAttribute("regnumber");
   %>
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
						aria-current="page" href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
	  <div class="row">
	    <div class="col-md-6 offset-md-3">
	      <div class="card">
	        <div class="card-header text-center">
	          <c:if test="${not empty updatemsg }">
	            <h3 class="text-success">${updatemsg }</h3>
	            <c:remove var="regnumber"/>
	          </c:if>
	          <h3 class="text-success">Welcome <%=regnumber %></h3>
	        </div>
	        <div class="card-body">
	          <form action="submitProcess" method="post">
	            <!-- <div class="mb-3">
	              <label>Enter Registration Number:</label>
	              <input type="text" name="regnumber" class="form-control"> 
	            </div> -->
	            <div class="mb-3">
	                <label>What is the capital of India?</label>
					<div class="form-check">
					   <input class="form-check-input" type="radio" name="answer01" id="flexRadioDefault1" value="kolkata"> 
					   <label class="form-check-label" for="flexRadioDefault1">Kolkata</label>
				    </div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="answer01" id="flexRadioDefault2" value="delhi">
						<label class="form-check-label" for="flexRadioDefault2">Delhi</label>
					</div>
				</div>
				<div class="mb-3">
	                <label>What is the Highest Peak of the World?</label>
					<div class="form-check">
					   <input class="form-check-input" type="radio" name="answer02" id="flexRadioDefault1" value="mounteverest"> 
					   <label class="form-check-label" for="flexRadioDefault1">MountEverest</label>
				    </div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="answer02" id="flexRadioDefault2" value="k2">
						<label class="form-check-label" for="flexRadioDefault2">K2</label>
					</div>
				</div>
				<div class="mb-3">
				  <button class="btn btn-primary">Submit</button>
				</div>
	            <!-- <div class="mb-3">  
	            <button class="btn btn-primary">Logout</button>
	            </div> -->

	          </form>
	          <hr>
	          <div class="mb-3">
	             <label class="text-info">Want Update Profile Details:</label>
	             <a href="update"><button class = "btn btn-primary">Update</button></a>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>

</body>
</html>