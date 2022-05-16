package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR        = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA   = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_AMOUNT     = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT        = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA       = "^[3-9]\\d[1-9]\\d(2,})$";

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element: facilityIntegerMap.entrySet()){
            System.out.println("Service "+ element.getKey() + "Số lần đã thuê " +element.getValue());
        }
    }

    public void displayMaintain() {

    }

    public void addNewVilla() {
        System.out.println("Nhập id: ");
        String idFacility = scanner.nextLine();
        System.out.println("Nhập Tên: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập Diện tích: ");
        double areaUse = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Giá tiền: ");
        int rentalPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Số lượng người: ");
        int rentalPeopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Kiểu thuê: ");
        String styleRental = scanner.nextLine();
        System.out.println("Nhập Tiêu chuẩn: ");
        String standardVilla = scanner.nextLine();
        System.out.println("Nhập Diện tích hồ bơi: ");
        double areaPool = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số tầng: ");
        int floor = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(idFacility, nameService,
                                areaUse, rentalPrice, rentalPeopleMax,
                                styleRental, standardVilla, areaPool, floor);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Đã thêm mới Villa thành công");
    }

    public void addNewHouse() {
        System.out.println("Nhập id: ");
        String idFacility = scanner.nextLine();
        System.out.println("Nhập Tên: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập Diện tích: ");
        double areaUse = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Giá tiền: ");
        int rentalPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Số lượng người: ");
        int rentalPeopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Kiểu thuê: ");
        String styleRental = scanner.nextLine();
        System.out.println("Nhập Tiêu chuẩn: ");
        String standardHouse = scanner.nextLine();
        System.out.println("Nhập Số tầng: ");
        int floor = Integer.parseInt(scanner.nextLine());
        House house = new House(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, styleRental, standardHouse, floor);
        facilityIntegerMap.put(house, 0);
        System.out.println("Đã thêm mới House thành công");
    }

    public void addNewRoom() {
        System.out.println("Nhập id: ");
        String idFacility = scanner.nextLine();
        System.out.println("Nhập Tên: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập Diện tích: ");
        double areaUse = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Giá tiền: ");
        int rentalPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Số lượng người: ");
        int rentalPeopleMax = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Kiểu thuê: ");
        String styleRental = scanner.nextLine();
        System.out.println("Nhập Tiêu chuẩn: ");
        String standardRoom = scanner.nextLine();
        System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
        String service = scanner.nextLine();
        Room room = new Room(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, styleRental, service);
        facilityIntegerMap.put(room, 0);
        System.out.println("Đã thêm mới Room thành công");
    }

    @Override
    public void addNew() {
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
