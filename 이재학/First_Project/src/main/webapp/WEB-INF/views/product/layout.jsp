<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>
                <jsp:include page="/common/header.jsp" flush="false"/>
            </td>
        </tr>
        <tr>
            <td>
                <jsp:include page="productList.jsp" flush="false"/>
            </td>
        </tr>
        <tr>
            <td>
                <jsp:include page="/common/footer.jsp" flush="false"/>
            </td>
        </tr>
    </table>


출처: https://all-record.tistory.com/106 [세상의 모든 기록]
</body>
</html>