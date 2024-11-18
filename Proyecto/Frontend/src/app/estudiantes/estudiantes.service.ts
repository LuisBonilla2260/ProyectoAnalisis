import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { Estudiante } from './estudiante';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstudiantesService {

  private urlEndpoint='http://localhost:9000/api/estudiante'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})

  constructor(private http:HttpClient) { }

  getEstudiantes():Observable<Estudiante[]>{
    
   //return of (INVENTORES);
   return this.http.get(this.urlEndpoint).pipe(
    map((response) => response as Estudiante[])
   )
  
  }

  create(estudiante:Estudiante):Observable<Estudiante>{
    return this.http.post<Estudiante>(this.urlEndpoint, estudiante, {headers: this.httpHeaders});
  }

  //Método de editar tarea    
  getEstudiante(id: any):Observable<Estudiante>{
    return this.http.get<Estudiante>(`${this.urlEndpoint}/${id}`)
  }
  
  update(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.put<Estudiante>(`${this.urlEndpoint}/${estudiante.id}`, estudiante, {
      headers: this.httpHeaders
    });
  }  
  
  //Eliminar
  delete(id:number):Observable<Estudiante>{
    return this.http.delete<Estudiante>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
  }

}
