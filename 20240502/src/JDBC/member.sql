# 데이터베이스를 꼭! 선택해야된다.
use db1_book_store;

# Error Code: 1146. 
# Table 'db1_book_store.member' doesn't exist
# 해결 방법: 테이블 없으니 테이블 생성하면 됨!

CREATE TABLE member(
	member_no INT, 				# 회원 고유 번호
	member_id VARCHAR(20), 		# 아이디
    member_pw VARCHAR(20), 		# 패스워드
    member_name VARCHAR(20), 	# 이름
    member_gender VARCHAR(1), 	# 성별
    member_point INT, 			# 포인트
    member_reg_date DATETIME 	# 회원 가입일
);

INSERT INTO member VALUES (1, 'qwer', '1234', '홍길동', 'm',  0, '2021-01-01 12:11:30');
INSERT INTO member VALUES (2, 'java', '1234', '김유신', 'm',  0, '2021-01-02 03:20:54');
INSERT INTO member VALUES (3, 'haha', '1234', '신혜정', 'w', 0, now());
INSERT INTO member VALUES (4, 'tiger', '1234', '선우호랭', 'w', 0, '2020-12-25 05:43:11');
INSERT INTO member VALUES (5, 'green', '1234', '정그린', 'm', 0, '2018-06-12 07:21:08');

select * from member;
