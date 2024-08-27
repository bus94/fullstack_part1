-- 오라클은 계정 단위로 테이블(표) 형식을 관리한다.
-- system 계정이 각각의 user의 권한을 준다.
-- 11g → 21c
-- system (기본계정명) → 대소문자 구별 X
-- 1234   (비밀번호) → 대소문자 구별 O
-- 12c 버전 이상부터는 무조건 계정을 생성할 때 c##을 붙여야한다. → c##계정명 
-- c##을 붙이지 않으면 에러코드 "ORA-65096" 에러 발생
-- C## 대소문자 구별 O

-- c##을 붙이기 번거롭다면 아래의 코드를 실행하고 계정 생성하기
-- alter session set "_ORACLE_SCRIPT"=true; 

-- 오라클 사용자 계정 만들기
-- create user Username identified by Password;
-- create user ? identified by ??;

-- 오라클 사용자 계정을 만들면 오라클을 사용할 수 있는 권한을 줘야 한다.
-- 권한 부여(grant)
-- connect (기본적인 DB접속 권한)
-- resource (자바의 프로그래밍처럼 제어문 또는 함수 사용)
-- dba (모든 시스템 권한 - dba 권한만 줘도 모든 권한 부여한 것과 같음)
-- grant connect, resource, dba to Username;

-- 권한 해제(revoke)
-- revoke connect, resource, dba from Username;

-- 계정 생성, 권한 부여 등 이후 commit; 으로 완료된 작업을 저장한다.

-- 12c 버전 이상의 계정을 생성할 때 세션을 변경하는 alter 코드를 실행하지 않으면 아래처럼 계정을 실행해야 된다.
-- create user c##scott identified by 1234; -- 계정 생성
-- grant connect, resource, dba to c##scott; -- 권한 부여
-- commit; -- 영구적으로 저장한다.

-- 전체 유저 이름을 확인할 수 있는 명령문
-- select username from all_users;
-- select username from dba_users;

-- 잠긴 계정 풀기
-- alter user username account unlock;

-- 에러코드 "ORA-01045" 에러 발생 : 사용자가 create session 권한을 가지고 있지 않다. 로그인 거절되었다.
-- 해결 방법: grant create session to Username;







