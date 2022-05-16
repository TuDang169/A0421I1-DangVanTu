export class Bus {
  id: number;
  type: string;
  name: string;
  locationGo: string;
  locationArrival: string;
  phone: string;
  email: string;
  timeGo: string;
  timeArrival: string;

  constructor(id: number, type: string, name: string, locationGo: string, locationArrival: string, phone: string, email: string, timeGo: string, timeArrival: string) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.locationGo = locationGo;
    this.locationArrival = locationArrival;
    this.phone = phone;
    this.email = email;
    this.timeGo = timeGo;
    this.timeArrival = timeArrival;
  }
}
