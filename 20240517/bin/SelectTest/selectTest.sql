-- 17번 문제 
-- EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
--		   (단,각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)

-- 17번 답

-- ABS : 전달 받은 숫자의 절댓값 반환
select
	emp_name,
	floor(abs(hire_date - sysdate)) "근무일수1",
	floor(abs(sysdate - hire_date)) "근무일수2"
from 
	employee;