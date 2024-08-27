package Properties;

// <인터페이스> : 다중 상속을 하지 못하는 것을 해결해주는 역할
// 1) 여러 개의 클래스에 공통적인 기능을 구현하기 위해
// 2) 공통적인 기능을 꼭 사용할 수 있도록 제한시키기 위해
public interface UserInfoDAO {

	// 추가할 때 사용하는 메서드
	public void insertUserInfo(UserInfo user);

	// 수정할 때 사용하는 메서드
	public void updateUserInfo(UserInfo user);

	// 삭제할 때 사용하는 메서드
	public void deleteUserInfo(UserInfo user);

}
