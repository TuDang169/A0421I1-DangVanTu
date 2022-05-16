package services.impl;

import models.Customer;
import models.Employee;
import services.CustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập CMND: ");
        String idCard = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập Loại Khách hàng: ");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập Địa chỉ: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, age, sex, idCard, email, typeCustomer, address);
        customerList.add(customer);
        System.out.println("Đã thêm mới thành công");
    }

    @Override
    public void edit() {
        System.out.println("Vui lòng nhập Id Employee bạn muốn chỉnh sửa: ");
        int index = Integer.parseInt(scanner.nextLine());
        int choice = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getId() != index){
                continue;
            }
            System.out.println("\n Vui lòng chọn thông tin bạn muốn sửa: " +
                    "\n 1. Id"              +
                    "\n 2. Tên"             +
                    "\n 3. Tuổi"            +
                    "\n 4. Giới tính"       +
                    "\n 5. IdCard"          +
                    "\n 6. Email"           +
                    "\n 7. Loại khách hàng" +
                    "\n 8. Địa chỉ"         +
                    "\n 9. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
//            System.out.println("Bạn có chắc muốn sửa thông tin này?");
            switch (choice){
                case 1:
                    System.out.println("Đổi ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    customerList.get(i).setId(id);
                    System.out.println("Thành công");
                    break;
                case 2:
                    System.out.println("Đổi tên: ");
                    String name = scanner.nextLine();
                    customerList.get(i).setName(name);
                    System.out.println("Thành công");
                    break;
                case 3:
                    System.out.println("Đổi Tuổi: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    customerList.get(i).setAge(age);
                    System.out.println("Thành công");
                    break;
                case 4:
                    System.out.println("Đổi Giới tính: ");
                    String sex = scanner.nextLine();
                    customerList.get(i).setSex(sex);
                    System.out.println("Thành công");
                    break;
                case 5:
                    System.out.println("Đổi tên CMND: ");
                    String idCard = scanner.nextLine();
                    customerList.get(i).setIdCard(idCard);
                    System.out.println("Thành công");
                    break;
                case 6:
                    System.out.println("Đổi Email: ");
                    String email = scanner.nextLine();
                    customerList.get(i).setEmail(email);
                    System.out.println("Thành công");
                    break;
                case 7:
                    System.out.println("Đổi Loại khách hàng: ");
                    String typeCustomer = scanner.nextLine();
                    customerList.get(i -1).setTypeCustomer(typeCustomer);
                    System.out.println("Thành công");
                    break;
                case 8:
                    System.out.println("Đổi Địa Chỉ: ");
                    String address = scanner.nextLine();
                    customerList.get(i).setAddress(address);
                    System.out.println("Thành công");
                    break;
                case 9:
                    break;
            }
            display();
            return;
        }
        System.out.println(" Id not found ");
    }

    @Override
    public void delete() {

    }
}
