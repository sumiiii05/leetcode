# Write your MySQL query statement below
select today.id from Weather today, Weather yes where datediff(today.recordDate,yes.recordDate)=1 and today.temperature>yes.temperature;