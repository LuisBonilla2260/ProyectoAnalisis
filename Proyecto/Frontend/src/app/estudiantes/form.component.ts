import { Component, Input, OnInit } from '@angular/core';
import { Estudiante } from './estudiante';
import { EstudiantesService } from './estudiantes.service';
import { Programa } from '../programas/programa';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProgramasService } from '../programas/programas.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule,  CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './estudiantes.component.css'
})
export class FormComponent implements OnInit {
  public estudiantes: Estudiante = new Estudiante();
  programas: Programa[] = [];
  selectedPrograma: number;

  constructor(
    private estudiantesService: EstudiantesService,
    private programasService: ProgramasService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.cargarEstudiante();
    this.programasService.getProgramas().subscribe((programas) => (this.programas = programas));
  }

  cargarEstudiante(): void {
    this.activatedRoute.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        this.estudiantesService.getEstudiante(id).subscribe((estudiante) => {
          this.estudiantes = estudiante;
          if (this.estudiantes.programaId) {
            this.selectedPrograma = this.estudiantes.programaId.id;
          }
        });
      }
    });
  }  

  public create(): void {
    // Busca el programa seleccionado por su ID y lo asigna al estudiante
    const selectedPrograma = this.programas.find((prog) => prog.id === this.selectedPrograma);

    if (selectedPrograma) {      
      this.estudiantes.programaId = selectedPrograma;
    }
    console.log(this.estudiantes.programaId+"abcd");
  
    this.estudiantesService.create(this.estudiantes).subscribe({
      next: (estudiante) => {
        this.router.navigate(['/estudiantes']);
        Swal.fire('Nuevo Estudiante', `El estudiante ${estudiante.nombreEstudiante} ha sido creado con éxito`, 'success');
      },
      error: (error) => {
        console.error("Error en el servidor:", error);
        Swal.fire('Error', 'No se pudo crear el estudiante. Verifica los datos y vuelve a intentarlo.', 'error');
      }
    });
  }
  
  update(): void {
    // Busca el programa seleccionado por su ID y lo asigna al estudiante
    const selectedPrograma = this.programas.find((prog) => prog.id === this.selectedPrograma);
  
    if (selectedPrograma) {
      this.estudiantes.programaId = selectedPrograma; // Asegura que se asigna el objeto completo del programa
    }
  
    console.log("Datos del estudiante a actualizar:", this.estudiantes); // Log para verificar los datos antes de enviar
  
    this.estudiantesService.update(this.estudiantes).subscribe({
      next: () => {
        this.router.navigate(['/estudiantes']);
        Swal.fire('Estudiante Actualizado', `El estudiante ${this.estudiantes.nombreEstudiante} ha sido actualizado con éxito`, 'success');
      },
      error: (error) => {
        console.error("Error en el servidor:", error); // Log para depurar errores del servidor
        Swal.fire('Error', 'No se pudo actualizar el estudiante. Verifica los datos y vuelve a intentarlo.', 'error');
      }
    });
  }
  
}
