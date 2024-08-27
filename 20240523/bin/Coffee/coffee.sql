-- 1) 음료(beverages)의 이름 및 가격과 함께, 가장 비싼 음료와의 가격 차이를 조사하려 한다. 주어진 두 쿼리를 조합하여 이를 구하시오.
SELECT
    b.name  AS 이름,
    b.price AS 가격,
    b.price - (
        SELECT
            MAX(price)
        FROM
            beverages
    )       AS 가격차이
FROM
    beverages b
order by
    b.price;
				
-- 2)주문내역(order_details)로부터 주문 별 음료 개수의 평균을 조회하려 한다. 주어진 쿼리를 조합하여 이를 구하시오.
SELECT
    AVG(beverage_count) AS "음료 개수의 평균"
FROM
    (
        SELECT
            d.order_id,
            SUM(count) AS beverage_count
        FROM
            order_details d
        GROUP BY
            d.order_id
    );

-- 3) 주문내역(order_details)로부터 음료 별 주문 개수를 조회하려 한다. 주어진 두 쿼리를 조합하여 이를 구하시오.
SELECT b.id, b.name, NVL(od.order_count, 0) AS order_count
FROM beverages b
LEFT JOIN (
    SELECT beverage_id, COUNT(order_id) AS order_count
    FROM order_details
    GROUP BY beverage_id
) od ON b.id = od.beverage_id;
				
-- 4) 평균 가격보다 비싼 음료(beverages)를 다음과 같이 조회하려 한다. 주어진 두 쿼리를 조합하여 이를 구하시오.
SELECT
	name,
	price
FROM
	beverages
where 
	price > ( -- 음료의 평균가격 (4950원)
			SELECT 
				AVG(price)
			FROM
			beverages
			);
