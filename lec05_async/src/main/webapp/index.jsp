<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 연습하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>1. 텍스트 데이터</h1>
	<h2>(1) GET 방식</h2>
	<input type="text" name="user_id" id="user_id">
	<input type="button" value="아이디 길이 구하기" id="ajax_get_btn">
	<div id="ajax_get_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_get_btn").click(function(){
				console.log("1 : 클릭 이벤트 동작");
				const userId = $("#user_id").val();
				console.log("2 : 사용자 정보 받아와졌는가");
				$.ajax({
					url : "/getTextAjax?userId="+userId,
					type : "get",
					success : function(data){
						// data => <p>아이디 : OOO (n글자)</p>
						console.log("3 : 요청 정상 동작 여부");
						//$("#ajax_get_div").html(data);
						
						const h3 = $('<h3>').text(data);
						$("#ajax_get_div").html(h3);
					},
					error : function(){
						alert("요청 실패!!");
					}
				});
			});
		});
	</script>
	
	
	<h2>(2) POST 방식</h2>
	<button type="button" id="ajax_post_btn">
		아이디 길이 구하기 ver2.
	</button>
	<div id="ajax_post_div"></div>
	<script>
		$(document).ready(function(){
			$("#ajax_post_btn").click(function(){
				const userId = $("#user_id").val();
				$.ajax({
					url: "/postTextAjax",
					type: "post",
					data : {userId : userId},
					success : function(data){
						const p = $("<p>").text(data);
						$("#ajax_post_div").html(p);
					},
					error : function(){
						alert("요청 실패!");
					}
				});
			});
		});
	</script>
	
	<h1>성적 계산기</h1>

	<label for="kor">국어 : </label>
	<input type="number" id="kor"><br>
	
	<label for="eng">영어 : </label>
	<input type="number" id="eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>
	
	<script>
		$(document).ready(function(){
			$("#btnPost").click(function(){
				const kor = $("#kor").val();
				const eng = $("#eng").val();
				const math = $("#math").val();
				$.ajax({
					url: "/resultPostAjax",
					type: "post",
					data : {
						kor : kor,
						eng : eng,
						math : math
					},
					success : function(data){
						const p = $("<p>").text(data);
						$("#resultArea").html(p);
					},
					error : function(){
						alert("요청 실패!");
					}
				});
				
			});
		});
	</script>
	<h1>JSON + AJAX</h1>
	<input type="text" id="searchName">
	<button type="button" id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	<script>
		$(document).ready(function(){
				$("#json_get_btn").click(function(){
					// 1. 사용자 이름 정보 가져오기	
					const keyword = $("#searchName").val();
					//2. get방식(비동기) 요청
					
					
					// 3. Servlet에 Account List 목록에서
					// 해당 이름 존재하는지 확인
					// 이름이 포함된 사람 목록 응답
					$.ajax({
						url: "/searchAccount?name="+keyword,
						type : "get",
						dataType : "json",
						success : function(data){
							// 4. 화면에 목록 형태로 출력
		/*					const no = data.no;
							const name = data.name;
							
							$('#json_get_div').append('<p>'+no+"번 : " +name+"</p>"); */
							
							if(data.arr.length != 0){
								for(let i = 0; i < data.arr.length ; i++){
									const account = data.arr[i];
									$("#json_get_div").append('<p>'+account.no+"번 : "+account.name+"</p>");
								}
							}
						}
					});
					
				});
			});	
	</script>
	
	<h1>도서 검색</h1>
	<label>도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>
	
	<script>
	$(document).ready(function(){
		$("#book_get_btn").click(function(){
			const searchBook = $("#searchBook").val();
			
			$.ajax({
				url: "/searchBook?bookName="+searchBook,
				type : "get",
				dataType : "json",
				success : function(data){
					// 4. 화면에 목록 형태로 출력
					console.log(data);
					const bookNo = data.bookNo;
					const bookName = data.bookName;
					const author = data.author;
					
					
					$('#book_get_div').append('<p>'+bookNo+" : " +bookName+"-"+author+"</p>");
				}
			});
		});
	});
	</script>
	<h1>카테고리별 상품 조회</h1>
	<select id="categorySelect">
		<option value="1">전자제품</option>
		<option value="2">생활용품</option>
		<option value="3">패션</option>
	</select>
	<button type="button" id="searchBtn">조회</button>
	<div id="productListArea"></div>
	<script>
		$(function(){
			$("#categorySelect").change(function(){
				// 1. 선택된 카테고리 정보 가져오기
				const categoryCode = $(this).val();
				console.log(categoryCode);
				// 2. ajax 통신을 통해 목록 조회
				$.ajax({
					url : "/searchProduct",
					type : "post",
					data : {code : categoryCode},
					dataType : 'json',
					success : function(data){
						// 3. 화면에 출력하기
						if(data.arr.length === 0){
							$("#productListArea").html("해당 카테고리의 상품이 없습니다.")
						} else{
							
						}					
					}
				})
			});
		});
	</script>
	<h1>[과제] 방명록 비동기 통신</h1>
	<a href=/guestBook>방명록 작성하러 가기</a>
	
</body>
</html>