-- 1) 다음 중 올바른 것을 모두 고르시오.
-- a) 홍팍이의 프로그래밍 성적은 80점을 받아 A0(4.0)이다.
-- b) 라이언의 프로그램밍 성적은 79점을 받아 B+(3.5)이다.
-- c) 젤리의 대학 수학 성적은 68점을 받아 C+(2.5)이다.
-- d) 알파고의 영작문 성적은 91점을 받아 A+(5.0)이다.

-- 1. a)
select
	exam_score as "성적",
	grade as "학점"
from
	students s
join
	grades g on g.student_id = s.id
join
	courses c on c.id = g.course_id
join
	grade_points p on using(grade) 
where
	s.nickname = '홍팍' and c.id = '프로그래밍';
-- 1. b)
select
	s.nickname as 이름,
    c.title as 과목,
    g.exam_score as 점수,
    g.grade as 등급,
    p.point as 학점
from
    students s	
join
	grades g on g.student_id = s.id
join
	courses c on c.id = g.course_id
join
	grade_points p on p.grade = g.grade
WHERE
        s.nickname = '라이언'
    AND c.title = '프로그래밍';
-- 1. c)
select
	s.nickname as 이름,
    c.title as 과목,
    g.exam_score as 점수,
    g.grade as 등급,
    p.point as 학점
from
    students s	
join
	grades g on g.student_id = s.id
join
	courses c on c.id = g.course_id
join
	grade_points p on p.grade = g.grade
WHERE
        s.nickname = '젤리'
    AND c.title = '대학 수학';
-- 1. d)
select
	s.nickname as 이름,
    c.title as 과목,
    g.exam_score as 점수,
    g.grade as 등급,
    p.point as 학점
from
    students s	
join
	grades g on g.student_id = s.id
join
	courses c on c.id = g.course_id
join
	grade_points p on p.grade = g.grade
WHERE
        s.nickname = '알파고'
    AND c.title = '영작문';
    
-- 2) 과목별 평균 시험점수를 다음과 같이 조회하시오
SELECT
    c.title  AS 과목명,
    round(AVG(exam_score),
          2) AS "평균 시험점수"
FROM
         grades g
    JOIN courses c ON c.id = g.course_id
GROUP BY
    c.title,
    course_id;
    
-- 3) 학생별 평균 학점(등급점수)을 수강성적으로부터 구하고, 해당 점수가 3.5 미만인 학생을 다음과 같이 조회하시오.
SELECT
    s.nickname AS "닉네임",
    round(AVG(p.point),
          2) AS "평균 학점"
FROM
         students s
    JOIN grades       g ON s.id = g.student_id
    JOIN grade_points p ON g.grade = p.grade
where
	s.nickname in ('알파고', '라이언')
GROUP BY
    s.nickname,
    student_id;
    
-- 4) 모든 강의별 평균 학점(등급점수)을 구하고, 이보다 후하게 준 “꿀 강의” TOP3를 조회하시오.
SELECT
    title AS "강의명",
    "평균 학점"
FROM (
    SELECT
        c.title,
        ROUND(AVG(gp.point), 2) AS "평균 학점"
    FROM
        courses c
    JOIN
        grades g ON c.id = g.course_id
    JOIN
        grade_points gp ON g.grade = gp.grade
    GROUP BY
        c.title
    ORDER BY
        AVG(gp.point) DESC
)
WHERE ROWNUM <= 3;
    
    
    