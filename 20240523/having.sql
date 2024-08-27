-- group by : 하나 이상의 행을 그룹으로 묶어서 연산하여 하나의 결과만 나타내기 위함
-- > 그룹함수는 null을 제외하고 계산한다.
-- > 그룹된 결과 안에서 단일 행을 출력할 수 없다.

-- having : 그룹이 된 컬럼들 중에서 where 같은 조건을 사용해야될 때 사용

-- select   ... 6: 최종 결과 테이블에서 원하는 것만 조회
-- from 	...	1: 대상 테이블에
-- join 	...	2: 추가 테이블을 붙이고
-- where 	...	3: 원하는 조건으로 필터링
-- group by	...	4: 그룹 별로 분류한 다음 (중복된 것들을 그룹화 시킴)
-- having   ... 5: 특정 조건으로 원하는 그룹 선별
-- order by ... 7: 특정 컬럼을 기준으로 정렬 (기본적으로 오름차순(ASC), 내림차순(DESC))
-- limit    ... 8: 가져올 데이터 수 지정 (mysql에서는 가능, oracle 불가)

-- 상품명과 가격을 기준으로 누적 판매 정보(판매량, 매출)를 조회
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(d.count),
        0)  AS "누적 판매량",
    nvl(SUM(p.price * d.count),
        0)  AS "누적 매출"
FROM
    products      p
    LEFT JOIN order_details d ON p.id = d.product_id
GROUP BY
    p.name,
    p.price;

-- 누적 매출이 35000원 이상인 상품을 조회 (having 이용)
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(p.price * d.count),
        0)  AS "누적 매출"
FROM
    products      p
    LEFT JOIN order_details d ON p.id = d.product_id
GROUP BY
    p.name,
    p.price
HAVING
    SUM(p.price * d.count) >= 35000
order by
    p.name;

-- 누적 매출이 20000원 이상이면서 누적 판매량도 10개 이상인 상품을 조회
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(d.count),
        0)  AS "누적 판매량",
    nvl(SUM(p.price * d.count),
        0)  AS "누적 매출"
FROM
    products      p
    LEFT JOIN order_details d ON p.id = d.product_id
GROUP BY
    p.name,
    p.price
HAVING SUM(p.price * d.count) >= 20000
       AND SUM(d.count) >= 10;

-- 누적 매출이 없는 제품을 가격 기준으로 오름차순 정렬하여 조회
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(p.price * d.count),
        0)  AS "누적 매출"
FROM
    products      p
    LEFT JOIN order_details d ON p.id = d.product_id
GROUP BY
    p.name,
    p.price
HAVING
    SUM(p.price * d.count) is null
    -- nvl(SUM(p.price * d.count), 0) = 0
ORDER BY
    p.price;

-- 누적 매출 상위 5개 상품 조회
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(d.count),
        0)  AS "누적 판매량",
    nvl(SUM(p.price * d.count),
        0)  AS "누적 매출"
FROM
    products      p
    LEFT JOIN order_details d ON p.id = d.product_id
GROUP BY
    p.name,
    p.price
order by 
	sum(p.price * d.count);








