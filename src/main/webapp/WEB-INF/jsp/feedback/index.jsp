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
    <h3>Leave us a message!</h3>

    <div>
        <form method="POST" action="/feedback/post" accept-charset="utf-8">
            <div><input type="text" name="name" value="" placeholder="Your name" /></div>
            <div><input type="text" name="email" value="" placeholder="Your E-Mail" /></div>
            <div>
                <textarea cols="30" rows="5" name="message" placeholder="Your message"></textarea>
            </div>
            <input type="submit" value="Send!" />
        </form>
    </div>

    <div style="margin-top: 20px"><a href="/">Home</a></div>
    <div><a href="/feedback/list">Feedback list</a></div>
</body>
</html>