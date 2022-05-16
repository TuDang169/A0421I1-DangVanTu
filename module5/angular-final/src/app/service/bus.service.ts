import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Bus} from '../model/bus';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BusService {
  public apiURL = 'http://localhost:3000/buses';

  constructor(private http: HttpClient) { }


  createBus(value: Bus): Observable<any> {
    return this.http.post<any>(this.apiURL, value);
  }

  findAll(): Observable<Bus[]> {
    return this.http.get<Bus[]>(this.apiURL);
  }

  findById(id: number): Observable<any> {
    return this.http.get<Bus[]>(this.apiURL + '/' + id);
  }

  deleteBus(id: number): Observable<any> {
    return this.http.delete<Bus[]>(this.apiURL + '/' + id);
  }

  updateBus(id: number, bus: Bus): Observable<any> {
    return this.http.patch<Bus[]>(this.apiURL + '/' + id, bus);
  }
}
