select A.FLAVOR from (
    select FLAVOR, sum(TOTAL_ORDER) as 'TOTAL_ORDER'
    from JULY
    group by FLAVOR
) as A left join (
    select FLAVOR, sum(TOTAL_ORDER) as 'TOTAL_ORDER'
    from FIRST_HALF
    group by FLAVOR
) as B on A.FLAVOR = B.FLAVOR
order by A.TOTAL_ORDER + B.TOTAL_ORDER desc
limit 3