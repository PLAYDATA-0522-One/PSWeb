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
    private CharacterDao characterDao;

    @Override
    public void init() throws ServletException {
        super.init();
        characterDao = new CharacterDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String job = req.getParameter("job");

        // TODO: 유효성 검사 등 필요한 로직 추가

        // Character 객체 생성 및 필드 설정
        Character character = new Character();
        character.setUname(uname);
        character.setJob(job);
        character.setLevel(1);  // 예시로 레벨 1로 설정

        characterDao.createCharacter(character);

        // 생성된 캐릭터를 조회하여 세션에 저장
        List<Character> characters = characterDao.findByCharacter(uname, job);
        HttpSession session = req.getSession();
        session.setAttribute("characters", characters);
        resp.sendRedirect("/select");
    }
}

