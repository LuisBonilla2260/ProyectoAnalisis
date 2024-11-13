import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { Programa } from './programa';
import { ProgramasService } from './programas.service';

@Component({
  selector: 'app-formp',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './formp.component.html',
})
export class FormPComponent implements OnInit {
  public programa: Programa = new Programa();
  titulo: string = "Formulario de ingreso de Programa";

  constructor(
    private programasService: ProgramasService,
    private router: Router,
    private activatedRouted: ActivatedRoute
  ) {}

  ngOnInit() {
    this.cargarPrograma();
  }

  cargarPrograma(): void {
    this.activatedRouted.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        this.programasService.getPrograma(id).subscribe((programa) => {
          this.programa = programa;
        });
      }
    });
  }

  // Método de creación de programa
  public create(): void {
    this.programasService.create(this.programa).subscribe((programa) => {
      this.router.navigate(['/programas']);
      Swal.fire('Nuevo programa', `Programa: ${programa.nomPrograma} creado con éxito`, 'success');
    });
  }

  // Método de actualización de programa
  update(): void {
    this.programasService.update(this.programa).subscribe(() => {
      this.router.navigate(['/programas']);
      Swal.fire('Programa Actualizado', `El programa ha sido actualizado exitosamente!`, 'success');
    });
  }
}
