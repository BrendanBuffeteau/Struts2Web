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
<style>
footer{
	background-color: #222;
	position:fixed;
	bottom:0;
	text-align: center;
	font-size : 150%;
	color: white	;
	height:6%;
    margin-top: 0%;
    margin-bottom: 0%;
    margin-left: 0%;
    margin-right: 0%;
    width:100%;
}

img {
	width: 30px;
	height: 30px;
}</style>
</head>
<body>


<header> <nav class="navbar navbar-inverse">
<div class="container-fluid">
	<div class="navbar-header">
				<s:url var="indexEN" namespace="/" action="changelanguageList">
			<s:param name="request_locale">en</s:param>
		</s:url>
		<s:a href="%{indexEN}">
				<img src="icon/angleterre.png" alt="English" />
			</s:a>
		<s:url var="indexFR" namespace="/" action="changelanguageList">
			<s:param name="request_locale">fr</s:param>
		</s:url>
		<s:a href="%{indexFR}">
				<img src="icon/france.png" alt="Français" />
			</s:a>
	</div>
	<ul class="navbar-header">
		<li class="navbar-brand"><s:url var="urlListe" action="Liste" />
			<a style="color:white" href="<s:property value="#urlListe"/>"><s:text name="global.headerlist" /></a>
	</ul>
	<ul class="navbar-header">
		<li class="navbar-brand"><s:url var="url"
				action="ajoutListecustomers" /> <a style="color:white"
			href="<s:property value="#url"/>"><s:text name="global.headernew" /></a>
	</ul>
	<ul class="navbar-header">
		<li class="navbar-brand"><a style="color:white" 
			href="mailto:buffeteau.brendan@gmail.com"><s:text name="global.headercontact" /></a>
	</ul>
	<ul class="navbar-header">
		<li class="navbar-brand"><a style="color:white" 
			href="https://i.kym-cdn.com/entries/icons/original/000/034/581/Untitled-5.png"><s:text name="global.headerwho" /></a>
	</ul>
	
	<ul class="nav navbar-nav navbar-right">
		<li><a style="color:white" class="navbar-brand" href="#"><s:text name="global.headerconnected" /> <s:property
					value="#session.compte.login" /></a>
					
		<li><s:url var="urllogout" action="Logout" /><a style="font-size:130%"  href="<s:property value="#urllogout"/>"><span class="glyphicon glyphicon-log-in"></span>
				<s:text  name="global.logout" /></a></li>
	</ul>

</div>
</nav> </header>
	<br>
	<div class="table-customerlist">
		<table data-toggle="table" data-search="true" data-show-columns="true"
			class="display">
			<tr>
				<th><s:text name="global.customerid" /></th>
				<th><s:text name="global.customeraddress" /></th>
				<th><s:text name="global.customercity" /></th>
				<th><s:text name="global.customertypecd" /></th>
				<th><s:text name="global.customerfedid" /></th>
	
				<th><s:text name="global.customerstate" /></th>
				<th>&nbsp;</th>
			</tr>
			<s:iterator value="customers" var="customer">
				<tr>
					<td class="nowrap"><s:property value="custId" /></td>
					<td class="nowrap"><s:property value="address" /></td>
					<td class="nowrap"><s:property value="city" /></td>
					<td class="nowrap"><s:property value="custTypeCd" /></td>
					<td class="nowrap"><s:property value="fedId" /></td>
	
					<td class="nowrap"><s:property value="state" /></td>
					<td class="nowrap"><s:url action="editListecustomers"
							var="url">
							<s:param name="customer.custId" value="#customer.custId" />
						</s:url> <a href="<s:property value="#url"/>"><s:text name="global.edit" /></a> &nbsp;&nbsp;&nbsp;
						<s:url action="deleteListecustomers" var="url">
							<s:param name="customer.custId" value="#customer.custId" />
						</s:url> <a
						href="<s:property value="#url" />" onclick="return onButtonClick();" ><s:text name="global.delete" /></a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<script type="text/javascript">
		function onButtonClick() {
			var answer;
			answer = window
					.confirm("Etes-vous sûr de vouloir supprimer ce client ?");
			if (answer == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
<footer>
<s:text name="global.footer" />
</footer>
</body>
</html>



