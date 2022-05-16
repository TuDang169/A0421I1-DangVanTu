package services.impl;

import models.*;
import services.BookingService;
import utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static {
        customerList.add(new Customer(      1,"A", 21, "Male", "2121212",
                                            "a@gmail.com", "VIP", "DN"));
        customerList.add(new Customer(      2,"B", 23, "FeMale", "21244444",
                                            "B@gmail.com", "VIP", "HN"));
        facilityIntegerMap.put(new Villa(   "1","Villa1", 200, 150, 10,
                                            "Day", "VIP", 15, 2), 0);
        facilityIntegerMap.put(new House(   "1","Villa1", 200, 150,
                                            10, "Day", "VIP", 2), 0);
    }

    @Override
    public void display() {
        for (Booking booking: bookingSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void addNew() {
        int id = 1;
        if (!bookingSet.isEmpty()){
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Ngày bắt đầu thuê: ");
        String startDate = scanner.nextLine();
        System.out.println("Ngày kết thúc thuê: ");
        String endDate = scanner.nextLine();
        Booking booking = new Booking(id, startDate, endDate, customer, facility);
        bookingSet.add(booking);
        System.out.println("Đã Booking thành công");
    }

    @Override
    public void edit() {

    }

    public static Customer chooseCustomer(){
        System.out.println("Danh sách khách hàng: ");
        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }

        System.out.println("Nhập Id khách hàng: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        
        while (check){
            for (Customer customer: customerList) {
                if (id == customer.getId()){
                    check = false;
                    return customer;
                }
            }
            if(check){
                System.out.println("Bạn đã nhập sai, vui lòng nhập đúng id khách hàng");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility(){
        System.out.println("Danh sách dịch vụ: ");
        for(Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()){
            System.out.println(entry.getKey().toString());
        }

        System.out.println("Nhập Id dịch vụ: ");
        boolean check = true;
        String id =scanner.nextLine();

        while (check){
            for (Map.Entry<Facility, Integer> entry: facilityIntegerMap.entrySet()) {
                if(id.equals(entry.getKey().getIdFacility())){
                    check = false;
                    return entry.getKey();
                }
            }
            if(check){
                System.out.println("Bạn đã nhập sai, vui lòng nhập đúng id khách hàng");
                id =scanner.nextLine();
            }
        }
        return null;
    }

    @Override
    public void delete() {

    }
}
