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
    <h3>Feedback List</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Created</th>
                <th>E-Mail</th>
                <th>Name</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${feedbackMessageList}" var="msg">
                <tr>
                    <td>
                        <a href="/feedback/single/<c:out value="${msg.feedbackMessageId}"/>">
                            <c:out value="${msg.feedbackMessageId}"/>
                        </a>
                    </td>
                    <td><c:out value="${msg.created}"/></td>
                    <td><c:out value="${msg.senderEmail}"/></td>
                    <td><c:out value="${msg.senderName}"/></td>
                    <td><c:out value="${msg.message}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
</body>
</html>