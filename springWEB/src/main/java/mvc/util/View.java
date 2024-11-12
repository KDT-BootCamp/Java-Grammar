package mvc.util;

public class View {
	private String responseJsp;
	private boolean isFlag ;
	public View(String responseJsp, boolean isFlag) {
		super();
		this.responseJsp = responseJsp;
		this.isFlag = isFlag;
	}
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getResponseJsp() {
		return responseJsp;
	}
	public void setResponseJsp(String responseJsp) {
		this.responseJsp = responseJsp;
	}
	public boolean isFlag() {
		return isFlag;
	}
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	@Override
	public String toString() {
		return "View [responseJsp=" + responseJsp + ", isFlag=" + isFlag + "]";
	}
	
}
