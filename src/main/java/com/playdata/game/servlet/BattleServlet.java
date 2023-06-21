package com.playdata.game.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BattleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Monster monster = (Monster) session.getAttribute("monster");
//
//        if(monster == null){
//            //몬스터 생성 시퀀스
//            // 몬스터를 세션에 넣어둠
//        }??



        //몬스터가 널이면 가져와
        //몬스터가 널이 아니면 가져오지마 있는거 써.
        // 여기가 페이지 맨처음에 시행하는 부분
        //  여기서 몬스터를 읽어와서.
        // 몬스터를 세션에 넣고
        // 몬스터와 관련된 함수를 진행하고,

        req.getRequestDispatcher("views/mapBattle.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //여기가 배틀 만약 몬스터 죽으면 몬스터 바로 null로 보내버리기.
        // 몬스터 세션에서 불러와서 쓰고
    }
}
