<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'cart.jsp' starting page</title>

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

	<table border="1px">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品数量</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.cart}" var="item">
				<tr>
					<form name="cartManager" method="post">
						<input type="hidden" value="${item.goods.goodsId}" name="goodsId">
						<td>${item.goods.goodsId}</td>
						<td>${item.goods.goodsName}</td>
						<td>${item.goods.price}</td>
						<td><input type="text" value="${item.count}" /></td>
						<td><input type="submit" value="修改" name="operate"> <input
							type="submit" value="删除" name="operate"></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
