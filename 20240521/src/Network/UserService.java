package Network;

// DB에 가기 전 User의 정보를 전처리하는 클래스
public class UserService {
	private UserDAO dao = new UserDAO();
	
	// User 회원 정보를 수정할 수 있는 Service
	
	// 로그인
	public User login(String id, String password) {
		System.out.println("UserService login() 메서드 실행!");
		return dao.login(id, password);
	}

	// 회원가입
	public void signUp(User user) {
		System.out.println("UserService signUp() 메서드 실행!");
		
		dao.insert(user);
	} 
	
}
