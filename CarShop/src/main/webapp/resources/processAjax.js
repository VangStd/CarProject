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
								location.href = "/CarShop/admin/home-typecar";
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
	}
};
data.init();