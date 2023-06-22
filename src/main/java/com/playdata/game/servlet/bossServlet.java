package com.playdata.game.servlet;

import com.playdata.game.dao.CharDao;
import com.playdata.game.dao.MonsterDao;
import com.playdata.game.dto.Monster;
import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class bossServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Monster monster;
        UserNow userNow;
        userNow = (UserNow) session.getAttribute("userNow");

        // 맵에서 넣은거 가져오기
        if (session.getAttribute("monster") == null) {
            monster = new MonsterDao().meetMonster(12);
            session.setAttribute("monster", monster);
            System.out.println(monster.getName());
            // 없으면 새로 만들기
        } else {
            monster = (Monster) session.getAttribute("monster");
            //이미 있으면 가져와
        }
        req.setAttribute("user", userNow);
        req.setAttribute("monster", monster);

        req.getRequestDispatcher("/views/boss.jsp").forward(req, resp);
        //배틀페이지 보여줘
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int mode = Integer.parseInt(req.getParameter("action"));

        UserNow userNow = (UserNow) session.getAttribute("userNow");
        Monster monster = (Monster) session.getAttribute("monster");

        System.out.println(monster.getName());
        System.out.println(userNow.getNow_hp());

        int changeMonsterHp = 0;
        int changeCharacterHp = 0; // 넣을 값을 세팅한다.
        int attack =0;
        int takenDa = 0;
        int giveDa = 0;
        if (mode == 1) { // 공격
            attack = monster.attack();

            changeCharacterHp = userNow.getNow_hp() - attack;
            changeMonsterHp = monster.getNow_hp() - userNow.attack();

            userNow.setNow_hp(changeCharacterHp);
            monster.setNow_hp(changeMonsterHp);
            if(attack <5) {
                session.setAttribute("usermessage", "이것도 공격이냐");
            } else if (attack<10) {
                session.setAttribute("usermessage", "맞을만 한데?");
            } else if (attack<20) {
                session.setAttribute("usermessage", "적당히 아프군");
            } else {
                session.setAttribute("usermessage", "윽, 너무 아프군");
            }
        } else if (mode == 2) {
            // 방어 만들기?
            attack = monster.attack();
            changeCharacterHp = userNow.getNow_hp() - attack;
            // 장비 가져오기, 장비가 있을시, 특정 이벤트 생각중

            changeCharacterHp += 5;

            userNow.setNow_hp(changeCharacterHp);
            session.setAttribute("usermessage", "방어도 때론 좋은 수단이지");
        }


        if (userNow.getNow_hp() <= 0) //0이되면 죽는다. 참고로 내가 먼저 죽는다.
        {// 바로 게임오버 페이지로
            resp.sendRedirect("/gameover");

        } else if (monster.getNow_hp() < 0) { // 적의 hp를 체크한다
            session.setAttribute("usermessage", null);

            int nowex = userNow.getExp();
            userNow.setExp(monster.getExp() + nowex);
            if (userNow.getExp() >= 100) {
                userNow.setExp(userNow.getExp() % 100);
                userNow.setLevel(userNow.getLevel() + 1);
                userNow.setHp(userNow.getHp() + 20);
                userNow.setNow_hp(userNow.getHp());
                userNow.setAttackpoint(userNow.getAttackpoint() + 10);
            } // 레벨업을 해라

            int nowgold = userNow.getGold();
            int dropgold = (int) ((Math.random() * 100) + 1); //드랍율
            userNow.setGold(nowgold + dropgold);
            // 골드도 받아와라

            new CharDao().dropEquipment(monster);
            // 장비 추가, 바로 추가된다.
            // 여기서 유저에게 장비가 추가된다.
            // db에 존재하고, 세션에는 존재하지 않는다.

            session.setAttribute("userNow", userNow);
            //set을해야하나? 그냥 맵에서 읽어오는게 나은데.

            new CharDao().addUserData(userNow); /// 이게 유저 업데이트이다.
            // 여기서 유저의 값을 한번 업데이트 해야함.
            // 세션과 데이터 모두.
            session.setAttribute("monster",null);// 몬스터초기화

            //승리 페이지 만들기
            resp.sendRedirect("/map"); // 결과창을 만들고 싶다.

        } else { // 나도 적도 hp가 0이 아니면 다시 싸우러 가야지
            session.setAttribute("userNow", userNow);
            session.setAttribute("monster", monster); // 값 갱신하기
            resp.sendRedirect("/battle"); // 아무도 안죽었으면 다시 싸우러 가야한다.
        }
    }
}
