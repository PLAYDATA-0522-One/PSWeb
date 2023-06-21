package com.playdata.game.servlet;

import com.playdata.game.dao.CharDao;
import com.playdata.game.dao.MonsterDao;
import com.playdata.game.dao.UserDao;
import com.playdata.game.dto.Monster;
import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BattleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Monster monster;
        UserNow userNow;
        userNow = (UserNow) session.getAttribute("userNow");

        // 맵에서 넣은거 가져오기
        if (session.getAttribute("monster") == null) {
            int n = new MonsterDao().randomMonster();
            monster = new MonsterDao().meetMonster(n);
            session.setAttribute("monster", monster);
            System.out.println(monster.getName());
            // 없으면 새로 만들기
        } else {
            monster = (Monster) session.getAttribute("monster");
            //이미 있으면 가져와
        }
        req.setAttribute("user",userNow);
        req.setAttribute("monster",monster);

        req.getRequestDispatcher("/views/mapBattle.jsp").forward(req, resp);
        //배틀페이지 보여줘
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session =req.getSession();
           int mode = Integer.parseInt(req.getParameter("action"));

        UserNow userNow = (UserNow) session.getAttribute("userNow");
        Monster monster = (Monster) session.getAttribute("monster");

        System.out.println(monster.getName());
        System.out.println(userNow.getNow_hp());

        if(monster.getNow_hp() > 0) { // 배틀을 하고있다면 여기서 계속 해야함.
            int changeMonsterHp=0;
            int changeCharacterHp=0; // 넣을 값을 세팅한다.
            int takenDa = 0;
            int giveDa = 0;
            if(mode == 1) { // 공격
                changeCharacterHp = userNow.getNow_hp() - monster.getAttackpoint();
                changeMonsterHp = monster.getNow_hp() - userNow.getAttackpoint();
                takenDa = userNow.getNow_hp() - changeCharacterHp;
                giveDa = monster.getNow_hp() - changeMonsterHp;

                userNow.setNow_hp(changeCharacterHp);
                monster.setNow_hp(changeMonsterHp);
                session.setAttribute("usermessage","윽, 아프군");
            } else if (mode==2) {
                // 방어 만들기?
                session.setAttribute("usermessage","방어는 때론 좋은 수단이지");
            }

            //System.out.println(userNow.getHp());
            ///
            //System.out.println(monster.getNow_hp());

            if(userNow.getNow_hp()<=0) //0이되면 죽는다.
            {// 바로 게임오버 페이지로

            }
            else {
                 req.setAttribute("takenDa",takenDa);
                 req.setAttribute("giveDa",giveDa);

                session.setAttribute("userNow",userNow);
                session.setAttribute("monster",monster); // 값 갱신하기
                resp.sendRedirect("/battle"); // 아무도 안죽었으면 다시 싸우러 가야한다.
                }
            }
        else if (monster.getNow_hp()<=0) // 혹시 몬스터가 죽었는가?
            {   session.setAttribute("usermessage",null);

                int nowex = userNow.getExp();
                userNow.setExp(monster.getExp()+nowex);
                if(userNow.getExp()>=100)
                {
                    userNow.setExp(userNow.getExp()%100);
                    userNow.setLevel(userNow.getLevel()+1);
                    userNow.setHp(userNow.getHp()+20);
                    userNow.setNow_hp(userNow.getHp());
                    userNow.setAttackpoint(userNow.getAttackpoint()+10);
                } // 레벨업을 해라

                int nowgold = userNow.getGold();
                int dropgold = (int)((Math.random() * 100)+1); //드랍율
                userNow.setGold(nowgold+dropgold);
                // 골드도 받아와라

                new CharDao().dropEquipment(monster);
                // 장비 추가, 바로 추가된다.
                // 여기서 유저에게 장비가 추가된다.
                // db에 존재하고, 세션에는 존재하지 않는다.

                session.setAttribute("userNow",userNow);
                //set을해야하나? 그냥 맵에서 읽어오는게 나은데.

                new CharDao().addUserData(userNow); /// 이게 유저 업데이트이다.
                // 여기서 유저의 값을 한번 업데이트 해야함.
                // 세션과 데이터 모두.

                resp.sendRedirect("/map"); // 결과창을 만들고 싶다.

                }
            }

        }

