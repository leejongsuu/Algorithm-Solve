-- 코드를 입력하세요
SELECT
    i.INGREDIENT_TYPE,
    sum(f.total_order) as TOTAL_ORDER
from
    icecream_info i
join
    first_half f on i.flavor = f.flavor
group by i.INGREDIENT_TYPE
