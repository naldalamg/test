<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="principal" />

<!DOCTYPE html>
<html>
<head>

<link href="${contextPath}/resources/css/font.css" rel="stylesheet"/>
<link href="${contextPath}/resources/css/suit/listSuit.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>Insert title here</title>


<script  type="text/javascript">


</script>

</head>



<body>
<form method="get" >
	<div id='soda_boardwrap'>
        <div id='soda_boardList'>
            <table>
                <thead>
                    <tr>
                        <th id=th-s1>게시판번호</th>
                        <th id=th-s2>제목</th>
                        <th id=th-s3>작성자</th>
                        <th id=th-s4>등록일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="item" items="${allList }">
                    	<tr class='soda_content'>
                    		<td>${item.sd_board_NO }</td>
                    		<td><a href="${contextPath}/sdboardForm.html?sd_board_NO=${item.sd_board_NO}">${item.sd_title }</a></td>
                    		<td>${item.member_id }</td>
                    		<td>${item.sd_regDate }</td>
                    	</tr>
                 	</c:forEach>
                </tbody>
            </table>
        </div>

        <div>
            <button type='button' onclick="location.href='${contextPath}/sdboardForm.html'">글쓰기</button>
        </div>

        <div id='suit_pagebtn'>
            <ul>
                <c:if test="${pageMaker.prev}">
                    <li id="suit_page"><button type='button' onclick="location.href='listSDboard.do${pageMaker.makeSearch(pageMaker.startPage - 1)}'"><i class="bi bi-chevron-left"></i></button></li>
                </c:if>

                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                    <li id="suit_page"><button type='button' onclick="location.href='listSDboard.do${pageMaker.makeSearch(idx)}'">${idx}</button></li>
                </c:forEach>

                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                    <li id="suit_page"><button type='button' onclick="location.href='listSDboard.do${pageMaker.makeSearch(pageMaker.endPage + 1)}'"><i class="bi bi-chevron-right"></i></button></li>
                </c:if>
            </ul>
        </div>
    </div>

</form>


</body>
</html>