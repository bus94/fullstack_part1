package NetworkWithTeacher;

// DB에 가기 전 User의 정보를 전처리하는 클래스
public class UserService {
	private UserDAO dao = new UserDAO();

	public boolean join(User user) throws Exception{
		
		return dao.join(user);
	}

	public User login(String id, String password) throws Exception{
		
		
		return dao.login(id, password);
	} 
	
}
