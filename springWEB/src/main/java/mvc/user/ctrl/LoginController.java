package mvc.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.user.domain.UserRequestDTO;
import mvc.user.domain.UserResponseDTO;
import mvc.user.service.UserService;
import mvc.util.Controller;
import mvc.util.View;

public class LoginController implements Controller{

	private UserService service;
	public LoginController() {
		service = new UserService();	
	}
	
	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserRequestDTO requestUser = new UserRequestDTO(); 
		
		System.out.println("debug >>> "  + id  + pwd);
		
		requestUser.setId(id);
		requestUser.setPwd(pwd);
		
		UserResponseDTO responseUser = null; 
		responseUser = service.login(requestUser);
		View view = new View() ;
		if(responseUser != null) {
		//	HttpSession session = request.getSession();
			request.setAttribute("loginUser", responseUser);
			view.setFlag(true);
			view.setResponseJsp("./main.jsp");
		} else {
			view.setFlag(false);
			view.setResponseJsp("./error.jsp");
		}
	
	return view;
	}
}
