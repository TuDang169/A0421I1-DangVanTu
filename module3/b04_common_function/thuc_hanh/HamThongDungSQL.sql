USE QuanLySinhVien;

SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId, S.StudentName, AVG(mark)
from student S join Mark M on s.studentID = m.StudentID
Group by S.StudentID, S.StudentName
Having AVG(mark) > 15;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING avg(Mark) >= ALL (select avg(Mark) 
						 from Mark 
                         group by mark.StudentID);
				