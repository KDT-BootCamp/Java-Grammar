package mvc.user.domain;

public class UserRequestDTO {

	private String id;
	private String pwd;
	public UserRequestDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserRequestDTO [id=" + id + ", pwd=" + pwd + "]";
	}

}
