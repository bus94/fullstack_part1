package Naver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Search {
	private String title;
	private String link;
	private String description;
	private String bloggername;
	private String bloggerlink;
//	private LocalDateTime postdate;
	private String postdate;
	
	public Search() {
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBloggername() {
		return bloggername;
	}
	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}
	public String getBloggerlink() {
		return bloggerlink;
	}
	public void setBloggerlink(String bloggerlink) {
		this.bloggerlink = bloggerlink;
	}
	public String  getPostdate() {
		return postdate;
	}
	public void setPostdate(String  postdate) {
		this.postdate = postdate;
	}

	@Override
	public String toString() {
//		String postDateString;
//		
//		// 현재 시간을 가지고 온다.
//		LocalDate current = LocalDate.now();
//		LocalDate postDate = postdate.toLocalDate();
//		
//		if(current.equals(postDate)) {
//			// 오늘 날짜인 경우 시간만 표시
//			postDateString = postdate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//		}else {
//			// 오늘이 아닌 날짜인 경우 년도, 월, 일만 표시
//			postDateString = postdate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//		}
//		
//		return "[title=" + title + ", link=" + link + ", description=" + description + ", bloggername="
//				+ bloggername + ", bloggerlink=" + bloggerlink + ", postdate=" + postDateString + "]";
		return "[title=" + title + ", link=" + link + ", description=" + description + ", bloggername="
				+ bloggername + ", bloggerlink=" + bloggerlink + ", postdate=" + postdate + "]";
		
	}
	
}
