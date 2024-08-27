package Controller_Test;

public class MemberService {
	
	private MemberDAO mDAO;
	
	public MemberService() {}

	// 서비스는 DAO를 호출하는 클래스 (준비과정)
	public int login(MemberVO member) {
		mDAO.login(member);
		if(member != null) {
			return 1;
		}else {
			return 0;
		}
	}

}
