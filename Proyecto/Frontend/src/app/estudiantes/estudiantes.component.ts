import { Component, OnInit } from '@angular/core';
import { Estudiante } from './estudiante';
import { EstudiantesService } from './estudiantes.service';
import { ProgramasService } from '../programas/programas.service';
import { Programa } from '../programas/programa';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-estudiantes',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './estudiantes.component.html',
  styleUrl: './estudiantes.component.css'
})
export class EstudiantesComponent implements OnInit {
  estudiantes: Estudiante[] = [];
  programas: Programa[] = [];  // Lista de programas disponibles

  constructor(
    private estudiantesService: EstudiantesService,
    private programasService: ProgramasService
  ) {}

  ngOnInit(): void {
    this.cargarEstudiantes();
    this.cargarProgramas();
  }

  cargarEstudiantes(): void {
    this.estudiantesService.getEstudiantes().subscribe(estudiantes => (this.estudiantes = estudiantes));
  }

  cargarProgramas(): void {
    this.programasService.getProgramas().subscribe(programas => (this.programas = programas));
  }


  delete(estudiante: Estudiante): void {
    Swal.fire({
      title: '¿Está seguro?',
      text: `¿Desea eliminar al estudiante ${estudiante.nombreEstudiante}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar',
      cancelButtonText: 'Cancelar',
    }).then((result) => {
      if (result.isConfirmed) {
        this.estudiantesService.delete(estudiante.id).subscribe(() => {
          this.estudiantes = this.estudiantes.filter(e => e !== estudiante);
          Swal.fire('Estudiante eliminado', `El estudiante ${estudiante.nombreEstudiante} fue eliminado con éxito.`, 'success');
        });
      }
    });
  }
}
