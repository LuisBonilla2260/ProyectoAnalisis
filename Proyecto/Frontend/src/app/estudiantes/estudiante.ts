import { Programa } from "../programas/programa";

export class Estudiante {
  id: number;
  nombreEstudiante: string;
  edad: number;
  documento: string;
  programaId:Programa
}