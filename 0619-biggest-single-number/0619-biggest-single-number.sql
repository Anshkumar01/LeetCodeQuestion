# Write your MySQL query statement below
Select max(num) as num
from mynumbers n
where num in (
    select num 
    from mynumbers
    group by num 
    having count(8) = 1
)