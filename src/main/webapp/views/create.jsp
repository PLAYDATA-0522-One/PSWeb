<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/char.css" />
    <link rel="stylesheet" href="/css/character.css" />
    <title>PLAYDATA STORY</title>
    <script>
        function showJobInfo(job) {
            let jobs = document.getElementsByClassName('job');
            for (let i = 0; i < jobs.length; i++) {
                jobs[i].classList.remove('active');
            }
            job.classList.add('active');
            let jobInput = document.getElementById('job');
            jobInput.value = job.innerText.trim();
        }
    </script>

</head>
<body class="bodycolor">
<header>
    <div class="top">
        <p class="mainfont logo">
            PLAY DATA <br />
            STORY
        </p>
        <p class="mainfont aboutus">About us</p>
        <form action="/select" method="post">
            <button class="headerbutton headerbuttonfont headerbuttonlogin mainfont">캐릭터 선택</button>
        </form>
        <form action="/logout" method="post">
            <button class="headerbutton headerbuttonfont headerbuttonsignup mainfont">나가기</button>
        </form>
    </div>
</header>
<div class="joystick1"></div>
<div class="joystick2"></div>
<div class="joystick3"></div>
<div class="container">
    <form action="/select" method="post">
        <div class="form-group">
            <label for="uname"><span style="color: aliceblue">캐릭터 이름:</span></label>
            <div>
                <input type="text" id="uname" name="uname" placeholder="캐릭터 이름을 입력하세요" />
            </div>
        </div>
        <div class="form-group">
            <label>
                <span style="color: aliceblue">직업: 전사, 마법사, 도적 중 선택해주세요!</span>
            </label>
            <div class="character-selection">
                <div class="job" onclick="showJobInfo(this)">
                    <h2>전사</h2>

                    <img src="/img/warrior.png" alt="전사 이미지">
                </div>
                <div class="job" onclick="showJobInfo(this)">
                    <h2>마법사</h2>

                    <img src="/img/magician.png" alt="마법사 이미지">
                </div>
                <div class="job" onclick="showJobInfo(this)">
                    <h2>도적</h2>

                    <img src="/img/Thief.png" alt="도적 이미지">
                </div>
            </div>
            <input type="hidden" id="job" name="job" value="" />
        </div>
        <button class="btn" type="submit">캐릭터 생성</button>
    </form>
</div>
</body>
</html>