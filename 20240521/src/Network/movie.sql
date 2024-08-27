-- 파일명: movie.sql
-- 테이블을 생성할 때 자동으로 순번 주는 내용은 x
-- 테이블 생성해서 저장하기까지만!

create table Movie(
	rnum			varchar2(30),		
	rank			varchar2(30),
	rankOldAndNew	varchar2(50),
	movieNm			varchar2(100),
	openDt			varchar2(50),
	audiAcc			varchar2(50)
);

-- 이미 만들어진 컬럼을 삭제하기 위해서는
-- alter table 테이블명 drop column 컬럼명;
alter table movie drop column boxofficeType;

-- ORA-12899: KH.테이블명.컬럴명 
-- 열에 대한 값이 너무 큼! 내가 컬럼을 설정할 때 바이트 수 가 작아서 생긴 에러!
-- 해결: 테이블을 삭제하고 해당 컬럼의 크기를 증가한 후 다시 테이블 생성
