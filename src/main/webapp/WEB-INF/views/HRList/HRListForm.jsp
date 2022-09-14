<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication property="principal" var="principal" />

<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/resources/css/suit/listSuit.css" rel="stylesheet"/>
<link href="${contextPath}/resources/css/font.css" rel="stylesheet"/>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

    $(function(){

        var validation_ck = false;

        $("#keywordInput").bind("keydown", function(event) {
            var num = /^[0-9]*$/;
            var eng = /^[a-zA-Z]*$/;
            var temp = $("#keywordInput").val();
            var searchType = $("#searchType").val();

            if(searchType == "e_ID" || searchType == "d_ID") {
                if(!num.test(temp)) {
                    console.log('숫자만 입력하세요');
                    $("#keywordInput").val(temp.replace(/[^0-9]/g,""));
                }
            }else if(searchType == "e_NAME" || searchType == "d_NAME"){
                if(!eng.test(temp)) {
                    console.log('영어만 입력하세요');
                    $("#keywordInput").val(temp.replace(/[^a-zA-Z]/g,""));
                }
            }

        });

        $('#suit_searchBtn').click(function() {
            self.location = "mainHRList.html?" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
 	})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="get" >
    <div id='HRList_boardwrap'>
        <div id='HRList_boardList'>
            <table>
                <thead>
                    <tr>
                        <th id=th-s1>직원ID</th>
                        <th id=th-s2>이름</th>
                        <th id=th-s3>부서ID</th>
                        <th id=th-s4>부서명</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="item" items="${hrList }">
                    	<tr class='HRList_content'>
                    		<td>${item.employee_id }</td>
                    		<td>${item.full_name }</td>
                    		<td>${item.department_id }</td>
                    		<td>${item.department_name }</td>
                    	</tr>
                 	</c:forEach>
                </tbody>
            </table>
        </div>


        <div id='suit_boardfooter'>

            <div id = 'suit_boardbtnbox'>

                <div class="suit_search">
                    <select id="searchType" name="searchType" class="select_suitSearch">
                        <option value="all"<c:out value="${scri.searchType eq 'all' ? 'selected' : ''}"/>>전체</option>
                        <option value="e_ID"<c:out value="${scri.searchType eq 'e_ID' ? 'selected' : ''}"/>>직원ID</option>
                        <option value="e_NAME"<c:out value="${scri.searchType eq 'e_NAME' ? 'selected' : ''}"/>>이름</option>
                        <option value="d_ID"<c:out value="${scri.searchType eq 'd_ID' ? 'selected' : ''}"/>>부서ID</option>
                        <option value="d_NAME"<c:out value="${scri.searchType eq 'd_NAME' ? 'selected' : ''}"/>>부서명</option>
                    </select>
                    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
                    <!-- <button type='button' id="suit_searchBtn" class='boardbtn searchbtn'><i class="bi bi-search"></i></button> -->
                    <button type='button' id="suit_searchBtn" class='boardbtn searchbtn'>검색</button>
                    <button type='button' id="" onclick="location.href='${contextPath}/mainHRList.html'" class='boardbtn searchbtn'>목록</button>
                </div>

            </div>


            <div id='suit_pagebtn'>
                <ul>
                    <c:if test="${pageMaker.prev}">
                        <li id="suit_page"><button type='button' onclick="location.href='mainHRList.html${pageMaker.makeSearch(pageMaker.startPage - 1)}'"><i class="bi bi-chevron-left"></i></button></li>
                    </c:if>

                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                        <li id="suit_page"><button type='button' onclick="location.href='mainHRList.html${pageMaker.makeSearch(idx)}'">${idx}</button></li>
                    </c:forEach>

                    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                        <li id="suit_page"><button type='button' onclick="location.href='mainHRList.html${pageMaker.makeSearch(pageMaker.endPage + 1)}'"><i class="bi bi-chevron-right"></i></button></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</form>

</body>

</html>