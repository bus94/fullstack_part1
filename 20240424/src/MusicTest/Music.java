package MusicTest;

public class Music {

	private String title;
	private String singer;
	
	public Music(){
	}
	
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "제목: <" + title + "> 가수: " + singer;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		Music temp = (Music) obj;
		if(this == obj) {
			return true;
		}
		
		if(this.title.equals(temp.title) && this.singer.equals(temp.singer)) {
			return true;
		} else {
			return false;
		}
	}
	
}
