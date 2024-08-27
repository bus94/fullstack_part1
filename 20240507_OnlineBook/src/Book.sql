# 데이터베이스 생성
create database BookMarket;

# 데이터베이스 선택
use BookMarket;

# 테이블 생성
create table Book(
	
	bookId		varchar(30)	not null,
    bookName	varchar(100),
    bookPrice	int,
    bookAuthor	varchar(100),
    bookDescription	varchar(300),
    bookCategory	varchar(100),
    bookDate		datetime
    
);