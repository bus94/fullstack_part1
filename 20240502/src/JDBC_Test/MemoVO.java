package JDBC_Test;

import java.time.LocalDateTime;

public class MemoVO {

	// static 영역은 모든 클래스가 공유해서 사용한다.
	private static int num = 1;
	private int memNo;
	private String memTitle;
	private String memContent;
	private LocalDateTime memDate;
	
	public MemoVO() {
	}
	
	public MemoVO(String memTitle, String memContent) {
		this.memNo = num++;
		this.memTitle = memTitle;
		this.memContent = memContent;
		// 현재 시간을 자동으로 생성하기
		this.memDate = LocalDateTime.now();
	}
	
	public MemoVO(int memNo, String memTitle, String memContent, LocalDateTime memDate) {
		this.memNo = memNo;
		this.memTitle = memTitle;
		this.memContent = memContent;
		this.memDate = memDate;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemTitle() {
		return memTitle;
	}

	public void setMemTitle(String memTitle) {
		this.memTitle = memTitle;
	}

	public String getMemContent() {
		return memContent;
	}

	public void setMemContent(String memContent) {
		this.memContent = memContent;
	}

	public LocalDateTime getMemDate() {
		return memDate;
	}

	public void setMemDate(LocalDateTime memDate) {
		this.memDate = memDate;
	}

	@Override
	public String toString() {
		return "MemoVO 글 번호: " + memNo + ", 글 제목: " + memTitle + ", 글 내용: " + memContent + ", 작성 날짜: "
				+ memDate + "]";
	}
	
}
