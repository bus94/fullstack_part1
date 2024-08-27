-- 테이블 생성
CREATE TABLE board (
    idx       NUMBER(3),
    name      VARCHAR2(100),
    password  VARCHAR2(50),
    memo      VARCHAR2(300),
    writedate date
);

INSERT INTO board (idx, name, password, memo, writedate) VALUES (1, '홍길동', '1111', '1등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (2, '임꺽정', '2222', '2등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (3, '장길산', '3333', '3등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (4, '일지매', '4444', '4등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (5, '길홍동', '5555', '5등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (6, '홍동길', '6666', '6등 입니다.', SYSDATE);

/*
 *  <NVARCHAR2>
 * 
 *   N 이 있을 경우 
 *    유니코드 문자형 모든 문자 2byte 
 *    크기를 글자 수 단위로 받음
 * 
 *   N 이 없을 경우 
 *    한글/한자 : 3byte
 *    영어/숫자/기호 : 1byte
 *    크기를 바이트 수 단위로 받음 
 * 
 *  VAR가 있을 경우 : 가변 문자
 *  VAR가 없을 경우 : 고정 문자
 * 
 *  숫자2가 없을 경우 :  2000byte
 *  숫자2가 있을 경우 :  4000byte
 * 
 *  (n) 크기
 * 
 * number(p  ,  s)
 * p  : 표현할 수 있는 전체 숫자 자리수(1~38)
 * s  : 소수점 이하 자리수
 * 
 * 
 *  
 */







