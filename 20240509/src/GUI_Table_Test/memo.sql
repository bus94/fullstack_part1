# 데이터베이스를 먼저 생성
create database tableMemo;

# 데이터베이스 선택
use tableMemo;

# 실제 데이터를 저장하는 테이블 생성
create table memo(

	num		int		primary key  auto_increment,	#글번호
	title 	varchar(100),							#글제목
    writer 	varchar(100),							#작성자
    content varchar(300),							#글내용
    readCount int								    #조회수

);