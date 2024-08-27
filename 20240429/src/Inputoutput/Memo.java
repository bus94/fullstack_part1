package Inputoutput;

import java.time.LocalDateTime;

// 메모 한 건 저장하는 클래스
// 게시글
public class Memo {

	// 글 번호 자동 증가에 사용할 정적 필드
	public static int count;
	// 자동으로 1 씩 증가하는 글번호
	private int idx; 
	// 작성자 이름
	private String name;
	// 비밀번호
	private String password;
	// 메모(내용)
	private String memo;
	private LocalDateTime writeDate;
	
	public Memo() {}
	public Memo(String name, String password, String memo) {
		idx = ++count;
		this.name = name;
		this.password = password;
		this.memo = memo;
		this.writeDate = LocalDateTime.now();
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public LocalDateTime getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
	
	// Object 클래스가 가지고 있는 toString을 내 클래스에 맞게 재정의
	// toString 특별한 메서드 객체의 변수명만 작성하면 자동으로 toString이 호출된다
	
	// 업캐스팅 = Object
	@Override
	public String toString() {
		return "Memo [idx=" + idx + ", name=" + name + ", password=" + password + ", memo=" + memo + ", writeDate="
				+ writeDate + "]";
	}
	
	
	
}

// static (정적) 멤버 변수
// static을 붙여서 선언한 변수나 메서드는 클래스
// 객체를 생성하지 않고 클래스 이름에 "."을 찍어서 접근 할 수 있다
// static 붙여서 선언한 변수는 현재 클래스 객체가 생성될 때 
//  최초 1번만 메모리에 만들어지고 현재 클래스의 객체가 다시 생성되더라도 변수가 새로 만들어지지 않는다

// 인스턴스 멤버 변수
//  객체를 생성할 때 마다 각각 생성되는 변수들
//  현재 클래스가 생성하는 모든 객체에서 독립된 기억 공간을 가질 수 있다









