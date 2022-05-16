export class Customer {
  id: number;
  name: string;
  birthday: string;
  gender: boolean;
  idCard: string;
  phone: string;
  email: string;

  constructor(id: number, name: string, birthday: string, gender: boolean, idCard: string, phone: string, email: string) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.idCard = idCard;
    this.phone = phone;
    this.email = email;
  }
}
