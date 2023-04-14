import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../model/Persona';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/CrudBack/personas';

  getPersonas(){
    return this.http.get<Persona[]>(this.Url);
  }
}
