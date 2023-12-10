-- 코드를 입력하세요
select 
    YEAR(os.sales_date) as YEAR,
    MONTH(os.sales_date) as MONTH,
    ui.gender as GENDER, 
    count(distinct ui.user_id) as USERS
from online_sale os 
left join user_info ui on os.user_id = ui.user_id
where gender is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER
