<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="pages/footer.css">
<link href="pages/listecustomers.css" rel="stylesheet">
<link href="fontawesome/css/all.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <title>Bootstrap Delete Confirmation Modal</title> -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<link
	href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css"
	rel="stylesheet">
<script
	src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="/WEB-INF/pages/header.jsp"%>
	<div id="login">
		<h3 class="text-center text-white pt-5">Ajout Customer</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">

						<s:form id="login-form" class="form" action="save" method="post">
							<h3 class="text-center text-info">Edition Customer</h3>
							
							

							<div class="form-group">
								<s:text name="global.customeraddress" />
								<br>
								<s:textfield name="customer.address" key="Adresse" id="login"
									class="form-control" theme="simple" value="%{customer.address}"/>
							</div>

							<div class="form-group">
								<s:text name="global.customercity" />
								<br>
								<s:textfield name="customer.city" key="Ville" id="login"
									class="form-control" theme="simple" min="2" max="20" value="customer.city"/>
							</div>

							<div class="form-group">
								<s:text name="global.customerstate" />
								<br>
								<s:textfield name="customer.state" key="Etat" id="login"
									class="form-control" theme="simple" min="2" max="2" value="customer.state" 
									style="text-transform: uppercase" />
							</div>



							<div>
								<s:text name="global.customertypecd" />
								<s:select name="customer.custTypeCd" value="customer.custTypeCd"
									headerValue="-Choisir un type de client-"
									list="#{'I':'Individu', 'B':'Entreprise'}" class="form-control" theme="simple"/>
									<br>
							</div>

							<div class="form-group">
								<s:text name="global.customerfedid" />
								<br>
								<s:textfield name="customer.fedId" key="FedId" id="login" value="customer.fedId"
									class="form-control" theme="simple" min="12" max="12" />
							</div>

							<div class="form-group">
								<br>
								<s:submit type="button" name="submit"
									class="btn btn-secondary btn-lg" value="Ajouter Customer"/>
							</div>
						</s:form>
						
					</div>
<br><br><br>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/footer.jsp"%>