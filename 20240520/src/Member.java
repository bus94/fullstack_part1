
public class Member {
	private String hakbun;
	private String passwd;
	private String name;
	private String address;
	private String tel;
	private String email;
	private int number;
	private int grade;
	private int hakjom;
	
	public Member() {
	}
	
	public Member(String hakbun, String passwd) {
		this.hakbun = hakbun;
		this.passwd = passwd;
	}

	public Member(String hakbun, String passwd, String name, String address, String tel, String email, int number,
			int grade, int hakjom) {
		this.hakbun = hakbun;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.number = number;
		this.grade = grade;
		this.hakjom = hakjom;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getHakjom() {
		return hakjom;
	}

	public void setHakjom(int hakjom) {
		this.hakjom = hakjom;
	}
	
}
