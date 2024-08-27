-- in 여러 개 중에 포함 되어있으면 true, false
-- > 한 행의 결과가 나온다. (select의 원하는 컬럼만)

-- ALL 모두를 만족하는 연산자 (and)
-- ANY 하나라도 만족하는 것 (or)

-- 판매량 상위 3개 음료를 다음과 같이 조회
--  1. 아메리카노  2.라떼  5.콜드브루
-- 1) 서브쿼리
SELECT
    beverage_id AS id,
    SUM(count)
FROM
    order_details
GROUP BY
    beverage_id
ORDER BY
    SUM(count) DESC;
-- 2) 메인쿼리
SELECT
    id   AS "ID",
    name AS "음료명"
FROM
    beverages
WHERE
    id IN (
        SELECT
            id
        FROM
            (
                SELECT
                    beverage_id AS id, SUM(count)
                FROM
                    order_details
                GROUP BY
                    beverage_id
                ORDER BY
                    SUM(count) DESC
            )
        WHERE
            ROWNUM <= 3
    );

-- 아메리카노와 라떼보다 가격이 싼 음료를 조회
-- 레몬에이드 3800
-- 1) 서브쿼리
SELECT
    price
FROM
    beverages
WHERE
    name IN ( '아메리카노', '라떼' );
-- 2) 메인쿼리
SELECT
    name as "음료명",
    price as "가격"
FROM
    beverages
WHERE
    price < ALL (
        SELECT
            price
        FROM
            beverages
        WHERE
            name IN ( '아메리카노', '라떼' )
    );

-- 커피가 아닌 음료들 중 적어도 한 커피보다 가격이 비싼 음료 조회
-- 자몽에이드 4800
-- 바닐라쉐이크 5800
SELECT
    name  AS "음료명",
    price AS "가격"
FROM
    beverages
WHERE
        btype != 'COFFEE'
    AND price > ANY (
        SELECT
            price
        FROM
            beverages
        WHERE
            btype = 'COFFEE'
    )
ORDER BY
    price ASC;


