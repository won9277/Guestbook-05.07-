package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.guestbookdao;
import com.sds.icto.guestbook.vo.guestbookvo;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String message = request.getParameter("content");
		guestbookvo vo = new guestbookvo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		guestbookdao dao = new guestbookdao();
		dao.insert(vo);
		response.sendRedirect("/guestbook2/g2");
	}

}
