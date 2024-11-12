package mvc.user.dao;

import mvc.user.domain.UserRequestDTO;
import mvc.user.domain.UserResponseDTO;

public class UserDao {
	
	public UserResponseDTO loginRow(UserRequestDTO params) {
		System.out.println("debug >>> db 연결");
		UserResponseDTO response = null;
		if(params.getId().equals("jlism") && params.getPwd().equals("jlism")) {
		
		response = new UserResponseDTO("jlism","jlism","임정섭");
		
		}
		
		return response;
	}
	
	
	
	
}
