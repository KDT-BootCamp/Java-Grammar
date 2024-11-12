package mvc.user.service;

import mvc.user.dao.UserDao;
import mvc.user.domain.UserRequestDTO;
import mvc.user.domain.UserResponseDTO;

public class UserService {
	
	private UserDao dao ;
	
	public UserService() {
		dao = new UserDao();
	}
	
	public UserResponseDTO login(UserRequestDTO params) {
		return dao.loginRow(params);
		
	}
}
