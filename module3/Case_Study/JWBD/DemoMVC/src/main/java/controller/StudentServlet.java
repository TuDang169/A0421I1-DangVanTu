package controller;

import model.bean.Student;
import model.bean.StudentClass;
import model.service.ClassService;
import model.service.StudentService;
import model.service.impl.ClassServiceImpl;
import model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService =new StudentServiceImpl();
    private ClassService classService = new ClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if (action==null){
           action ="";
       }
       switch (action){
           case "add":
               saveNewStudent(request,response);
               //thêm
               break;
           case "edit":
               editStudent(request,response);
               // sửa
               break;
           case "delete":
               // xóa
               deleteStudent(request,response);
               break;
           case "s":
               search(request,response);
               // xóa
               break;
           default:
               showStudentList(request,response);
               break;
       }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String classId = request.getParameter("classId");
        List<Student> studentList =new ArrayList<>();
        studentList =studentService.search(name,email,classId);
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        if (studentList.size()!=0){
            request.setAttribute("studentList",studentList);
        }else {
            request.setAttribute("mess","không có dữ liệu nào tìm hấy");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int classId = Integer.parseInt(request.getParameter("classId"));
        int point = Integer.parseInt(request.getParameter("point"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String email = request.getParameter("email");
        Student student =new Student(name,birthday,classId,point,gender,email);
        student.setId(id);
        boolean check =studentService.save(student);
        if (check){
            request.setAttribute("mess","Edit thanh cong");
        }else {
            request.setAttribute("mess","Edit  không thanh cong");
        }
        List<Student> studentList = studentService.findAll();
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        request.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
//        String id = Integer.parseInt(request.getParameter("id"));
        String id = (request.getParameter("id"));
        boolean check =studentService.delete(id);
        if (check){
            request.setAttribute("mess","Xóa thanh cong");
        }else {
            request.setAttribute("mess","Xóa không thanh cong");
        }
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList",studentList);
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int classId     = Integer.parseInt(request.getParameter("classId"));
        int point       = Integer.parseInt(request.getParameter("point"));
        boolean gender  = Boolean.parseBoolean(request.getParameter("gender"));
        String email    = request.getParameter("email");
        Student student = new Student(name,birthday,classId,point,gender,email);
        boolean check =studentService.save(student);
        if (check){
            request.setAttribute("mess","Them moi thanh cong");
        }else {
            request.setAttribute("mess","Them moi không thanh cong");
        }
        List<Student> studentList = studentService.findAll();
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        request.setAttribute("studentList",studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                showCreateStudentForm(request,response);
                //thêm
                break;
            case "edit":
                showEditStudentForm(request,response);
                // sửa
                break;
            case "delete":
                showDeleteStudentForm(request,response);
                // xóa
                break;
            default:
                showStudentList(request,response);
                break;
        }
    }

    private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/edit.jsp");
        try {
            if (student==null){
                response.sendRedirect("view/error-404.jsp");
            }else {
                requestDispatcher.forward(request,response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showDeleteStudentForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("student",student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/delete.jsp");
        try {
            if (student==null){
                response.sendRedirect("view/error-404.jsp");
            }else {
                requestDispatcher.forward(request,response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList",studentList);
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateStudentForm(HttpServletRequest request, HttpServletResponse response) {
        List<StudentClass> classList =classService.findByAll();
        request.setAttribute("classList",classList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
