<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

   <%
     String remark = null;
     
     String regnumber = null;
     
     remark = (String) session.getAttribute("remarks");
     
     
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
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="login">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
	  <div class="row">
	    <div class="col-md-6 offset-md-3">
	      <div class="card">
	        <div class="card-header text-center">
	          <h4 class="text-success">Successfully Answer Submitted <%=regnumber %></h4>
	        </div>
	        <div class= "card-body text-center">
	          <form action="logoutProcess" method="post">
	           <div class="mb-3">
	             <h2 class="text-warning">Your Score is: <%=remark %></h2>
	           </div>
	           <div class="mb-3">
	             <button class="btn btn-primary">Logout</button>
	           </div>
	          </form>
	          <hr>
	          <form action="deleteProcess" method="post">
	           <div  class="mb-3">
	            <label class="text-danger">Want to Delete User:</label>
	            <button class = "btn btn-primary">Delete</button>
	           </div>
	          </form>
	          
	        </div>
	        </div>
	      </div>
	    </div>
	  </div>
</body>
</html>