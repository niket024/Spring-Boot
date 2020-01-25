$(document).ready(function() {
	listEmployee();
	$("#empId").keyup(function() {
		if ($(this).val().length > 0) {
			getbyId($(this).val());
		}else{
			listEmployee();
		}
	});
	$("#empName").keyup(function() {
		if ($(this).val().length > 0) {
			getbyName($(this).val());
		}else{
			listEmployee();
		}
	});

});

function getbyId(empId) {
	var table = $('#employeesTable').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ajax" : {
			"url" : "/employee/" + empId,
			"type" : "GET"
		},
		"sAjaxDataProp" : "",
		destroy : true,
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "id"
		}, {
			"mData" : "name"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"mData" : "phone"
		}, {
			"mData" : "active"
		} ]
	})
}
function getbyName(empName) {
	var table = $('#employeesTable').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ajax" : {
			"url" : "/employee/name=" + empName,
			"type" : "GET"
		},
		"sAjaxDataProp" : "",
		destroy : true,
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "id"
		}, {
			"mData" : "name"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"mData" : "phone"
		}, {
			"mData" : "active"
		} ]
	})
}
function listEmployee() {
	var table = $('#employeesTable').DataTable({
		"sAjaxSource" : "/employees",
		"sAjaxDataProp" : "",
		destroy : true,
		"order" : [ [ 0, "asc" ] ],
		"aoColumns" : [ {
			"mData" : "id"
		}, {
			"mData" : "name"
		}, {
			"mData" : "lastName"
		}, {
			"mData" : "email"
		}, {
			"mData" : "phone"
		}, {
			"mData" : "active"
		} ]
	})
}