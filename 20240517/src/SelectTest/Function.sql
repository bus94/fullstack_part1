-- 함수(Function)
-- > 하나의 큰 프로그램에서 반복적으로 사용되는 부분을 분리하여 작성해놓은 작은 서브 프로그램
-- > 함수를 호출해서 값을 전달하면 결과를 리턴하는 방식

-- 단일 행 함수
-- > 여러 개의 전달값을 이용해서 결과값이 여러 개
-- > 각 행마다 반복적으로 적용되어 입력 받은 행의 개수가 다를 수 있다.

-- 그룹 함수
-- > 여러 개의 전달값을 이용해서 결과가 한 개
-- > 특정 행들의 집합으로 그룹이 형성되어 적용된다.
-- > 그룹 당 1개의 결과만 반환된다.

-- 문자열에 관련된 함수
-- length
-- > 주어진 컬럼 값 / 문자열의 길이(문자열 개수) 반환
-- char / string

select
	emp_Name,
	length(emp_Name)
from
	Employee;
	
-- lengthb
-- > 주어진 컬럼의 값 / 문자열의 길이(byte) 반환
select
	emp_Name,
	lengthb(emp_Name)
from
	Employee;

-- LTRIM / RTRIM
-- > 주어진 컬럼, 문자열의 왼쪽 / 오른쪽에서 지정한 문자에 포함된 모든 문자를 제거하는 함수

SELECT
	emp_Name,
	LTRIM(phone,'010'),
	RTRIM(email,'@kh.or.kr')
FROM
	employee;

-- substr(string, 위치, 개수)
-- > 컬럼이나 문자열에서 지정한 위치부터 지정한 개수의 문자열을 잘라내어 반환

-- 위치(position)
-- 문자열을 잘라낼 위치로 양수면 시작방향에서 지정한 수 만큼, 음수면 문자 끝 방향에서 지정한 수 만큼 자른다.
-- 반환할 문자 개수(음수이거나 null) 반환
	
select
	substr('showmethemoney', 5, 2)
from
	dual;
	
-- 연결연산자와 동일하게 사용되는 컬럼을 연결하는 함수 concat(string, string)

-- replace(string, str1, str2)
-- 컬럼의 문자 혹은 문자열에서 특정 문자열로 바꾸는 것
select
	replace('서울시 강남구 역삼동', '역삼동', '삼성동')
from
	dual;
	
-- 숫자 함수
-- > 인자로 전달받음, 숫자를 나누어 반환(MOD)

SELECT
 	mod(10,3),
 	mod(10.9, 3),
 	mod(-10.9, 3)
 from
 	dual;
 	
-- round(number, position)
-- > 인자로 전달받은 숫자 혹은 컬럼에서 지정한 위치부터 반올림하여 값을 반환
-- > position을 생략하면 0을 반환
SELECT
 	round(11.10),
 	round(10.18),
 	round(-10.61),
 	round(10.123456, 5)
 from
 	dual; 	
 	
-- 전달받은 인자를 무조건 올림해서 반환( ceil)
-- 전달받은 인자를 무조건 버림해서 반환( floor)

-- 날짜 처리 함수
-- > 시스템에 저장되어 있는 현재 날짜 반환
-- > +, - 연산자로 날짜의 일수를 더하거나 빼는 연산이 가능하다.
-- > date 타입으로 시간 데이터를 가져온다.

select
	sysdate as 오늘,
	sysdate + 1 as 내일,
	sysdate - 1 as 어제
from 
	dual;
	
-- months_between(date1, date2)
-- > 인자로 날짜 2개를 전달 받아 개월 수 차이를 숫자 데이터형으로 반환
-- > date1: 기준이 되는 날짜, date2: 개월 수 를 구하는 날짜
-- > employee 테이블에서 사원 이름, 입사일, 근무 개월 수 조회
select
	emp_name,
	hire_date,
	months_between(sysdate, hire_date)
from
	employee;
	
-- ADD_Months(date1, date2)
-- > 인자로 전달받은 날짜에 인자로 받은 숫자만큼 개월 수를 더하여 특정 날짜 반환
-- > date1 기준이 되는 날짜 (date)
-- > date2 더하려는 개월 수 (number)

-- employee 테이블에서 사원의 이름, 입사일, 입사 후 6개월이 된 날짜 조회
SELECT
    emp_name,
    hire_date,
    add_months(hire_date, 6) AS "6개월 후 날짜"
FROM
    employee;

-- Next_day(date, String)
-- > 인자로 전달받은 날짜에 인자로 받은 요일이 가장 가까운 날짜 반환
-- > 구하려는 요일을 날짜로 쓰는데 1 = 일요일, 2 = 월요일, 3 = 화요일, ... , 7 = 토요일

SELECT
    sysdate,
    next_day(sysdate, '월요일'),
    next_day(sysdate, 2),
    next_day(sysdate, '월')
FROM
    employee;
    
-- extract    
-- 년, 월, 일 정보 추출하여 반환한다.
select
	emp_name,
	extract(year from hire_date) year,
	extract(month from hire_date) month,
	extract(day from hire_date) day
from
	employee;
	
-- 형변환 함수
-- to_char 날짜형 혹은 숫자형을 문자형으로 변환
-- to_char(date, [format])
-- to_char(number, [format])
-- 앞에는 자료형, 뒤에는 문자형으로 변환 시 지정할 출력 형식
SELECT
    emp_name,
    to_char(hire_date, 'YYYY-MM-DD'),
    to_char(hire_date, 'YY/MON,DAY,DY')
FROM
    employee;

-- L local에 따라 달라지는 통화 기호
-- 999,999,999
-- 9의 개수는 표시할 수 있는 자리 수를 나타낸다.
-- 000,000,000
-- 자리수에 숫자가 없으면 0으로 표시됨
-- 급여 5000 → 000,005,000
SELECT
    emp_name,
    to_char(salary, 'L999,999,999'), -- 원화(￦) 표시 가능
    to_char(salary, '000,000,000')
FROM
    employee;

-- to_date 문자형 혹은 숫자형을 날짜형으로 변환
-- to_date(char, format)
-- to_date(number, format)
-- ex) Employee에서 2000년도 이후 입사한 사원의 사번, 이름, 입사일 조회
SELECT
	emp_id,
	emp_name,
	hire_date
FROM
    employee
WHERE
	hire_date > to_date(20000101, 'YYYYMMDD'); -- 숫자를 날짜 형식으로 잠시 변환하겠다라는 의미
    
-- to_number 문자형을 숫자형으로 반환

	
-- decode
-- > 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환

--DECODE(표현식, 조건1, 결과1, 조건2, 결과2, … , DEFAULT)
/*
* 표현식 : 값에 따라 선택을 다르게 할 컬럼 혹은 값
* 조건 : 해당 값이 참인지 거짓인지 여부 판단
* 결과 : 해당 조건과 일치하는 경우 반환할 값
* DEFAULT : 모든 조건이 불일치 시 반환할 값
*/

-- emp_no 주민번호에서 남, 여로 성별을 구별해서 이름, 주민번호, 성별을 출력하시오
select
	emp_name,
	emp_no,
	decode(substr(emp_no, 8, 1), '1', '남', '2', '여') as 성별
from
	Employee;

-- case
-- > 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 범위값 가능
/*
 * CASE WHEN 조건1 THEN 결과1
        WHEN 조건2 THEN 결과2
        WHEN 조건3 THEN 결과3
        …
        ELSE 결과N
 * END
 * 
 */
SELECT
    emp_name,
    emp_no,
    CASE
        WHEN substr(emp_no, 8, 1) = 1 THEN
            '남'
        ELSE
            '여'
    END AS 성별
FROM
    employee;
   
-- 직원의 월급을 조회 후 500만원 이상 1등급, 350만원 이상 2등급, 200만원 이상 3등급, 미만 모두 4등급
SELECT
	emp_name,
    salary,
    CASE
        WHEN salary >= 5000000 THEN
            '1등급'
        WHEN salary >= 3500000 THEN
            '2등급'
        WHEN salary >= 2000000 THEN
            '3등급'
        ELSE
            '4등급'
    END 등급
FROM
    employee;
    
-- 그룹 함수
-- > 하나의 이상의 행을 그룹으로 묶어서 연산하며, 총점, 평균, 최대값, 최소값

-- count
-- > 테이블 조건을 만족하는 행의 개수 반환

-- 직원 전체 사원 수 조회
select
	count(dept_code)
from
	employee
where
	dept_code = 'D5';
	
-- ex) Employee에서 사원들이 속해 있는 부서의 수
-- 일반 열을 그룹화 하는 GROUP BY 절을 이용한다.
-- 실행은 되지만 원하는 결과가 나오지 않는다.
select
	emp_name,
	count(dept_code)
from 
	employee
GROUP BY	
	emp_name;

