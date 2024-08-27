package GUI_Table_Test;

public class Board {
	private int num;					// 글번호
	private String title; 				// 글제목
    private String writer; 				// 작성자
    private String content; 			// 글내용
    private int readCount;				// 조회수
    
    public Board() {
    }
    
    // 자바 GUI에서 입력을 해서 보낼 때 
    // 생성자에서 초기화하지 않으면 자동으로 int → 0으로 자동 초기화 된다.
    public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
    
    // 생성자 오버로딩(DB에서 한 행의 글을 꺼내올 때)
	public Board(int num, String title, String writer, String content, int readCount) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
}
