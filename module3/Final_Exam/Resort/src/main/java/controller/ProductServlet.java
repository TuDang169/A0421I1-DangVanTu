package controller;

import model.bean.Category;
import model.bean.Product;
import model.service.CategoryService;
import model.service.ProductService;
import model.service.impl.CategoryServiceImpl;
import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns =  "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                saveNewProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                showProductList(request,response);
                break;
        }
    }

    private void saveNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        double pride    = Double.parseDouble(request.getParameter("pride"));
        int quantity    = Integer.parseInt(request.getParameter("quantity"));
        String color    = request.getParameter("color");
        int categoryId  = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name, pride, quantity, color, categoryId);
        boolean check = productService.save(product);
        if (check){
            request.setAttribute("mess","Them moi thanh cong");
        }else {
            request.setAttribute("mess","Them moi không thanh cong");
        }
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id          = Integer.parseInt(request.getParameter("id"));
        String name     = request.getParameter("name");
        double pride    = Double.parseDouble(request.getParameter("pride"));
        int quantity    = Integer.parseInt(request.getParameter("quantity"));
        String color    = request.getParameter("color");
        int categoryId  = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(id, name, pride, quantity, color, categoryId);
        boolean check = productService.update(product);
        if (check){
            request.setAttribute("mess","Edit thanh cong");
        }else {
            request.setAttribute("mess","Edit  khong thanh cong");
        }
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check =productService.delete(id);
        if (check){
            request.setAttribute("mess","Xóa thanh cong");
        }else {
            request.setAttribute("mess","Xóa không thanh cong");
        }
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name     = request.getParameter("name");
        List<Product> productList = productService.searchByName(name);
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("productList",productList);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
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
                showCreateProductForm(request,response);
                break;
            case "edit":
                showEditProductForm(request,response);
                break;
            case "delete":
                showDeleteProductForm(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
            default:
                showProductList(request,response);
                break;
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        List<Category> categoryList = categoryService.findByAll();
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        try {
            if (product==null){
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

    private void showDeleteProductForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/delete.jsp");
        try {
            if (product==null){
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
