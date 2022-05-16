package controller;


import model.bean.Student;
import model.service.IStudentService;
import model.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {

    private IStudentService iStudentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");

        if (actionClient == null) {
            actionClient = "";
        }

        switch (actionClient) {
            case "update":
                Integer id = Integer.valueOf(request.getParameter("studentId"));
                String name = request.getParameter("nameStudent");
                String dateOfBirth = request.getParameter("dateOfBirth");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setDateOfBirth(dateOfBirth);

                if ("success".equals(this.iStudentService.save(student))) {
                    request.setAttribute("msg", "Update successfully!");
                    request.setAttribute("studentListServlet", this.iStudentService.findAll());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Update fail!");
                    request.setAttribute("studentObj", student);
                    request.getRequestDispatcher("update_student.jsp").forward(request, response);
                }
                break;
            case "create":
                // do something
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");

        if (actionClient == null) {
            actionClient = "";
        }

        switch (actionClient) {
            case "update":
                Integer id = Integer.valueOf(request.getParameter("studentId"));
                request.setAttribute("studentObj", this.iStudentService.findById(id));
                request.getRequestDispatcher("update_student.jsp").forward(request, response);
                break;
            case "delete":
                break;
            case "search":
                String nameStudent = request.getParameter("name");
                List<Student> list = this.iStudentService.findByName(nameStudent);
                request.setAttribute("studentListServlet", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "searchMix":
                String name = request.getParameter("name");
                String gender = request.getParameter("gender");
                List<Student> listStudent = this.iStudentService.findByNameAndGender(name,gender);
                request.setAttribute("studentListServlet", listStudent);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("studentListServlet", this.iStudentService.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }
}
