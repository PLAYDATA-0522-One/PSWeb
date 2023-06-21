package com.playdata.game.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VillageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/mapvillage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
