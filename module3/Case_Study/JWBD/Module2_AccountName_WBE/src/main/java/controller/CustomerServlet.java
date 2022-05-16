package controller;

import model.bean.Customer;
import model.bean.CustomerType;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImp;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImp();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                saveNewCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                showCustomerList(request,response);
                break;
        }
    }

    private void saveNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int typeId      = Integer.parseInt(request.getParameter("typeId"));
        String name     = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender  = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard   = request.getParameter("idcard");
        String phone    = request.getParameter("phone");
        String email    = request.getParameter("email");
        String address  = request.getParameter("address");
        Customer customer = new Customer(typeId, name, birthday, gender, idCard, phone, email, address);
        boolean check = customerService.save(customer);
        if (check){
            request.setAttribute("mess","Them moi thanh cong");
        }else {
            request.setAttribute("mess","Them moi không thanh cong");
        }
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id          = Integer.parseInt(request.getParameter("id"));
        int typeId      = Integer.parseInt(request.getParameter("typeId"));
        String name     = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender  = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard   = request.getParameter("idcard");
        String phone    = request.getParameter("phone");
        String email    = request.getParameter("email");
        String address  = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        boolean check = customerService.update(customer);
        if (check){
            request.setAttribute("mess","Edit thanh cong");
        }else {
            request.setAttribute("mess","Edit  khong thanh cong");
        }
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check =customerService.delete(id);
        if (check){
            request.setAttribute("mess","Xóa thanh cong");
        }else {
            request.setAttribute("mess","Xóa không thanh cong");
        }
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        List<Customer> customerList = customerService.searchByName(name);
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchMixCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        boolean gender  = Boolean.parseBoolean(request.getParameter("gender"));

        List<Customer> customerList = customerService.search(name, gender);
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
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
                showCreateCustomerForm(request,response);
                break;
            case "edit":
                showEditCustomerForm(request,response);
                break;
            case "delete":
                showDeleteCustomerForm(request,response);
                break;
            case "search":
                searchCustomer(request,response);
                break;
            case "searchMix":
                searchMixCustomer(request,response);
                break;
            default:
                showCustomerList(request,response);
                break;
        }
    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer",customer);
        List<CustomerType> customerTypeList = customerTypeService.findByAll();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            if (customer==null){
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

    private void showDeleteCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer",customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/delete.jsp");
        try {
            if (customer==null){
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

}
