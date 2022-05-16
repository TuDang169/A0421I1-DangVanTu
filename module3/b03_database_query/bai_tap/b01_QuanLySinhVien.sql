USE QuanLySinhVien;

select StudentName
from student
where StudentName like 'h%';

select *
from class
where month(startdate) = '12';

select *
from subject
where credit between 3 and 5;

update student
set studentId = '2'
where studentname = 'hung';

select s.StudentName, sub.SubName, m.Mark
from Student s join mark m on s.studentId = m.studentid join subject sub on m.SubID = sub.SubID
order by m.mark desc, s.StudentName;