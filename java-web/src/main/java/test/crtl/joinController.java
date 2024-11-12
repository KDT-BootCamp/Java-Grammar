package test.crtl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.domain.RequestJoinDTO;
import test.service.JoinTest;

@WebServlet("/joinUser")
public class joinController extends HttpServlet {

	private JoinTest service ;
	
	public void init() {
		service = new JoinTest();
	}
	
	public void destroy() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println("debug >>> client path : " + uri);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		String name = request.getParameter("name");		
		String gender = request.getParameter("gender");
		
		RequestJoinDTO params = new RequestJoinDTO();
		
		params.setId(id); params.setPwd(pwd); params.setName(name);
		params.setGender(gender);
		
		String result = service.join(params);
		HttpSession session ;
		if(result.equals(null)) {
			System.out.println("틀렸습니다.");
			session = request.getSession();
			response.sendRedirect("joinOk.jsp");
			session.setAttribute("msg","실패");
		} else {
			System.out.println(result);
			session = request.getSession();
			response.sendRedirect("joinOk.jsp");
			session.setAttribute("msg",result);
		}
	

	}
}
