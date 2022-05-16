USE QuanLySinhVien;

select *,  max(Credit)
from subject;

select sub.SubID, Sub.SubName,  max(Mark)
from subject sub join mark m on Sub.SubID = m.SubID
group by sub.SubID, Sub.SubName;

select s.studentId, s.studentName, avg(mark) 
from student s join mark m on S.StudentID = m.studentID
group by s.studentId, s.studentName
order by mark desc;