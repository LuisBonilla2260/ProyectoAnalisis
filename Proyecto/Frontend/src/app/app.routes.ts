import { Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProgramasComponent } from './programas/programas.component';
import { EstudiantesComponent } from './estudiantes/estudiantes.component';
import { FormComponent } from './estudiantes/form.component';
import { FormPComponent } from './programas/formp.component';

export const routes: Routes = [
    {path:'', redirectTo:'/estudiantes', pathMatch:'full'},
    {path:'header', component: HeaderComponent},
    {path:'footer', component:FooterComponent},
    {path:'estudiantes', component:EstudiantesComponent},
    {path:'programas', component:ProgramasComponent},
    {path:'estudiantes/form', component:FormComponent},
    {path:'estudiantes/form/:id', component:FormComponent},
    {path:'programas/formP', component:FormPComponent},
    {path:'programas/formP/:id', component:FormPComponent},
];
