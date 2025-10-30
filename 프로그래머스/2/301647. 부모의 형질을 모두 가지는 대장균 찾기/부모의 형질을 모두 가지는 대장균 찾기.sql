select
    e2.id,
    e2.genotype,
    e1.genotype as parent_genotype
from 
    ecoli_data e1
join
    ecoli_data e2 on e1.id = e2.parent_id
where
    (e1.genotype & e2.genotype) = e1.genotype
order by
    e2.id
