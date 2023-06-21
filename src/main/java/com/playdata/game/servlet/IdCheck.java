package com.playdata.game.servlet;

import com.playdata.game.dao.UserDao;
import com.playdata.game.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IdCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("idCheck") == null) {
            session.setAttribute("idCheck", false);
        }
        req.getRequestDispatcher("/views/idCheck.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //
        String username = req.getParameter("username");

        HttpSession session = req.getSession();

        boolean user = new UserDao().idCheck(username);

        session.setAttribute("idCheck",user);

        resp.sendRedirect("/idCheck");

    }
}
