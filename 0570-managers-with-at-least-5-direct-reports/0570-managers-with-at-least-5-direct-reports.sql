# Write your MySQL query statement below
select e.name from Employee e
join Employee a on e.id = a.managerId
group by a.managerId
having count(*) >=5