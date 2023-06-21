<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/user.css">
    <link rel="stylesheet" href="css/public.css">
    <title>ID CHECK</title>
</head>
<body class="bodycolor2">
<header>
    <div class="top">
        <a href="/main"><p class="mainfont logo">PLAY DATA <br> STORY</p></a>
        <a href=""><p class="mainfont aboutus">About us</p></a>
    </div>
</header>



<section>

    <div class="login_main">
        <p class="main_text">ID CHECK</p>

        <form  action="/idCheck" method="post">

            <div class="login_input">
                <p class="user_text">User ID</p>
                <input class="user_input" type="text" name="username" placeholder="아이디를 입력하세요" required>

                <% if((Boolean) session.getAttribute("idCheck") == true) {%>
                    <p style="color: white">아이디가 중복되었습니다.</p>
                <%}else if ((Boolean) session.getAttribute("idCheck") == false){%>
                <p style="color: white">아이디를 사용할 수 있습니다.</p>
                <%}else {%>
                <%}%>
                <input type="submit" class="idchk_btn" value="중복확인">

            </div>


        </form>
        <a href="/signup"><input type="submit" class="user_botton" value="회원가입"></a>
    </div>
</section>
<footer>
    <img class="footer2" src="/img/footer1.png" alt="footer">
</footer>

</body>
</html>
