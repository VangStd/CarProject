<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="<c:url value="/resources/formlogin/css/style.css"/>">
<c:url
	value="https://media.istockphoto.com/id/1226119391/vi/anh/chi%E1%BA%BFc-xe-m%C3%A0u-%C4%91en-tr%C3%AAn-%C4%91%C6%B0%E1%BB%9Dng.jpg?b=1&s=612x612&w=0&k=20&c=SCOkUxTHDwKTSymwOVBc-P75rPMUg8Dlgg-9Sx3Jxl0="
	var="imgback"></c:url>
<section id="bodytemp" class="img js-fullheight"
	style="background-image: url(${imgback});">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Login</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">Have an account or Register</h3>
						<c:url value="login-process" var="actionLogin"></c:url>
						<form action="${actionLogin }" class="signin-form" method="post">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Username"
									name="username" required>
							</div>
							<div class="form-group">
								<input id="password-field" type="password" class="form-control"
									placeholder="Password" name="password" required> <span
									toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>
							<c:if test="${param.err =='true' }">
								<h4 style="color: red;">Login Fail ! Please check again</h4>
							</c:if>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">Sign
									In</button>
							</div>
							<div class="form-group d-md-flex">
								<div class="w-50">
								 <a href="${pageContext.request.contextPath }/signup" style="color: #fff">SignUp Account</a>
								</div>
								<div class="w-50 text-md-right">
									<a href="#" style="color: #fff">Forgot Password</a>
								</div>
							</div>
						</form>
						<p class="w-100 text-center">&mdash; Or Sign In With &mdash;</p>
						<div class="social d-flex text-center">
							<a href="#" class="px-2 py-2 mr-md-1 rounded"><span
								class="ion-logo-facebook mr-2"></span> Facebook</a> <a href="#"
								class="px-2 py-2 ml-md-1 rounded"><span
								class="ion-logo-twitter mr-2"></span> Twitter</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>
<script src="<c:url value="/resources/formlogin/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/formlogin/js/popper.js"/>"></script>
<script src="<c:url value="/resources/formlogin/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/formlogin/js/main.js"/>"></script>