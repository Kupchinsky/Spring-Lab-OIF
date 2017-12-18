<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Shop</title>

    <style type="text/css">
        td, th {
            border: 1px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
    <div>
        <img src="/assets/shop.jpg" alt="" />
    </div>
    <h3>Order List</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Created</th>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td><c:out value="${order.productOrderId}"/></td>
                    <td><c:out value="${order.created}"/></td>
                    <td>
                        <a href="/product/single/<c:out value="${order.product.productId}"/>">
                            <c:out value="${order.product.productId}"/>
                        </a>
                    </td>
                    <td><c:out value="${order.product.name}"/></td>
                    <td><c:out value="${order.product.price}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
</body>
</html>