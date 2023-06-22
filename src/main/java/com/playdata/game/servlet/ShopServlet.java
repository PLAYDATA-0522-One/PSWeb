package com.playdata.game.servlet;

import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserNow userNow = (UserNow) session.getAttribute("userNow");
        req.setAttribute("gold",userNow.getGold());
        req.setAttribute("nowHealth",userNow.getNow_hp());
        req.setAttribute("Health",userNow.getHp());

        req.getRequestDispatcher("views/mapShop.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mode = Integer.parseInt(req.getParameter("action"));
        if(mode == 1){
            //구매
        }
        else if (mode == 2) {
            //판매
        } else if (mode == 3) {
            resp.sendRedirect("/village");
        }
    }
}
