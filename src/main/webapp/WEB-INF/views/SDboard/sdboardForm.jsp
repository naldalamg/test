<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="principal" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href="${contextPath }/resources/css/font.css">
<link rel='stylesheet' href="${contextPath }/resources/css/sdBoard/sdBoard.css">

<script  type="text/javascript">
    function register(){

    }
</script>

<title>Insert title here</title>
</head>

<body>

<form method="post" action="${contextPath}/regBoard.do" enctype="multipart/form-data">

    <div id="sdboard_body">
        <div class="sdboard_NO">
            <input type="hidden" name="sd_board_NO" value="${sdboardVO.sd_board_NO}">
        </div>
        <div class="sdboard_title">
            <p><span>제목</span>
            <input type="text" name="sd_title" value="${sdboardVO.sd_title}"></p>
        </div>
        <div class="sdboard_memberId">
            <p><span>작성자</span>
            <input type="text" name="member_id" value="${sdboardVO.member_id}" readonly></p>
        </div>
        <div class="sdboard_content">
            <p><span>내용</span>
            <textarea name="sd_content">${sdboardVO.sd_content}</textarea></p>
        </div>
        <div class="sdboard_date">
            <p><span>등록일</span>
            <input type="text"  value="${sdboardVO.sd_regDate}"></p>
        </div>

        <div class="sdboard_btn">

            <button type="submit" >등록</button>
            <button type="submit">수정</button>
            <button type="button" onClick="location.href='${contextPath}/deleteSDboard.do?sd_board_NO=${sdboardVO.sd_board_NO}'" >삭제</button>
        </div>
    </div>

</form>

</body>
</html>