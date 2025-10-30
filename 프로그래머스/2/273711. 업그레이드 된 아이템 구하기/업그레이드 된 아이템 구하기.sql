-- 코드를 작성해주세요
select 
    i2.item_id,
    i2.item_name,
    i2.rarity
from 
    item_info i1
join
    item_tree t on i1.item_id = t.parent_item_id
join
    item_info i2 on t.item_id = i2.item_id
where
    i1.rarity = 'RARE'
order by
    i2.item_id desc

