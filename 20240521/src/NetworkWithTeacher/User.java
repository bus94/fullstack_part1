package NetworkWithTeacher;

//회원가입하는 한 명의 정보를 저장하는 클래스
public class User {

	// 이름,아이디,패스워드,폰번호, 이메일,생년월일
	private String name;
	private String id;
	private String password;
	private String phoneNumber;
	private String email;
	private String birthDate;

	public User(String name, String id, String password, String phoneNumber, String email, String birthDate) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthDate = birthDate;
	}

	// Getter and Setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", id='" + id + '\'' + ", password='" + password + '\''
				+ ", phoneNumber='" + phoneNumber + '\'' + ", email='" + email + '\'' + ", birthDate='" + birthDate
				+ '\'' + '}';
	}

}
