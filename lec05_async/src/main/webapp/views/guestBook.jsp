<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 등록 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h2>방명록</h2>
	<input type="text" id="name" placeholder="이름">
	<input type="text" id="message" placeholder="메시지">
	<button id="submitBtn">등록</button>
	
	<ul id="messageList"></ul>
	
	<script>
	 $('#submitBtn').click(function(){
		 const name = $('#name').val().trim();
		 const message = $('#message').val().trim();
		 
		 if(!name || !message){
			 alert('이름과 메시지를 모두 입력해주세요.');
			 return;
		 }
		 
		 $.ajax({
			url: '/submitGuestbook',
			type: 'POST',
			dataType: 'json',
			data: { name: name, message: message},
			success: function (data){
				const li = '<li>' + data.name + ' ' + data.message + '</li>';
				$('#messageList').append(li);
				$('#name').val('');
				$('#message').val('');
			},
			error: function(){
				alert('등록 중 오류가 발생했습니다.');
			}
			 
			 
		 });
		 
	 });

	</script>
	
</body>
</html>