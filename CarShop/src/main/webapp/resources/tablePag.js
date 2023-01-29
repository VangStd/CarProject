/**
 * 
 */
$('.tablemanager').tablemanager({
	firstSort: [[3, 0], [2, 0], [1, 'asc']],
	disable: ["last"],
	appendFilterby: true,
	dateFormat: [[4, "mm-dd-yyyy"]],
	debug: true,
	vocabulary: {
		voc_filter_by: 'Filter By   ',
		voc_type_here_filter: 'Filter...',
		voc_show_rows: 'Choose Rows  '
	},
	pagination: true,
	showrows: [5, 10, 20, 50, 100],
	disableFilterBy: [1]
});