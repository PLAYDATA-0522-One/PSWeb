package com.playdata.game.servlet;

import com.playdata.game.dao.CharDao;
import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GameOverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //정보 업데이트
        HttpSession session = req.getSession();
        UserNow userNow = (UserNow) session.getAttribute("userNow");
        new CharDao().setUserData(userNow);

        req.getRequestDispatcher("views/gameover.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // 저장하기
        session.setAttribute("userNow",null);
        session.setAttribute("map",null);
        session.setAttribute("coordinate",null);

        resp.sendRedirect("/logout");
    }
}
