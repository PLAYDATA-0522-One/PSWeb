package com.playdata.game.servlet;

import com.playdata.game.action.MapMove;
import com.playdata.game.dao.CharDao;
import com.playdata.game.dto.MapDto;
import com.playdata.game.dto.UserNow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("map") == null){
          MapDto map = new MapDto(3,4);
          int[] coordinate = new int[2];
          map.setMap(0,0,1);
          session.setAttribute("coordinate",coordinate);
          session.setAttribute("map",map);
        }// 맵 생성 및 세션에 넣기

        if(session.getAttribute("userNow") == null){
            UserNow userNow = new UserNow(1, "user", 1, 500, 0, 50, 0, 0, 10, false, false);
            new CharDao().addUserData(userNow);
            session.setAttribute("userNow",userNow);
        } // 유저 세션에 넣기 원래는 받아와야함. 즉 생성 자체를 다른 곳에서 해야함.
        // ( 아마도 게임 스타트쪽이 아닐까 싶음.)


       // 캐릭터 읽어와서 세션에 넣어두어야함.

        req.getRequestDispatcher("views/map.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        HttpSession session = req.getSession();
       int balance = 7;

       int mode = Integer.parseInt(req.getParameter("action"));
        MapDto map  = (MapDto) session.getAttribute("map");
        int[] coordinate  = (int[]) session.getAttribute("coordinate");
        int x = coordinate[1];
        int y = coordinate[0];

        int [] XY = new MapMove().moving(mode,y,x);

        System.out.println(XY[0]);
        System.out.println(XY[1]);
        System.out.println(0000);
        System.out.println(map.getMap().length-1);
        System.out.println(map.getMap()[0].length-1);

            if((XY[0] == map.getMap().length-1) && (XY[1] == map.getMap()[0].length-1) ){
                resp.sendRedirect("/boss");
            } else if (XY[0] > map.getMap().length -1 || XY[1] > map.getMap()[0].length -1
            || XY[0] < 0|| XY[1] < 0){
                XY[0] = y;
                XY[1] = x;
                String message = "거긴 갈 수 없어";
                session.setAttribute("usermessage",message);

                resp.sendRedirect("/map");
            }else{
                session.setAttribute("usermessage",null);
                session.setAttribute("coordinate",XY);
                if( map.getMap()[XY[0]][XY[1]] == 2 ){
                    map.setMap(y,x,2);
                    map.setMap(XY[0],XY[1],1);
                    session.setAttribute("map",map);

                    resp.sendRedirect("/map");
                }else if(map.getMap()[XY[0]][XY[1]] == 0 ) {
                    map.setMap(y,x,2);
                    map.setMap(XY[0],XY[1],1);
                    session.setAttribute("map",map);
                    int where = (int) (Math.random()*10);
                    if(where < balance){
                        resp.sendRedirect("/battle");
                    }else if (balance <= where ) {
                        resp.sendRedirect("/village");
                    }
                }
            }
        }
}
