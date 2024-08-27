package InputoutputTest;

// 여러 학생의 성적(Score)을 기억하는 클래스
public class Score {
	public static int num;
	private int index;
	private String name;
	private int korScore;
	private int engScore;
	private int matScore;
	
	public Score() {}

	public Score(String name, int korScore, int engScore, int matScore) {
		this.index = ++num;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.matScore = matScore;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMatScore() {
		return matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}

	@Override
	public String toString() {
		return "학생 순서 번호: " + index + "이름: " + name + "국어: " + korScore + "영어: " + engScore
				+ "수학: " + matScore;
	}
	
	
}
