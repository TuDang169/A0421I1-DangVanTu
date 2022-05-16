export class Student {
  id: number;
  name:string;
  dateOfBirth: string;
  point: number;

  constructor(id: number, name: string, dateOfBirth: string, point: number) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.point = point;
  }
}
