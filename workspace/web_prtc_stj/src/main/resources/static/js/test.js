$(function() {
	$('#login_btn').on('click', function() {
		var form = {
			id: $('#id').val(),
			pw: $('#pw').val()
		}
		alert(form.id + ":" + form.pw)
		
	});
	
});