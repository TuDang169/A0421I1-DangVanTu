package services.impl;

import models.Employee;
import services.EmployeeService;
import utils.ReadAndWriteFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
//        employeeList = (List<Employee>) ReadAndWriteFile.readFile("D:\\A0421I1-DangVanTu\\module2\\FuramaResort\\src\\data\\employee.csv");
        for(Employee employee: employeeList){
            System.out.println(employee.toString());
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
        System.out.println("Nhập Trình độ: ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí: ");
        String position = scanner.nextLine();
        System.out.println("Nhập Lương: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
        System.out.println("Đã thêm mới thành công");
        ReadAndWriteFile.writeFile(employeeList, "D:\\A0421I1-DangVanTu\\module2\\FuramaResort\\src\\data\\employee.csv");
    }

    @Override
    public void edit() {
        System.out.println("Vui lòng nhập Id Employee bạn muốn chỉnh sửa: ");
        int index = Integer.parseInt(scanner.nextLine());
        int choice = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getId() != index){
                continue;
            }
            System.out.println("\n Vui lòng chọn thông tin bạn muốn sửa: " +
                    "\n 1. Id"          +
                    "\n 2. Tên"         +
                    "\n 3. Tuổi"        +
                    "\n 4. Giới tính"   +
                    "\n 5. IdCard"      +
                    "\n 6. Email"       +
                    "\n 7. Level"       +
                    "\n 8. Position"    +
                    "\n 9. Salary"      +
                    "\n 10. Return main menu");
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
                    employeeList.get(i).setId(id);
                    System.out.println("Thành công");
                    break;
                case 2:
                    System.out.println("Đổi tên: ");
                    String name = scanner.nextLine();
                    employeeList.get(i).setName(name);
                    System.out.println("Thành công");
                    break;
                case 3:
                    System.out.println("Đổi Tuổi: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    employeeList.get(i).setAge(age);
                    System.out.println("Thành công");
                    break;
                case 4:
                    System.out.println("Đổi Giới tính: ");
                    String sex = scanner.nextLine();
                    employeeList.get(i).setSex(sex);
                    System.out.println("Thành công");
                    break;
                case 5:
                    System.out.println("Đổi tên CMND: ");
                    String idCard = scanner.nextLine();
                    employeeList.get(i).setIdCard(idCard);
                    System.out.println("Thành công");
                    break;
                case 6:
                    System.out.println("Đổi Email: ");
                    String email = scanner.nextLine();
                    employeeList.get(i).setEmail(email);
                    System.out.println("Thành công");
                    break;
                case 7:
                    System.out.println("Đổi Trình độ: ");
                    String level = scanner.nextLine();
                    employeeList.get(i -1).setLevel(level);
                    System.out.println("Thành công");
                    break;
                case 8:
                    System.out.println("Đổi Vị trí: ");
                    String position = scanner.nextLine();
                    employeeList.get(i).setPosition(position);
                    System.out.println("Thành công");
                    break;
                case 9:
                    System.out.println("Đổi Lương: ");
                    int salary = Integer.parseInt(scanner.nextLine());
                    employeeList.get(i).setSalary(salary);
                    System.out.println("Thành công");
                    break;
                case 10:
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
