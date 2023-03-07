<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Technician</title>
<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description"
	content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">

<!-- FontAwesome JS-->
<script defer
	src="<c:url value="/resources/admin/plugins/fontawesome/js/all.min.js"/>"></script>

<!-- App CSS -->
<link id="theme-style" rel="stylesheet"
	href="<c:url value="/resources/admin/css/portal.css"/>">
<link id="theme-style" rel="stylesheet"
	href="<c:url value="/resources/admin/customfile.css"/>">
<link id="theme-style" rel="stylesheet"
	href="<c:url value="/resources/newstyle.css"/>">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
</head>

<body class="app">
	<header class="app-header fixed-top">
		<div class="app-header-inner">
			<div class="container-fluid py-2">
				<div class="app-header-content">
					<!--//row-->
				</div>
				<!--//app-header-content-->
			</div>
			<!--//container-fluid-->
		</div>
		<!--//app-header-inner-->
		<div id="app-sidepanel" class="app-sidepanel">
			<div id="sidepanel-drop" class="sidepanel-drop"></div>
			<div class="sidepanel-inner d-flex flex-column">
				<a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
				<div class="app-branding">
					<a class="app-logo"
						href="${pageContext.request.contextPath }/tech/home"><img
						class="logo-icon me-2"
						src="<c:url value="/resources/admin/images/app-logo.svg"/>"
						alt="logo"><span class="logo-text">PORTAL</span></a>

				</div>
				<!--//app-branding-->

				<nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
					<ul class="app-menu list-unstyled accordion" id="menu-accordion">
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link active"
							href="${pageContext.request.contextPath }/tech/home"> <span
								class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-house-door"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd"
											d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z" />
		  <path fill-rule="evenodd"
											d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
		</svg>
							</span> <span class="nav-link-text">Overview</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->

						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link"
							href="${pageContext.request.contextPath }/tech/home-request">
								<span class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path
											d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z" />
  <path fill-rule="evenodd"
											d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z" />
</svg>
							</span> <span class="nav-link-text">Request</span>
						</a> <!--//nav-link-->
						</li>
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link"
							href="${pageContext.request.contextPath }/tech/home-request-processing">
								<span class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path
											d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z" />
  <path fill-rule="evenodd"
											d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z" />
</svg>
							</span> <span class="nav-link-text">Request Processing</span>
						</a> <!--//nav-link-->
						</li>

						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link"
							href="${pageContext.request.contextPath }/tech/home-request-all">
								<span class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path
											d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z" />
  <path fill-rule="evenodd"
											d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z" />
</svg>
							</span> <span class="nav-link-text">All Request</span>
						</a> <!--//nav-link-->
						</li>
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link"
							href="${pageContext.request.contextPath }/tech/notification">
								<span class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="fa fa-notification" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path
											d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z" />
  <path fill-rule="evenodd"
											d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z" />
</svg>
							</span> <span class="nav-link-text">Notification</span>
						</a> <!--//nav-link-->
						</li>
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link"
							href="${pageContext.request.contextPath }/logout"> <span
								class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="fa fa-back" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
  <path
											d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z" />
  <path fill-rule="evenodd"
											d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z" />
</svg>
							</span> <span class="nav-link-text">LOGOUT</span>
						</a> <!--//nav-link-->
						</li>

						<!--//nav-item-->
					</ul>
					<!--//app-menu-->
				</nav>
				<!--//app-nav-->

				<!--//app-sidepanel-footer-->

			</div>
			<!--//sidepanel-inner-->
		</div>
		<!--//app-sidepanel-->
	</header>
	<!--//app-header-->


	<div class="app-wrapper">
		<div>
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>


	</div>
	<!--//app-wrapper-->


	<!-- Javascript -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/admin/plugins/popper.min.js"/>"></script>
	<script
		src="<c:url value="/resources/admin/plugins/bootstrap/js/bootstrap.min.js"/>"></script>

	<!-- Charts JS -->
	<script
		src="<c:url value="/resources/admin/plugins/chart.js/chart.min.js"/>"></script>
	<script src="<c:url value="/resources/admin/js/index-charts.js"/>"></script>

	<!-- Page Specific JS -->
	<script src="<c:url value="/resources/admin/js/app.js"/>"></script>
	<script src="<c:url value="/resources/processAjax.js"/>"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
</body>
</html>





