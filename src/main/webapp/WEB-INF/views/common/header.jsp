<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"  %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	/* var flag = true;
	$('.h-loginfo').click(function() {
		if (flag) {
			$('#sidebar-container').animate({
				right : '0px'
			}, 200);
		} else {
			$('#sidebar-container').animate({
				right : '-300px'
			}, 200);
		}
		flag = !flag;
	}); */
	$('.h-loginfo').click(function(){
		$('#sidebar-container').animate({
			right : '0px'
		}, 300);
	});
	
	
	$('.close-box').click(function(){
		$('#sidebar-container').animate({
			right : '-300px'
		}, 300);
	});
	
	
	
	
	
	$('.smenu').hover(function() {
		$(this).stop().animate({
			opacity : 1
		}, 300);
	}, function() {
		$(this).stop().animate({
			opacity : 0.7
		}, 300);
	});

});
    </script>
<style>
#sidebar-container {
	position: fixed;
	top: 0px;
	width: 200px;
	height: 100%;
	right: -300px;
	z-index: 99998;
	border-left: 2px solid gray;
}

#sidebar-container .siderbar-head {
	width: 300px;
	height: 10px;
	position: absolute;
	z-index: 10;
	background: black;
}

.bg-navy {
	background-color: rgb(50, 60, 70);
	color: #fff;
	top: 0;
}

.sidebar-content {
	position: relative;
	height: 100%;
	/*            padding: 0px 15px;*/
	overflow: auto;
	overflow-x: hidden;
	background: white;
	line-height: 40px;
	font-weight: bold;
	top: 0;
}

.sidebar-content>ul>li {
	position: relative;
	width: 190px;
	height: 38px;
	background: white;
	opacity: 0.7;
	/* border-bottom: 1px solid white; */
	border-bottom: 2px solid gray;
	color: black;
}
.sidebar-content>ul>li:hover{
	background:#E6E6E6;
}

.smenutop {
	/* margin-top:2px; */
	
}

.smenu {
	padding-left: 10px;
}

.smenu:hover+.smenuli {
	height: 40px;
}

.smenuli {
	height: 0;
	transition: height 0.3s linear;
	overflow: hidden;
}

.smenuli:hover {
	height: 40px;
}

.smenu a {
	width: 190px;
	display: inline-block;
}

.smenuli a {
	width: 190px;
	display: inline-block;
	background: white;
	color: black;
	padding-left: 10px;
}

.smenuli a:hover {
	background: #E6E6E6;
}

.sidebar-idrap {
	width: 200px;
	height: 130px;
	
}

.sidebar-id {
	width: 180px;
	height: 100px;
	font-size: 30px;
	padding-left: 20px;
	line-height: 100px;
}
.sidebar-mymenu{
width: 195px;
	height: 30px;
	font-size: 18px;
	padding-left: 5px;
	line-height: 30px;
	
}

.sidebar-mymenu span{
border-bottom:2px solid gray;
}

.close-box{
margin-top: 100px;
width:20px;
height:50px;
line-height: 50px;
border-right: 2px solid gray;
border-top: 2px solid gray;
border-bottom: 2px solid gray;
font-size:20px;
font-weight:bold;
border-radius:0px 10px 10px 0px;
}

.close-box:hover{
cursor:pointer;

}</style>
</head>

<body>
<!-- ????????????  ?????????-->

<sec:authorize access="hasRole('ROLE_ADMIN')">
<div id="sidebar-container">
		<div class="sidebar-head bg-navy"></div>
		<div class="sidebar-content">
			<div class="sidebar-idrap">
				<div class="sidebar-id"><sec:authorize access="isAuthenticated()">
						<sec:authentication property="name" />					
					</sec:authorize>???</div>
				<div class="sidebar-mymenu"><span>Admin Menu</span></div>
			</div>
			<ul>
				<li class="smenu smenutop"><a href="#">????????????</a></li>
				<!-- <ul class="smenuli">
					<li><a href="#">??????</a></li>
				</ul> -->
				<li class="smenu"><a href="${path}/admin/listMembers.do">?????????????????????</a></li>
				<li class="smenu"><a href="#">????????????</a></li>
				

				<!--              <li class="smenu">??????6</li>
              <li class="smenu">??????7</li>
  -->
			</ul>
			<div class="close-box"><i class="bi bi-chevron-right"></i></div>
		</div>
		
	</div>
	</sec:authorize>
<!-- ???????????? ???????????? -->

<!-- ???????????? ???????????? -->
<sec:authorize access="hasRole('ROLE_USER')">
<div id="sidebar-container">
		<div class="sidebar-head bg-navy"></div>
		<div class="sidebar-content">
			<div class="sidebar-idrap">
				<div class="sidebar-id"><sec:authorize access="isAuthenticated()">
						<sec:authentication property="name" />					
					</sec:authorize>???</div>
				<div class="sidebar-mymenu"><span>My Menu</span></div>
			</div>
			<ul>
				<li class="smenu smenutop"><a href="#">????????????</a></li>
				<!-- <ul class="smenuli">
					<li><a href="#">??????</a></li>
				</ul> -->
				<li class="smenu"><a href="${path}/mypage.html">???????????????</a></li>
				<li class="smenu"><a href="#">????????????</a></li>
				

				<!--              <li class="smenu">??????6</li>
              <li class="smenu">??????7</li>
  -->
			</ul>
			<div class="close-box"><i class="bi bi-chevron-right"></i></div>
		</div>
		
	</div>
	</sec:authorize>
	<!-- ????????????  ???????????? ??? -->
       <div id='h-hrap'>
       
        <div id='h-toprap'>
            <div id='h-top'>
                <div id='h-logo'>
                    <a href="${path}/main.html"><img src="${path}/resources/image/logo.png"></a>
                </div>
                <div id='h-search'>
                    <input type="text" Placeholder='???????????? ??????????????????'>
                    <button type='button' onclick="location.href='#'" id='h-searchbtn'>
                        <i class="h-bi bi-search"></i>
                    </button>
                </div>
                <div id='h-login'>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                     	<sec:authentication property="name" />??? &nbsp
					  	<!-- <a class="h-log" href="#" onclick="document.getElementById('logout').submit();">????????????</a> -->
					  	<a class="h-log" href="${path}/security_logout">????????????&nbsp&nbsp</a>
					  	<a class="h-log h-loginfo" href="#">?????????????????? </a>
					</sec:authorize>
                	<sec:authorize access="isAnonymous()">
                    	<a class="h-log" href="${path}/login.html">????????? &nbsp&nbsp</a>
                    	<a class="h-log" href="${path}/signForm.html">???????????? &nbsp&nbsp </a>
                    </sec:authorize>
                    
                    <sec:authorize access="hasRole('ROLE_USER')">
                     	<sec:authentication property="name" />??? &nbsp
					  	<!-- <a class="h-log" href="#" onclick="document.getElementById('logout').submit();">????????????</a> -->
					  	<a class="h-log" href="${path}/security_logout">????????????&nbsp&nbsp</a>
					  	<a class="h-log h-loginfo" href="#">??????????????? </a>
					</sec:authorize>
					 
					<%-- <form id="logout"  action="${path}/security_logout" method="POST">
					   	<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
					</form> --%>
                   
                    

                </div>
            </div>
        </div>
        
        <div id="h-nav">
            <ul class="h-nav justify-content-center">
                <li class="h-nav-item">
                    <a class="h-nav-link" href="${path}/sogae.html" style="color: black">??????????????????</a>
              
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="#" style="color: black">????????????</a>
                    <ul class='h-sub'>
                        <li><a href='${path}/nadeulmok.html'>???????????????</a></li>
                        <li><a href='${path}/neonadeuli.html'>??????????????????</a></li>
                        <li><a href='${path}/dododo.html'>???????????????</a></li>
                        <li><a href='${path}/teojeon.html'>????????????</a></li>
                    </ul>
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="#" style="color: black">??????????????????</a>
                    <ul class='h-sub'>
                        <li><a href='${path}/mentalreview/introduceMental.html'>???????????? ??????</a></li>
                        <li><a href='${path }/mentalreview/counselMental.do'>???????????? ???????????? ??????</a></li>
                        <li><a href='${path}/mentalreview/listArticles.do'>????????????</a></li>
                     
                    </ul>
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="#" style="color: black">????????????????????????</a>
                    <ul class='h-sub'>
                        <li><a href='${path}/suitIntroduce.html'>???????????? ??????</a></li>
                        <li><a href='${path}/listSuitAll.do'>???????????? ??????/??????</a></li>
                        <li><a href='${path}/listSDboard.do'>?????? ?????????</a></li>
                      <%--   <li><a href='${contextPath}/djplat/suitForm.html'>???????????? ??????</a></li> --%>
                    
                    </ul>
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="#" style="color: black">?????????</a>
                    <ul class='h-sub'>
                        <li><a href='${contextPath }/djplat/djn.html'>????????? ??????</a></li>
                        <li><a href='${contextPath }/djplat/djnboard/listArticles.do'>????????? ??????</a></li>
                        
                    </ul>
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="#" style="color: black">????????????</a>
                    <ul class='h-sub'>
                        <li><a href='${contextPath}/djplat/yp/ypintro_Ustudent.do'>???????????? ??????</a></li>
                        <li><a href='${contextPath}/djplat/yp/ypconsult.do'>???????????? ?????????</a></li>
                 
                    </ul>
                </li>
                <li class="h-nav-item">
                    <a class="h-nav-link" href="${contextPath }/djplat/YS_board/listArticles.do" style="color: black">????????????</a>
                     <ul class='h-sub'>
                        <li><a href='${contextPath}/djplat/YS_board/listArticles.do'>??????????????????</a></li>
                    </ul> 
                </li>
            </ul>
        </div>
    </div>
       
</body>
</html>