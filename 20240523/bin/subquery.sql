-- 서브쿼리
-- > 쿼리문 안에 또 다른 쿼리가 들어간다.
-- > 안에 있는 쿼리문(서브쿼리문)이 먼저 실행된 후 그 결과값을 밖에 있는 쿼리에서 이용하여 최종 결과를 나타낸다. 

-- 스칼라 서브 쿼리 (scalar subquery)
-- > select절 (사용 위치)
-- > 단일 컬럼, 단일 행을 반환한다 (1개의 값)

-- 인라인 뷰
-- > from절
-- > 결과를 반환할 때 별명을 정해야 에러가 발생하지 않는다.

-- 중첩 서브 쿼리
-- > where절, having절
-- > 다중 컬럼, 다중 행 반환

-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급 코드, 급여 조회
-- oracle에선 where절에 AVG()함수를 바로 사용할 수 없다.
-- 집계함수: count, min, max, sum, avg

-- ORA-00934: 그룹 함수는 허가되지 않습니다
SELECT
    emp_id,
    emp_name,
    job_code,
    salary
FROM
    employee
WHERE
    salary >= AVG(salary);

-- 해결: 서브쿼리 이용
-- 1) 서브쿼리를 먼저 작성 2) where절 안에 ()안에 1)의 쿼리문을 기입
SELECT
    emp_id,
    emp_name,
    job_code,
    salary
FROM
    employee
WHERE
    salary >= (
        SELECT
            AVG(salary)
        FROM
            employee
    );

-- 1. 단일행 서브쿼리
-- > 서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
-- > 단일행 서브쿼리 앞에는 기본 연산자 사용 - >, <, >=, <=, =, ...

-- 2. 다중행 서브쿼리
-- > 서브쿼리의 조회 결과 값의 행이 여러 개인 서브쿼리
-- > 기본 연산자 사용 불가 / in, not in, all, any, ... 연산자만 사용 가능

-- ex) 부서 별 최고 급여를 받는 직원의 이름, 직급, 부서, 급여 조회
SELECT
    emp_name,
    job_code,
    dept_code,
    salary
FROM
    employee
WHERE
    salary IN (
        SELECT
            MAX(salary)
        FROM
            employee
        GROUP BY
            dept_code
    )
ORDER BY
    dept_code;
-- ORDER BY 컬럼명; or ORDER BY 숫자(컬럼 순서); 정렬 가능
    
-- 3. 다중열 서브쿼리
-- > 서브쿼리의 조회 결과 컬럼의 개수가 여러 개인 서브쿼리

-- ex) 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 사원의 이름, 직급, 부서, 입사일 조회
-- 1) 서브 쿼리문 작성 (퇴사한 여직원의 부서와 직급 조회)
SELECT
    dept_code,
    job_code
FROM
    employee
WHERE
        substr(emp_no, 8, 1) = 2
    AND ent_yn = 'Y';
-- 2) 외부 쿼리문 작성
SELECT
    emp_name,
    job_code,
    dept_code,
    hire_date
FROM
    employee
WHERE
    ( dept_code, job_code ) IN (
        SELECT
            dept_code, job_code
        FROM
            employee
        WHERE
                substr(emp_no, 8, 1) = 2
            AND ent_yn = 'Y'
    )
ORDER BY
    1;
    
-- 4. 다중행 다중열 서브쿼리
--	서브쿼리의 조회 결과 컬럼의 개수와 행의 개수가 여러 개인 서브쿼리

-- ex) 직급별 최소 급여를 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 서브쿼리문
SELECT
    job_code,
    MIN(salary)
FROM
    employee
GROUP BY
    job_code;
-- 2) 메인쿼리문(외부쿼리)
SELECT
    emp_id,
    emp_name,
    job_code,
    salary
FROM
    employee
WHERE
    ( job_code, salary ) IN (
        SELECT
            job_code, MIN(salary)
        FROM
            employee
        GROUP BY
            job_code
    );
    
-- 5. 상(호연)관 서브쿼리
--	서브쿼리가 만든 결과 값을 메인 쿼리가 비교 연산할 때
--	메인 쿼리 테이블의 값이 변경되면 서브쿼리의 결과 값도 바뀌는 서브쿼리

-- 6. 스칼라 서브쿼리
-- > select절
-- > 상관쿼리이면서 결과 값이 한 개인 서브쿼리
-- > 다른 테이블에서 어떠한 값을 가져올 때 쓰인다.
-- > 하나의 값만 리턴 가능하고 두 개 이상의 값은 결과로 줄 수 없다.
-- > 일치하는 데이터가 없더라도 NULL값을 리턴할 수 있다.
-- > but! ORDER BY를 사용할 수 없다.

-- ex) 모든 사원의 사번, 이름, 관리자 사번, 관리자 명 조회
SELECT
    e.emp_id,
    e.emp_name,
    e.manager_id,
    nvl((
        SELECT
            m.emp_name
        FROM
            employee m
        WHERE
            m.emp_id = e.manager_id
    ), '없음') AS 관리자명
FROM
    employee e
ORDER BY
    1;
    
-- ORDER BY 절에서도 사용할 수 있다.
-- ex) 모든 직원의 사번, 이름, 소속 부서를 조회 후 부서명 내림차순 정렬
SELECT
    emp_id,
    emp_name,
    dept_code
FROM
    employee
ORDER BY
    (
        SELECT
            dept_title
        FROM
            department
        WHERE
            dept_code = dept_id
    ) DESC NULLS LAST;

--=======================================================
-- ROWNUM
--  select 해온 데이터에 일련 번호를 붙이는 것
--  특정 집합에서 원하는 행만 가져오고 싶을 때 행의 갯수를 제한하는 용도로 사용한다.
--  임시적으로 행의 번호를 부여하는 것이기 때문에 반드시 1부터 나와야 한다.

SELECT
    *
FROM
    employee
WHERE
    ROWNUM <= 10;
    
SELECT
    emp_id,
    emp_name,
    salary,
    ROWNUM as row_number
FROM
    employee
WHERE
    ROWNUM <= 10
ORDER BY
    salary DESC;

select * from (SELECT
    emp_id,
    emp_name,
    salary,
    ROWNUM as row_number
FROM
    employee
ORDER BY
    salary DESC)
    where row_number <= 10;
    
-- 최근 입사한 상위 10명의 직원 조회
-- 사번, 이름, 입사일
select *
from (SELECT
    emp_id,
    emp_name,
    hire_date,
    ROWNUM AS row_number
FROM
    employee
ORDER BY
    hire_date DESC)
where 
	row_number <= 10;

-- 부서코드가 D5인 상위 5명의 직원 조회
SELECT
    *
FROM
    (
        SELECT
            emp_name,
            dept_code,
            ROWNUM AS row_number
        FROM
            employee
        where dept_code = 'D5'
        order by
        	emp_name
    )
WHERE
    row_number <= 5;

-- 부서코드 D2 이고 직급 코드 J5인 1명의 직원을 조회
SELECT
    emp_id,
    emp_name,
    dept_code,
    job_code,
    ROWNUM AS row_number
FROM
    employee
WHERE
        dept_code = 'D2'
    AND job_code = 'J4';
        
select *
from (SELECT
    emp_id,
    emp_name,
    dept_code,
    job_code,
    ROWNUM AS row_number
FROM
    employee
WHERE
        dept_code = 'D2'
    AND job_code = 'J4')
where
	row_number = 1;
	