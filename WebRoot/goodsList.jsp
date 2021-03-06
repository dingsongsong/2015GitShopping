<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<a href="GetGoodsServlet?pageNo=1">第一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${pageNo>1}"><a href="GetGoodsServlet?pageNo=${pageNo-1}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
	<c:if test="${pageNo<pageCount}"><a href="GetGoodsServlet?pageNo=${pageNo+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
	<a href="GetGoodsServlet?pageNo=${pageCount}">最后一页</a>
	<table border="1px">
		<thead>
			<tr>
				<th>商品编号</th><th>商品名称</th><th>商品价格</th><th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${goodsList}" var="goods">
			<tr>
				<td>${goods.goodsId}</td>
				<td>${goods.goodsName}</td>
				<td>${goods.price}</td>
				<td><a href="AddToCartServlet?goodsId=${goods.goodsId}">将商品添加到数据库当中</a></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
