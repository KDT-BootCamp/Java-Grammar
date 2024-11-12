package mvc.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.util.Controller;
import mvc.util.View;

public class JoinController implements Controller{

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) {
		View view = new View();
		view.setResponseJsp("joinForm.jsp");
		view.setFlag(true);
		return view;

	}
	
}
