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
        }
    </script>
        // function showWarriorInfo() {
        //     document.getElementById('hp-warrior').innerText = '150';
        //     document.getElementById('attack-warrior').innerText = '15';
        //     document.getElementById('image-warrior').src = "";
        //     document.getElementById('hp-wizard').innerText = '100';
        //     document.getElementById('attack-wizard').innerText = '20';
        //     document.getElementById('image-wizard').src = "";
        //     document.getElementById('hp-thief').innerText = '120';
        //     document.getElementById('attack-thief').innerText = '18';
        //     document.getElementById('image-thief').src = "";
        }
</head>
<body class="bodycolor">
<header>
    <div class="top">
        <p class="mainfont logo">
            PLAY DATA <br />
            STORY
        </p>
        <p class="mainfont aboutus" action="/select" method="post">About us</p>
        <button class="headerbutton headerbuttonfont headerbuttonlogin mainfont">캐릭터 생성</button>
        <button class="headerbutton headerbuttonfont headerbuttonsignup mainfont">나가기</button>
    </div>
</header>
<div class="joystick1"></div>
<div class="joystick2"></div>
<div class="joystick3"></div>
<div class="container">
    <form action="/select" method="post">
        <div class="form-group">
            <label for="name"><span style="color: aliceblue">캐릭터 이름:</span></label>
            <div>
                <input type="text" id="name" name="name" placeholder="캐릭터 이름을 입력하세요" />
            </div>
        </div>
        <div class="form-group">
            <label for="character">
                <span style="color: aliceblue">직업: 전사, 마법사, 도적 중 선택해주세요!</span>
            </label>
            <div class="character-selection">
                <div id= "character"  class="job" onclick="showJobInfo(this)">
                    <h2>전사</h2>
                    <p>체력: 150</p>
                    <p>공격력: 15</p>
                    <img src="/img/warrior.png" alt="전사 이미지">
                </div>
                <div class="job" onclick="showJobInfo(this)">
                    <h2>마법사</h2>
                    <p>체력: 100</p>
                    <p>공격력: 20</p>
                    <img src="/img/magician.png" alt="전사 이미지">
                </div>
                <div class="job" onclick="showJobInfo(this)">
                    <h2>도적</h2>
                    <p>체력: 120</p>
                    <p>공격력: 18</p>
                    <img src="/img/Thief.png" alt="전사 이미지">
                </div>
            </div>
        </div>
        <button class="btn" type="submit">캐릭터 생성</button>
    </form>
</div>
</body>
</html>