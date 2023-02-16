<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Page Header Start -->
<div class="container-fluid page-header mb-5 p-0"
	style="background-image: url(img/carousel-bg-2.jpg);">
	<div class="container-fluid page-header-inner py-5">
		<div class="container text-center">
			<h1 class="display-3 text-white mb-3 animated slideInDown">Car</h1>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb justify-content-center text-uppercase">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item"><a href="#">Pages</a></li>
					<li class="breadcrumb-item text-white active" aria-current="page">CAR</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<!-- Page Header End -->


<!-- Service Start -->
<div class="container-xxl service py-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<ul>
					<li>A</li>
					<li>A</li>
				</ul>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<c:if test="${listCar.size() > 0}">
						<c:forEach items="${listCar}" var="item">
							<div class="col-lg-4 divShowCar">
								<img alt="" src="${item.carDetailCollection[0].image}"
									class="img-thumbnail" />
								<center>
									<p>Price/hour ${item.price}</p>
									<p>${item.productName}</p>
								</center>
							</div>

						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Service End -->

