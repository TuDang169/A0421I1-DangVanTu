package models;

public class Room extends Facility{
    String freeExtraService;

    public Room() {
    }

    public Room(String idFacility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String styleRental, String freeExtraService) {
        super(idFacility, nameService, areaUse, rentalPrice, rentalPeopleMax, styleRental);
        this.freeExtraService = freeExtraService;
    }

    public String getFreeExtraService() {
        return freeExtraService;
    }

    public void setFreeExtraService(String freeExtraService) {
        this.freeExtraService = freeExtraService;
    }

    @Override
    public String toString() {
        return   super.toString() +
                "freeExtraService='" + freeExtraService + '\'' +
                '}';
    }
}
