<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
	
<%@include file="include/header.jsp" %>

<!-- Main content -->
<section class="content">
	<div class="row">
	<!-- left column -->
	<div class="col-md-12">
		<!-- general form elements -->
		
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">MY HOME PAGE@ / contact me: jamesj4318@gmail.com<br>
				----------------------------------------------------------------------------------<br>
				This is the test page of my first Web Application.<br>
				- you can see the source code at here: 
				<a href="https://github.com/jamesj4318/myboard_001" target="_blank">
				https://github.com/jamesj4318/myboard_001</a><br>
				<br>
				Click 'LIST ALL' Button to go to my web board.
				</h3>
				
			</div>
		</div>
	</div><!-- /.col (left) -->
	</div><!-- /.row -->
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">LIST ALL</button>
	</div>
</section><!-- /.content -->

<script>
$(document).ready(function() {
	
	$(".btn-primary").on("click", function() {
		self.location = "${pageContext.request.contextPath}/board/listAll";
	});

});
</script>
	
<%@include file="include/footer.jsp" %>