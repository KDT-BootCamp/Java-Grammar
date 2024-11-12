package test.crtl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.domain.RequestTestDTO;
import test.domain.ResponseTestDTO;
import test.service.TestService;

@WebServlet("/index")
public class TestController extends HttpServlet {
	

	private TestService service ;
	
	public void init() {
		System.out.println("");
		service = new TestService();
	}
	
	public void destroy() {
		System.out.println("");

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		System.out.println("debug >>> client path : " + uri);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		RequestTestDTO params = new RequestTestDTO();
		params.setId(id); params.setPwd(pwd);
		
		ResponseTestDTO result = service.login(params);
		HttpSession session ;
		if(result != null) {
			session = request.getSession();
			response.sendRedirect("ok jsp");
		} else {
			session = request.getSession() ;
			session.setAttribute("errMsg", "입력데이터 확인 부탁드립니다");
			response.sendRedirect("error jsp");
		}
	}
}
