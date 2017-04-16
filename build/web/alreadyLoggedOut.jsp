<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Vistaar Bank</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<style>
	.navbar {
		margin-bottom: 0;
		background-color: #0066ff;
		z-index: 9999;
		border: 0;
		font-size: 12px !important;
		line-height: 1.42857143 !important;
		letter-spacing: 4px;
		border-radius: 0;
		font-family: Montserrat, sans-serif;
	}

	.navbar li a, .navbar .navbar-brand {
		color: #fff !important;
	}

	.navbar-nav li a:hover, .navbar-nav li.active a {
		color: #0066ff !important;
		background-color: #fff !important;
	}

	.navbar-default .navbar-toggle {
		border-color: transparent;
		color: #fff !important;
	}

	.dropdown-menu {
		color: #fff;
		background-color: #0066ff;
	}

	.carousel-control.right, .carousel-control.left {
		background-image: none;
		color: #fff;
	}

	.carousel-indicators li {
		border-color: #0066ff;
	}
	
	.carousel-indicators li.active {
		background-color: #6699ff;
	}

	.item span {
		font-style: normal;
	}

	.carousel {
		background-color: #6699ff;
	}

	.carousel-caption {
		color: #fff;
		background-color: #6699ff;
		position: relative;
		left: auto;
		right: auto;
	}

	h2 {
		font-size: 24px;
		text-transform: uppercase;
		font-weight: 600;
                margin-top: 100px;
                color: #000;
	}

	.standard-formatting-light {
		color:#fff;
		background-color: #6699ff;
	}
	
	.standard-formatting-dark {
		color:#fff;
		background-color: #0066ff;
	}


	p {
		color: #d9d9d9;
	}

	.carousel-indicators li {
		background: #ff6;
	}

	.carousel-indicators .active {
		background: #f00;
	}

	footer .glyphicon {
		font-size: 20px;
		margin-bottom: 20px;
		color: #009;
	}

	.panel {
		border: 1px solid #6699ff;
		border-radius: 0;
		transition: box-shadow 0.5s;
	}
	
	.panel:hover {
		box-shadow: 5px 0px 40px rgba(0,0,0, .2);
	}

	.panel-heading {
		color: #fff !important;
		background-color: #6699ff !important;
		padding: 25px;
		border-bottom: 1px solid transparent;
		border-top-left-radius: 0px;
		border-top-right-radius: 0px;
		border-bottom-left-radius: 0px;
		border-bottom-right-radius: 0px;
	}

	.panel-footer {
		background-color: #6699ff;
	}
	
	.panel-body p {
		color: #06f;
	}		
	
	@media screen and (max-width: 768px) {
		.col-sm-4 {
			text-align: center;
			margin: 25px 0;
		}
	}
</style>

</head>

<body id="loggedOut" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<img src="images/Vistaar logo.jpg" width="80" height="50"/>
			<a class="navbar-brand" href="index.html#myPage">Vistaar Bank Pvt. Ltd.</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">PERSONAL
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="ViewAccount">View Account Details</a></li>
						<li><a href="TransferMoney">Transfer Money</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">LOANS
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="LoanApply">Apply For Loan</a></li>
						<li><a href="LoanStatus">View Loan Status</a></li>
					</ul>
				</li>
				<li><a href="index.html#about">ABOUT US</a></li>
				<li><a href="index.html#contact">CONTACT US</a></li>
                                <li><a href="LoginNeeded">Login</a></li>
                                <li><a href="LogoutNeeded">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="jumbotron text-center standard-formatting-light">
    <h2>
<%
        out.println("You have not yet signed in.");
%>
    </h2>
</div>
<footer class="container-fluid text-center standard-formatting-dark">
	<p>Copyright : Vistaar Bank Pvt. Ltd.</p>
</footer>

</body>
</html>
   
