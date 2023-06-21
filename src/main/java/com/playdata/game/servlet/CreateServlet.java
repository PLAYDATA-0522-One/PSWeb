package com.playdata.game.servlet;

import com.playdata.game.dao.CharacterDao;
import com.playdata.game.dto.Character;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String job = req.getParameter("job");
        int hp;
        int attackPoint;

        // 직업에 따라 hp와 attackPoint 설정
        if ("전사".equals(job)) {
            hp = 150;
            attackPoint = 15;
        } else if ("마법사".equals(job)) {
            hp = 100;
            attackPoint = 20;
        } else {
            // 기본값 설정
            hp = 120;
            attackPoint = 18;
        }

        CharacterDao characterDao = new CharacterDao();
        Character character = characterDao.insert(uname, job, hp, attackPoint);

        // 세션에 캐릭터 정보 저장
        HttpSession session = req.getSession();
        session.setAttribute("uname", uname);
        session.setAttribute("job", job);
        session.setAttribute("character", character);

        resp.sendRedirect("/create");
    }
}
