import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Programa } from './programa';

@Injectable({
  providedIn: 'root'
})
export class ProgramasService {

  private urlEndpoint='http://localhost:9000/api/programas'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})

  constructor(private http:HttpClient) { }

  getProgramas():Observable<Programa[]>{
    
   //return of (INVENTORES);
   return this.http.get(this.urlEndpoint).pipe(
    map((response) => response as Programa[])
   )
  
  }

  create(programa:Programa):Observable<Programa>{
    return this.http.post<Programa>(this.urlEndpoint, programa, {headers: this.httpHeaders})
  }

  //Método de editar tarea    
  getPrograma(id: any):Observable<Programa>{
    return this.http.get<Programa>(`${this.urlEndpoint}/${id}`)
  }
  
  //Edición final
  update(programa: Programa):Observable<Programa>{
    return this.http.put<Programa>(`${this.urlEndpoint}/${programa.id}`, programa, {headers:this.httpHeaders})
  }
  
  //Eliminar
  delete(id:number):Observable<Programa>{
    return this.http.delete<Programa>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
  }

}
