import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clientes } from '../interfaces/clientes';
import { environment } from '../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private urlEndPoint: string = environment.url;

  constructor(private http:HttpClient) { }


  create(cliente: Clientes) {
    return this.http.post<String>(`${this.urlEndPoint}/create`, cliente);
  }

  updated(cliente: Clientes,id:any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.put<String>(`${this.urlEndPoint}${id}`, cliente,httpOptions);
  }

  getFindAll() {
     return this.http.get<Clientes[]>(`${this.urlEndPoint}`);    
  }

  getFindFieldId(id:String) {
    return this.http.get<Clientes>(`${this.urlEndPoint}/${id}`);
  }

  delete(id:String) {
    return this.http.delete<String>(`${this.urlEndPoint}/${id}`);
  }
}
