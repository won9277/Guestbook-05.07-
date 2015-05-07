package com.sds.icto.guestbook2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.web.Action;
import com.sds.icto.web.DeleteFormAction;
import com.sds.icto.web.IndexAction;
import com.sds.icto.web.AddAction;

/**
 * Servlet implementation class guestbook2
 */
@WebServlet("/g2")
public class guestbook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestbook2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			request.setCharacterEncoding("utf-8");
			String a = request.getParameter("a");
			Action action = null;
			
			if ("delete".equals(a)) {
				action = new DeleteFormAction();
				action.execute(request, response);
			}else if ("add".equals(a)){
				//이메일을 등록합니다.
				action = new AddAction();
				action.execute(request, response);
			} 
			
			if(action == null) {
				// default action
				action = new IndexAction();
				action.execute(request, response);

			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
