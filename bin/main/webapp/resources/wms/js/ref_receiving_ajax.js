

// 날짜 형식 조정
$.fn.dataTable.render.moment = function (from, to, locale) {
	// Argument shifting
	if (arguments.length === 1) {
		locale = 'en';
		to = from;
		from = 'YYYY-MM-DD';
	} else if (arguments.length === 2) {
		locale = 'en';
	}

	return function (d, type, row) {
		if (!d) { return type === 'sort' || type === 'type' ? 0 : d; }

		var m = window.moment(d, from, locale, true);

		// Order and type get a number value from Moment, everything else
		// sees the rendered value
		return m.format(type === 'sort' || type === 'type' ? 'x' : to);
	};
};


// 거래처 삭제(선택삭제)
function clientChoiceDelete(csrfParameter, csrfToken) {
	var formData = JSON.stringify($('input[name=client_id]:checked').serialize());
	console.log(formData);

	$.ajax({
		type: 'POST',
		url: window.location.href + '/clientChoiceDelete?' + csrfParameter + '=' + csrfToken, // 현 위치 + RestController url
		data: formData,
		dataType: 'json',
		accept: "application/json",
		contentType: "application/json; charset=utf-8",
		beforeSend: function (xhr) {
			xhr.setRequestHeader(csrfParameter, csrfToken);
		},
		success: function (data) {
			if (data) {
				alert('선택한 거래처가 삭제되었습니다');
				currTab.ajax.reload();
			}
		},
		error: function () {
			alert('오류');
		},
	});

	event.preventDefault();
}


//등록한 거래처(구매처) 목록
function registeredClientList() {
	currTab = $('#registeredClientList').DataTable({
		"order": [[1, "desc"]],
		ajax: {
			url: window.location.href + '/registeredClientList', // 현 위치
			type: 'POST',
			data: csrfData,
			dataSrc: ''
		},
		columns: [
			{
				data: null,
				render: function (data, type, row, meta) {
					return '<a href="/logistics_erp/purchase/clientDetail?id=' + row.id + '" onclick="window.open(this.href, width=1200, height=700); return false;">' + row.name + '</a>';
				}
			}, {
				data: 'id',
			}, {
				data: 'register_num',
			}, {
				data: 'ceo_name',
			}, {
				data: 'phone',
			}, {
				data: 'address',
			}, {
				data: 'register_date',
				render: $.fn.dataTable.render.moment()
			}
		],
		destroy: true,
		retrieve: true
	});
}

