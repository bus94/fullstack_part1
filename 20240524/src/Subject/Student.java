package Subject;

// 학생의 정보를 저장하는 클래스
public class Student {
	private int id;
	private String nickname;
	private int exam_score;
	private String title;
	private String grade;
	private double point;
	
	public Student() {}
	
	public Student(String nickname, String title) {
		this.nickname = nickname;
		this.title = title;
	}
	
	public Student(int id, String nickname, int exam_score, String title, String grade, double point) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.exam_score = exam_score;
		this.title = title;
		this.grade = grade;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getExam_score() {
		return exam_score;
	}

	public void setExam_score(int exam_score) {
		this.exam_score = exam_score;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nickname=" + nickname + ", exam_score=" + exam_score + ", title=" + title
				+ ", grade=" + grade + ", point=" + point + "]";
	}
	
	
	
}
