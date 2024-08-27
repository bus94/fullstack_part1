-- order by
-- select 한 컬럼에 대해 정렬하는 구문
-- select 구문의 가장 마지막에 작성하며 실행 순서 역시 가장 마지막에 수행된다.
/*
SELECT 컬럼 명 [, 컬럼명, …] 
FROM 테이블 명 
WHERE 조건식
ORDER BY 컬럼명 | 별칭 | 컬럼 순번 정렬방식 [NULLS FIRST | LAST];
*/

-- 기본적으로 모든 정렬은 오름차순을 기준으로 한다.
-- ASC: 오름차순
-- DESC: 내림차순

-- desc 테이블명; → 테이블구조 확인 (ORDER BY에서 사용하는 것과 다르다)

-- Employee 테이블 정렬
-- 오름 차순은 키워드를 생략해도 된다.
select
	emp_name
from
	employee
order by
	emp_name;
-- 내림 차순은 DESC 기입하면 된다.
select
	emp_name
from
	employee
order by
	emp_name DESC;
	
-- 직원의 월급이 높은 순으로 정렬하기
select
	emp_name,
	salary
from
	employee
order by
	salary DESC;
-- 월급이 같다면 이름을 이용해서 내림차순으로 정렬하기
select
	emp_name,
	salary
from
	employee
order by
	salary DESC, emp_name DESC; -- 월급 먼저 정렬 후 이름을 정렬한다.

-- group by
-- 그룹함수는 단 한 개의 결과 값만 산출하기 때문에 그룹이 여러 개일 경우 오류 발생
-- 여러 개의 결과 값을 산출하기 위해서 그룹함수가 적용 될 그룹의 기준을 group by 절에 작성한다.

-- 부서 별 급여 합을 구하시오
select
	dept_code,
	sum(salary)
from
	employee
group by dept_code;

-- Employee 테이블에서 부서 코드, 그룹별 급여 합계, 그룹 별 급여의 평균(정수처리), 인원 수를 조회하고 부서 코드 순으로 정렬
-- \자리수만큼, 찍어서 출력하는 to_char()로 변경
-- nvl()
SELECT
    dept_code          부서코드,
    SUM(salary)        부서합계,
    floor(AVG(salary)) "부서별 급여 평균",
    COUNT(*)   "인원 수"
FROM
    employee
GROUP BY
    dept_code
ORDER BY
    dept_code ASC;
--
SELECT
    nvl(dept_code, 'no dept') 부서코드,
    to_char(SUM(salary),
            'L999,999,999')   부서합계,
    to_char(floor(AVG(salary)),
            'L999,999,999')   "부서별 급여 평균",
    COUNT(*)                  "인원 수"
FROM
    employee
GROUP BY
    dept_code
ORDER BY
    dept_code ASC;
--
SELECT
    decode(substr(emp_no, 8, 1),
           '1',
           '남',
           '2',
           '여')        AS 성별,
    floor(AVG(salary)) 평균,
    SUM(salary)        합계,
    COUNT(*)           "인원 수"
FROM
    employee
GROUP BY
    decode(substr(emp_no, 8, 1),
           '1',
           '남',
           '2',
           '여')
ORDER BY
    "인원 수" DESC;

-- Employee 테이블에서 부서 코드 별로 같은 직급인 사원의 급여 합계를 조회하고 부서코드 순으로 정렬
-- group by 는 여러 컬럼을 그룹으로 묶을 수 있다
SELECT
	dept_code          부서코드,
	job_code		   직급코드,			
    SUM(salary)        합계
from
	Employee
group by
	dept_code, job_code
order by
	dept_code asc;





