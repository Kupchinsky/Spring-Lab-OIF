<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Shop</title>
</head>
<body>
    <div>
        <img src="/assets/shop.jpg" alt="" />
    </div>
    <h3>Feedback message: <c:out value="${feedbackMessage.feedbackMessageId}"/></h3>

    <table>
        <tbody>
            <tr>
                <td>ID:</td>
                <td><c:out value="${feedbackMessage.feedbackMessageId}"/></td>
            </tr>
            <tr>
                <td>Created:</td>
                <td><c:out value="${feedbackMessage.created}"/></td>
            </tr>
            <tr>
                <td>E-Mail:</td>
                <td><c:out value="${feedbackMessage.senderEmail}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><c:out value="${feedbackMessage.senderName}"/></td>
            </tr>
            <tr>
                <td>Message:</td>
                <td><c:out value="${feedbackMessage.message}"/></td>
            </tr>
        </tbody>
    </table>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
    <div><a href="/feedback/list">Feedback list</a></div>
</body>
</html>