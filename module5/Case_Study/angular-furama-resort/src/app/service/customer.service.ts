import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public apiURL = "http://localhost:3000/customers";

  constructor(private http: HttpClient) { }


  createCustomer(value:Customer):Observable<any> {
    return this.http.post<any>(this.apiURL,value)
  }

  findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.apiURL);
  }

  findById(id: number):Observable<any> {
    return this.http.get<Customer[]>(this.apiURL+"/"+id);
  }

  deleteCustomer(id: number):Observable<any>{
    return this.http.delete<Customer[]>(this.apiURL+"/"+id);
  }

  updateCustomer(id: number,customer: Customer):Observable<any>{
    return this.http.patch<Customer[]>(this.apiURL+"/"+id, customer);
  }
}
