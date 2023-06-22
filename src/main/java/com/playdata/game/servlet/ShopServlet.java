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
        req.setAttribute("portion",userNow.getPortion());

        req.getRequestDispatcher("views/mapShop.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int mode = Integer.parseInt(req.getParameter("action"));
        UserNow userNow = (UserNow) session.getAttribute("userNow");
        if(mode == 1 && userNow.getGold() >50){
            userNow.setPortion(userNow.getPortion() +1);
            userNow.setGold(userNow.getGold() -50 );
            session.setAttribute("userNow",userNow);
            session.setAttribute("usermessage","포션을 샀습니다");
            resp.sendRedirect("/shop");
            //구매
        } else if (mode == 1 && userNow.getGold() < 50) {
            session.setAttribute("usermessage","돈이 부족해");
            resp.sendRedirect("/shop");
        }else if (mode == 2) {
            session.setAttribute("usermessage","패치중입니다.");
            resp.sendRedirect("/shop");
            //판매
        } else if (mode == 3) {
            session.setAttribute("usermessage","이제 뭐하지?");
            resp.sendRedirect("/village");
        }
    }
}
