select
    y.yr as year,
    (max_size - e.size_of_colony) as year_dev,
    e.id
from
    ecoli_data e
join
    (
        select
            year(DIFFERENTIATION_DATE) as yr,
            max(SIZE_OF_COLONY) as max_size
        from
            ecoli_data
        group by
            year(DIFFERENTIATION_DATE)
    ) y on year(e.DIFFERENTIATION_DATE) = y.yr
order by year, year_dev