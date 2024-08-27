package Properties;

// VO(Value Object)
//  사용자 정보 데이터 1건과 데이터를 처리할 수 있는 메서드를 모아놓은 클래스 DTO
public class UserInfo {
	private String userID;
	private String userName;
	private String usePassword;
	
	public UserInfo() {
	}

	public UserInfo(String userID, String userName, String usePassword) {
		this.userID = userID;
		this.userName = userName;
		this.usePassword = usePassword;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsePassword() {
		return usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	@Override
	public String toString() {
		return "[userID=" + userID + ", userName=" + userName + ", usePassword=" + usePassword + "]";
	}
	
	
}
