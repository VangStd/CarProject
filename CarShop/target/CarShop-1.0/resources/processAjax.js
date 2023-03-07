/**
 * 
 */

var data = {
	init: function() {
		data.register();
		data.changeStatusAccount();
		data.deleteAccount();
		data.deleteTypeCar();
		data.deleteBrandCar();
		data.viewMoreCar();
		data.deleteCar();
		data.deleteServiceCar();
		data.changeServiceValue();
		data.bookingService();
		data.changeStatusBookingService();
		data.drawChartByTech();
		data.sendRequestChangeTech();
	},
	register: function() {

	},
	changeStatusAccount: function() {
		$('.account__button--changeStatus').each(function() {
			$(this).on('click', function() {
				var accId = $(this).data('id');
				console.log(accId);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, Change it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							data: { accID: accId },
							url: '/CarShop/admin/account-change-status',
							success: function() {
								Swal.fire(
									'Changed!',
									'Your file has been changed.',
									'success'
								);
								location.href = "/CarShop/admin/account-home";
							}
						});

					}
				});
			});
		});
	}, deleteAccount: function() {
		$('.account__button_deleteAccount').each(function() {
			$(this).on("click", function() {
				var id = $(this).data('id');
				console.log(id);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, Detele it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							url: '/CarShop/admin/account-delete',
							data: { accID: id },
							success: function() {
								Swal.fire(
									'Changed!',
									'Your file has been changed.',
									'success'
								);
								location.href = "/CarShop/admin/account-home";
							}
						});
					}
				});
			});
		});
	}, deleteTypeCar: function() {
		$('.typecar__button__deleteTypeCar').each(function() {
			$(this).on('click', function() {
				var id = $(this).data('id');
				console.log(id);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, Detele it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							url: '/CarShop/admin/delete-typecar',
							data: { typecarID: id },
							success: function() {
								Swal.fire(
									'Changed!',
									'Your file has been changed.',
									'success'
								);
								$(this).remove();
								console.log(this);
								console.log('Co');
							},
							error: function() {
								Swal.fire({
									icon: 'error',
									title: 'Oops...',
									text: 'You cannot delete it !',
									footer: '-'
								})
							}
						});
					}
				});
			});
		});
	}, deleteBrandCar: function() {
		$('.brandcar__button__deleteBrandcar').each(function() {
			$(this).on('click', function() {
				var id = $(this).data('id');
				console.log(id);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, Detele it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							url: '/CarShop/admin/delete-brandcar',
							data: { brandID: id },
							success: function() {
								Swal.fire(
									'Changed!',
									'Your file has been changed.',
									'success'
								);
								location.href = "/CarShop/admin/home-brandcar";
							},
							error: function() {
								Swal.fire({
									icon: 'error',
									title: 'Oops...',
									text: 'You cannot delete it !',
									footer: '-'
								})
							}
						});
					}
				});
			});
		});
	}, viewMoreCar: function() {
		$('.car__button__viewmorecar').each(function() {
			$(this).on('click', function() {
				var id = $(this).data('id');
				console.log(id);
				$.ajax({
					type: 'GET',
					url: '/CarShop/admin/viewmore-car',
					data: { carID: id },
					dataType: 'json',
					success: function(data) {
						$('#myModal').modal('show');
						$('#textViewMoreID').text('CAR ID : ' + data.carid);
						$('#textViewMoreColor').text('CAR Color : ' + data.color);
						$('#textViewMoreDateBuy').text('CAR DateBuy : ' + data.dateBuy);
						$('#textViewMoreFuel').text('CAR Fuel : ' + data.fuel);
						$('#textViewMoreTranmission').text('CAR Tranmission : ' + data.tranmission);
						$('#textViewMoreFeature').text('CAR Feature : ' + data.feature);
					}
				})
			});
		});
	}, deleteCar: function() {
		$('.car__button__deleteCar').each(function() {
			$(this).on('click', function() {
				var id = $(this).data('id');
				console.log(id);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, Detele it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							url: '/CarShop/admin/delete-car',
							data: { carID: id },
							success: function() {
								Swal.fire(
									'Changed!',
									'Your file has been changed.',
									'success'
								);
								location.href = "/CarShop/admin/home-car";
							},
							error: function() {
								Swal.fire({
									icon: 'error',
									title: 'Oops...',
									text: 'You cannot delete it !',
									footer: '-'
								})
							}
						});
					}
				});
			});
		});
	}, deleteServiceCar: function() {
		$('.servicecar__button__deleteServiceCar').each(function() {
			$(this).on('click', function() {
				var id = $(this).data('id');
				console.log(id);
				Swal.fire({
					title: 'Are you sure?',
					text: "You won't be able to revert this!",
					icon: 'warning',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: 'Yes, delete it!'
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'POST',
							data: { ServiceID: id },
							url: '/CarShop/admin/delete-servicecar',
							success: function() {
								Swal.fire(
									'Deleted!',
									'Your file has been deleted.',
									'success'
								)
								location.href = "/CarShop/admin/home-servicecar";
							}
						});

					}
				});
			});
		});
	}, changeServiceValue: function() {
		$('.service__select__changeValue').on('change', function() {
			var valueSelect = $(this).val();
			if (valueSelect != 0) {
				$.ajax({
					type: 'POST',
					url: '/CarShop/service-detail',
					data: { serviceID: valueSelect },
					dataType: 'json',
					success: function(data) {
						console.log(data.price + '' + data.serviceDescription);
						$('#servicePrice').val(data.price + ' $');
						$('#serviceDescription').val(data.serviceDescription);
					}
				});
			} else {
				$('#servicePrice').val('Price');
				$('#serviceDescription').val('Description');
			}
		});
	}, bookingService: function() {
		$('.sevice__button__booking').on('click', function() {
			Swal.fire({
				title: 'Do you want to book the service?',
				showDenyButton: true,
				showCancelButton: true,
				confirmButtonText: 'OK',
				denyButtonText: `NO`,
			}).then((result) => {
				/* Read more about isConfirmed, isDenied below */
				if (result.isConfirmed) {
					$('#formBooking').submit();
				} else if (result.isDenied) {
					Swal.fire('Changes are not saved', '', 'info')
				}
			});
		});
	}, changeStatusBookingService: function() {
		$('.status__button__changeStatus').each(function() {
			$(this).on('click', function() {
				var val = $(this).val();
				var id = $(this).data('id');
				console.log(id);
				console.log(val);
				Swal.fire({
					title: 'Do you want to upgrade the status to Processing ?',
					showDenyButton: true,
					showCancelButton: true,
					confirmButtonText: 'Save',
					denyButtonText: `Don't save`,
				}).then((result) => {
					if (result.isConfirmed) {
						$.ajax({
							type: 'GET',
							url: '/CarShop/tech/change-status-tech',
							data: {
								orderID: id,
								status: val
							},
							dataType: 'json',
							success: function() {
								Swal.fire('Saved!', '', 'success');
								location.href = "/CarShop/tech/home-request";
							}
						});
					} else if (result.isDenied) {
						Swal.fire('Changes are not saved', '', 'info')

					}
				});
			});
		});
	}, drawChartByTech: function() {
		$(document).ready(function() {
			$.ajax({
				type: 'GET',
				url: '/CarShop/tech/draw-chart',
				dataType: 'json',
				success: function(data) {
					console.log(data.month1);
					var xValues = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
					var yValues = [data.month1, data.month2, data.month3, data.month4, data.month5, data.month6, data.month7, data.month8, data.month9, data.month10, data.month11, data.month12];
					new Chart("myChartTech", {
						type: "line",
						data: {
							labels: xValues,
							datasets: [{
								fill: false,
								lineTension: 0,
								backgroundColor: "rgba(0,0,255,1.0)",
								borderColor: "rgba(0,0,255,0.1)",
								data: yValues
							}]
						},
						options: {
							legend: {
								display: false
							},
							scales: {
								yAxes: [{
									ticks: {
										min: 0,
										max: 100
									}
								}],
							}
						}
					});
				}
			});

		});
	}, sendRequestChangeTech: function() {
		$('.request__button__changeTech').on('click', function() {
			var idOrder = $(this).data('id');
			var idTech = $('.request__select__changeTech').val();
			console.log(idOrder + ' ' + idTech);
			Swal.fire({
				title: 'Do you want to save the changes?',
				showDenyButton: true,
				showCancelButton: true,
				confirmButtonText: 'Save',
				denyButtonText: `Don't save`,
			}).then((result) => {
				if (result.isConfirmed) {
					$.ajax({
						type: 'GET',
						url: '/CarShop/tech/send-request-tech',
						data: {
							orderID: idOrder,
							techID: idTech
						},
						dataType: 'json',
						success: function() {
							Swal.fire('Saved!', '', 'success');
							location.href = '/CarShop/tech/home-request';
						}
					});

				} else if (result.isDenied) {
					Swal.fire('Changes are not saved', '', 'info')
				}
			});
		});
	}
};
data.init();