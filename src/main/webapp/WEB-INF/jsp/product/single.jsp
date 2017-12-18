<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Shop</title>

    <style type="text/css">
        table.components > tbody > tr > td, table.components > thead > tr > th {
            border: 1px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
    <div>
        <img src="/assets/shop.jpg" alt="" />
    </div>
    <h3>Product: <c:out value="${product.productId}"/></h3>

    <table>
        <tbody>
            <tr>
                <td>ID:</td>
                <td><c:out value="${product.productId}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><c:out value="${product.name}"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><c:out value="${product.description}"/></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><c:out value="${product.price}"/></td>
            </tr>
        </tbody>
    </table>

    <h4>Components</h4>
    <table class="components">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${product.productComponents}" var="component">
                <tr>
                    <td><c:out value="${component.productComponentId}"/></td>
                    <td><c:out value="${component.name}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
    <div><a href="/product/list">Product list</a></div>
    <div><a href="/order/list">Order list</a></div>
</body>
</html>