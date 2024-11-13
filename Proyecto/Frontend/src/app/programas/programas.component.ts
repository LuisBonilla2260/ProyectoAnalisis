import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';
import { Programa } from './programa';
import { ProgramasService } from './programas.service';


@Component({
  selector: 'app-programas',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './programas.component.html',
  styleUrl: './programas.component.css'
})
export class ProgramasComponent implements OnInit {

  programas:Programa[];

  constructor(private programasService: ProgramasService){

  }

  ngOnInit(): void {
    this.programasService.getProgramas().subscribe(
      programas => this.programas = programas
    )
  }

  delete(programa:Programa):void{
    Swal.fire({
      title: "Esta segur@?",
      text: `Seguro deseas eliminar la Tarea: ${programa.nomPrograma} !`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, Eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.programasService.delete(programa.id).subscribe(
          response=>{
            this.programas = this.programas.filter(est=> est !== programa)
            Swal.fire({
              title: "Borrada!",
              text: `Tu Tarea ha sido eliminada: ${programa.nomPrograma}`,
              icon: "success"
            });
          }
        )
      }
    });
  }

}


