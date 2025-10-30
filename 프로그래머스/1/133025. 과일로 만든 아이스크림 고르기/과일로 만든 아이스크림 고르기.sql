-- 코드를 입력하세요
select
f.flavor
from first_half f inner join icecream_info i
on f.FLAVOR = i.FLAVOR
where f.total_order > 3000 and i.INGREDIENT_TYPE = 'fruit_based'
order by f.total_order desc;