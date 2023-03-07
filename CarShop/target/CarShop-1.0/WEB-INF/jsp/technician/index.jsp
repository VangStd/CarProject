<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<h1 class="app-page-title">Overview</h1>

		<div class="row g-4 mb-4">
			<div class="col-6 col-lg-3">
				<div class="app-card app-card-stat shadow-sm h-100">
					<div class="app-card-body p-3 p-lg-4">
						<h4 class="stats-type mb-1">Total Order</h4>
						<div class="stats-figure">${amountOrder }</div>
					</div>
					<!--//app-card-body-->
					<a class="app-card-link-mask" href="#"></a>
				</div>
				<!--//app-card-->
			</div>
			<!--//col-->

			<div class="col-6 col-lg-3">
				<div class="app-card app-card-stat shadow-sm h-100">
					<div class="app-card-body p-3 p-lg-4">
						<h4 class="stats-type mb-1">Total Sale</h4>
						<div class="stats-figure">$${amountSale }</div>
					</div>
					<!--//app-card-body-->
					<a class="app-card-link-mask" href="#"></a>
				</div>
				<!--//app-card-->
			</div>
			<!--//col-->
			<div class="col-6 col-lg-3">
				<div class="app-card app-card-stat shadow-sm h-100">
					<div class="app-card-body p-3 p-lg-4">
						<h4 class="stats-type mb-1">XX/XX</h4>
						<div class="stats-figure">--</div>
						<div class="stats-meta">Disable</div>
					</div>
					<!--//app-card-body-->
					<a class="app-card-link-mask" href="#"></a>
				</div>
				<!--//app-card-->
			</div>
			<!--//col-->
			<div class="col-6 col-lg-3">
				<div class="app-card app-card-stat shadow-sm h-100">
					<div class="app-card-body p-3 p-lg-4">
						<h4 class="stats-type mb-1">XX/XX</h4>
						<div class="stats-figure">--</div>
						<div class="stats-meta">Disable</div>
					</div>
					<!--//app-card-body-->
					<a class="app-card-link-mask" href="#"></a>
				</div>
				<!--//app-card-->
			</div>
			<!--//col-->
		</div>
		<!--//row-->
		<div class="row g-4 mb-4">
			<div class="col-12 col-lg-12">
				<canvas id="myChartTech" style="width: 100%; max-width: 100%;"></canvas>
				<!--//app-card-->
				<center>Chart by total Order</center>
			</div>
			<!--//col-->
		</div>
		<!--//row-->
	</div>
	<!--//container-fluid-->
</div>
<!--//app-content-->
