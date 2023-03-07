<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Page Header Start -->
<div class="container-fluid page-header mb-5 p-0"
	style="background-image: url(img/carousel-bg-2.jpg);">
	<div class="container-fluid page-header-inner py-5">
		<div class="container text-center">
			<h1 class="display-3 text-white mb-3 animated slideInDown">Not
				Found</h1>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb justify-content-center text-uppercase">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item"><a href="#">Pages</a></li>
					<li class="breadcrumb-item text-white active" aria-current="page">403</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<!-- Page Header End -->


<!-- 404 Start -->
<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
	<div class="container text-center">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<i class="bi bi-exclamation-triangle display-1 text-primary"></i>
				<h1 class="display-1">403</h1>
				<h1 class="mb-4">You Cannot Access</h1>
				<p class="mb-4">Sorry ${msg } :((</p>
				<a class="btn btn-primary rounded-pill py-3 px-5" href="${pageContext.request.contextPath }/home">Go
					Back To Home</a>
			</div>
		</div>
	</div>
</div>
<!-- 404 End -->