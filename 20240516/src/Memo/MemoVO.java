package Memo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoVO {
	private int idx;
	private String name;
	private String password;
	private String memo;
	private LocalDateTime writeDate;

	public MemoVO() {
	}

	public MemoVO(int idx, String name, String password, String memo, LocalDateTime writeDate) {
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.memo = memo;
		this.writeDate = writeDate;
	}

	// 글을 추가할 때 3개의 변수만 받는 생성자
	public MemoVO(String name, String memo, String password) {
		this.name = name;
		this.password = password;
		this.memo = memo;
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

	@Override
	public String toString() {
		// 오늘 입력된 메모는 시간만 표시 / 전날 입력한 메모는 날짜만 표시 → 포멧 형식을 2개로 작성
		// toString() 작성하기
		LocalDate today = LocalDate.now();
		LocalDate memoDate = writeDate.toLocalDate();
		
		// 오늘
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("HH:mm");
		// 어제 이전 
		DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("yyyy.MM.dd(E)");
		boolean isToday = memoDate.equals(today);
		
		return String.format("%d. %s %s %s", idx, name, memo, isToday? writeDate.format(sdf) : writeDate.format(sdf1));
//		return "[글 번호: " + idx + ", 작성자: " + name + ", 비밀번호: " + password + ", 메모: " + memo + ", 작성일: "
//				+ writeDate + "]";
	}

}
