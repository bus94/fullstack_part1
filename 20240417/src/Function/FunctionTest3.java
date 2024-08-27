package Function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FunctionTest3 {

	public static void main(String[] args) {

		/*
		 *  시간 관련 클래스
		 *  Date 클래스
		 * 	DateTime 클래스
		 * 	LocalDateTime 클래스 (jdk 8버전 이상부터 가능)
		 * 
		 *  
		 */
		
		// 현재 시스템의 날짜와 시간 데이터를 가져온다
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// 가져온 날짜와 시간 데이터의 서식 지정
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 E요일");
		
		// LocalDateTime 클래스 안에서 내가 만든 날짜 형식 사용
		// now.format();
		System.out.println(now.format(format));
		
		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println("년: " + now.getYear());
		System.out.println("월: " + now.getMonthValue());
		System.out.println("일: " + now.getDayOfMonth());
		System.out.println("요일: " + now.getDayOfWeek());
		System.out.println("시: " + now.getHour());
		System.out.println("분: " + now.getMinute());
		System.out.println("초: " + now.getSecond());
		
		// 캘린더
		// → 날짜, 시간을 가져온 후 포멧형식(서식) 지정 할 때 다른 함수 필요
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// Date 클래스
		// → util / sql 구분해서 지정해야한다
		// 주로 util 사용
		Date date = new Date();
		System.out.println(date);
		
		// Date 클래스의 기초값: 1900년 1월 1일 자정 기준
		// Date 클래스를 사용하기 위해선 기초값인 1900년의 값을 더해서 사용해야한다
		// getYear의 가운데 줄이 그어져있는 이유: 
		// 			자바 버전이 다르면 사용 못할 수도 있기 때문에 되도록이면 사용하지 말라는 표시
		System.out.println("년: " + date.getYear()); // 124년으로 출력
		System.out.println("년: " + (date.getYear()+1900)); // 2024년으로 출력
		
	}

}
