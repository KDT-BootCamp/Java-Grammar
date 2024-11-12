package mvc.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.factory.BeanFactory;
import mvc.util.Controller;
import mvc.util.View;


@WebServlet("*.kdt")
public class DispatcherServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug >>> DispatcherServlet" );
		System.out.println("debug >>> client request path : " + request.getRequestURI() );
		
		BeanFactory factory = BeanFactory.getInstance();
		Controller ctrl = factory.getController(request.getRequestURI());
		
		View view = ctrl.execute(request,response);
		
		if(view.isFlag()) {
			RequestDispatcher rd = request.getRequestDispatcher(view.getResponseJsp());
			rd.forward(request,response);
		} else {
			response.sendRedirect(view.getResponseJsp());
		}
	}
}


