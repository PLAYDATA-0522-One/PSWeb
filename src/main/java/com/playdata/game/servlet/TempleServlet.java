package com.playdata.game.servlet;

import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TempleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        UserNow userNow = (UserNow) session.getAttribute("userNow");
        req.setAttribute("gold",userNow.getGold());
        req.setAttribute("nowHealth",userNow.getNow_hp());
        req.setAttribute("Health",userNow.getHp());

        req.getRequestDispatcher("views/mapTemple.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int mode = Integer.parseInt(req.getParameter("action"));
 UserNow user =(UserNow) session.getAttribute("userNow");
        if(mode == 1){
            int gold = user.getGold();
            if(user.getNow_hp() == user.getHp()){

                session.setAttribute("usermessage","치료할필요없어");
            } else if (gold > 50){
                user.setGold(gold - 50);
                user.setNow_hp(user.getHp());
                session.setAttribute("usermessage","전부치료되었어");
            } else {
                session.setAttribute("usermessage","이런,돈이 부족해");
            }
            resp.sendRedirect("/temple");
        }
        else if (mode == 2) {
            session.setAttribute("usermessage","이제 뭐하지?");
            resp.sendRedirect("/village");
        }
    }
}
