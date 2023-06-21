package com.playdata.game.servlet;

import com.playdata.game.dao.CharacterDao;
import com.playdata.game.dto.Character;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String job = req.getParameter("job");
        CharacterDao characterDao = new CharacterDao();
        List<Character> character = characterDao.findByCharacter(name, job);
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("job", job);

        resp.sendRedirect("/select");
    }
}
