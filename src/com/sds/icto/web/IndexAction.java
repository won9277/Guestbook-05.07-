package com.sds.icto.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sds.icto.guestbook.dao.guestbookdao;
import com.sds.icto.guestbook.vo.guestbookvo;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws 
	SQLException,
	ClassNotFoundException,
	ServletException,
	IOException
	{
		guestbookdao dao = new guestbookdao();
		List<guestbookvo> list = dao.fetchList();
		request.setAttribute("list", list);
		WebUtil.forward("/view/index.jsp", request, response);
	}

}
