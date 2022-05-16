package controllers;

import models.Facility;
import services.CustomerService;
import services.impl.BookingServiceImpl;
import services.impl.CustomerServiceImpl;
import services.impl.EmployeeServiceImpl;
import services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }
    private static Scanner scanner = new Scanner(System.in);
    private static int choice = 0;
    public static void displayMainMenu(){
        while (true){
            System.out.println("phease choose: " +
                    "\n 1. Employee Management"  +
                    "\n 2. Customer Management"  +
                    "\n 3. Facility Management"  +
                    "\n 4. Booking Managerment"  +
                    "\n 5. Promotion Management" +
                    "\n 6. Exit");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    public static void displayEmployeeMenu(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        while (true){
            System.out.println( "\n 1. Display list employees" +
                                "\n 2. Add new employee"       +
                                "\n 3. Edit employee"          +
                                "\n 4. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayCustomerMenu(){
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        while (true){
            System.out.println( "\n 1. Display list customers" +
                                "\n 2. Add new customer"       +
                                "\n 3. Edit customer"          +
                                "\n 4. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayFacilityMenu(){
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        while (true){
            System.out.println( "\n 1. Display list facility"     +
                                "\n 2. Add new facility"          +
                                "\n 3. Edit facility maintenance" +
                                "\n 4. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    addNewFacilityMenu();
                    break;
                case 3:

                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayBookingMenu(){
        BookingServiceImpl bookingService = new BookingServiceImpl();
        while (true){
            System.out.println( "\n 1. Add new booking"         +
                                "\n 2. Display list booking"    +
                                "\n 3. Create new constracts"   +
                                "\n 4. Display list contracts"  +
                                "\n 5. Edit contracts"          +
                                "\n 6. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    bookingService.addNew();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void displayPromotionMenu(){
        while (true){
            System.out.println( "\n 1. Display list customers use service" +
                                "\n 2. Display list customers get voucher" +
                                "\n 3. Return main menu");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                case 2:
                case 3:
                    displayMainMenu();
                    break;
            }
        }
    }

    public static void addNewFacilityMenu(){
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        while (true){
            System.out.println( "\n 1. Add new Villa" +
                                "\n 2. Add new House" +
                                "\n 3. Add new Room"  +
                                "\n 4. Return");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại");
            }
            switch (choice){
                case 1:
                    facilityService.addNewVilla();
                    displayFacilityMenu();
                    break;
                case 2:
                    facilityService.addNewHouse();
                    displayFacilityMenu();
                    break;
                case 3:
                    facilityService.addNewRoom();
                    displayFacilityMenu();
                    break;
                case 4:
                    displayFacilityMenu();
                    break;
            }
        }
    }

}
