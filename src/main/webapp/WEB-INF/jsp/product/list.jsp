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
    <h3>Product List</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>
                        <a href="/product/single/<c:out value="${product.productId}"/>">
                            <c:out value="${product.productId}"/>
                        </a>
                    </td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.description}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td>
                        <a href="/product/single/<c:out value="${product.productId}"/>">Show components</a>
                    </td>
                    <td>
                        <a href="/product/buy/<c:out value="${product.productId}"/>">Buy</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
</body>
</html>