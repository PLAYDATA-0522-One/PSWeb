package com.playdata.game.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("unserNow") !=null ){
            session.setAttribute("map",null);
            session.setAttribute("coordinate",null);
            session.setAttribute("usnerNow",null);
        }

        String uname = (String) session.getAttribute("uname");
        req.setAttribute("uname", uname);
        req.getRequestDispatcher("views/main.jsp").forward(req, resp);
    }
}
