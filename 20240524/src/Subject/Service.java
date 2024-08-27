package Subject;

public class Service {
	private DAO dao = new DAO();

	// 1번 문제
	public void join1(Student student) throws Exception {
		dao.join1(student);
	}

	// 2번 문제
	public void join2() throws Exception {
		dao.join2();
	}

	// 3번 문제
	public void join3() throws Exception {
		dao.join3();
	}

	// 4번 문제
	public void join4() throws Exception {
		dao.join4();
	}

}
