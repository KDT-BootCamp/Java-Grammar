package mvc.factory;

import mvc.trl.IndexController;
import mvc.user.ctrl.ErrorController;
import mvc.user.ctrl.JoinController;
import mvc.user.ctrl.ListController;
import mvc.user.ctrl.LoginController;
import mvc.user.ctrl.LogoutController;
import mvc.util.Controller;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {	
		private Map<String, Controller> map ;
		private static BeanFactory instance ;
		
		private BeanFactory() {
			map = new HashMap();
			map.put("/springWEB/index.kdt",new IndexController());
			map.put("/springWEB/login.kdt",new LoginController());
			map.put("/springWEB/joinForm.kdt",new JoinController());
			map.put("/springWEB/logout.kdt",new LogoutController());
			map.put("/springWEB/list.kdt",new ListController());
			map.put("/springWEB/error.kdt",new ErrorController());
		}
		
		public static BeanFactory getInstance() {
			if(instance == null) {
				instance = new BeanFactory();
			}
			return instance ;
		}
		
		public Controller getController(String path) {
			return map.get(path);
		}
}
