USE QuanLySinhVien;

select *
from student;

select *
from student
where Status = true;

SELECT *
FROM Subject
WHERE Credit < 10;

select s.studentid, s.studentName, c.className
from student s join class c on s.ClassID = c.ClassID
where c.ClassName = 'A1';

select s.studentid, s.studentname, sub.subname, m.mark
from student s join mark m on s.StudentID = m.StudentID join subject sub on m.subID = sub.subId
where sub.SubName = 'CF';