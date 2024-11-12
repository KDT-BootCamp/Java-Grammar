package mvc.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.util.Controller;
import mvc.util.View;

public class LogoutController implements Controller{

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		View view = new View();
		view.setResponseJsp("index.jsp");
		view.setFlag(false);
		return view;

	}
}
