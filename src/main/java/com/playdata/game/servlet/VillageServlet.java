package com.playdata.game.servlet;

import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VillageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserNow userNow = (UserNow) session.getAttribute("userNow");
        req.setAttribute("gold",userNow.getGold());
        req.setAttribute("nowHealth",userNow.getNow_hp());
        req.setAttribute("Health",userNow.getHp());
        req.setAttribute("portion",userNow.getPortion());

        req.getRequestDispatcher("views/mapvillage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("message",null);

        int mode = Integer.parseInt(req.getParameter("action"));
        if(mode == 1){
            resp.sendRedirect("/shop");
        } else if (mode == 2) {
            resp.sendRedirect("/temple");
        } else if (mode == 3) {
            //( 현재 맵 업데이트 해야함.)
            resp.sendRedirect("/map");

        }

    }
}
