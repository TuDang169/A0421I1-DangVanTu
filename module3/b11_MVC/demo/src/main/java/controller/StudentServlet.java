package controller;

import model.bean.Student;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student"})
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                saveStudent(request,response);
                //thêm
                break;
            case "edit":
                // sửa
                break;
            case "delete":
//                showDeleteStudentForm(request,response);
                // xóa
                break;
            default:
                break;
        }
    }
    private void saveStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int classId = Integer.parseInt(request.getParameter("classId"));
        int point = Integer.parseInt(request.getParameter("point"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String email = request.getParameter("email");
        String account = request.getParameter("account");
        Student student =new Student(id,name,birthday,classId,point,gender,account,email);
        studentService.save(student);
        // về alij trang list có kèm theo dữ liệu
        request.setAttribute("mess", "Thêm mới thành công");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        request.setAttribute("studentList",studentService.findAll());
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
                // sửa
                break;
            case "delete":
//                showDeleteStudentForm(request,response);
                // xóa
                break;
            default:
                showStudentList(request,response);
                break;
        }
    }

    private void showCreateStudentForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/student/create.jsp");// chuyển trang không chuyển dữ liệu
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/student/list.jsp");
        request.setAttribute("studentList",studentService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
