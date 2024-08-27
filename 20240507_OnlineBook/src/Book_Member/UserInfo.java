package Book_Member;

import java.awt.Font;

public class UserInfo {
	// static으로 변수를 설정
	private static User mUser;
	
	public static void init(String name, String phone) {
		mUser = new User(name, phone);
		System.out.println("User 생성!");
	}

	public static User getmUser() {
		return mUser;
	}

	public static void setmUser(User mUser) {
		UserInfo.mUser = mUser;
	}
	
	
	
}
