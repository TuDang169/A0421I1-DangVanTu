package controller;

import model.bean.Employee;
import model.service.EmployeeService;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                saveNewEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                showEmployeeList(request,response);
                break;
        }
    }

    private void saveNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard   = request.getParameter("idcard");
        double salary   = Double.parseDouble(request.getParameter("salary"));
        String phone    = request.getParameter("phone");
        String email    = request.getParameter("email");
        String address  = request.getParameter("address");
        int positionId  = Integer.parseInt(request.getParameter("positionid"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId  = Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("address");

        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);

        boolean check = employeeService.save(employee);
        if (check){
            request.setAttribute("mess","Them moi thanh cong");
        }else {
            request.setAttribute("mess","Them moi không thanh cong");
        }
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("customerList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id          = Integer.parseInt(request.getParameter("id"));
        String name     = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard   = request.getParameter("idcard");
        double salary   = Double.parseDouble(request.getParameter("salary"));
        String phone    = request.getParameter("phone");
        String email    = request.getParameter("email");
        String address  = request.getParameter("address");
        int positionId  = Integer.parseInt(request.getParameter("positionid"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId  = Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("address");

        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);


        boolean check = employeeService.update(employee);
        if (check){
            request.setAttribute("mess","Edit thanh cong");
        }else {
            request.setAttribute("mess","Edit  khong thanh cong");
        }
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check =employeeService.delete(id);
        if (check){
            request.setAttribute("mess","Xóa thanh cong");
        }else {
            request.setAttribute("mess","Xóa không thanh cong");
        }
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
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
                showCreateEmployeeForm(request,response);
                break;
            case "edit":
                showEditEmployeeForm(request,response);
                break;
            case "delete":
                showDeleteEmployeeForm(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
            default:
                showEmployeeList(request,response);
                break;
        }
    }

    private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        try {
            if (employee==null){
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

    private void showDeleteEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        request.setAttribute("employee",employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/delete.jsp");
        try {
            if (employee==null){
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

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        List<Employee> employeeList = employeeService.searchByName(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
