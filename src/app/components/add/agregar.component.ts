import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/model/Persona';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})

export class AgregarComponent {


  persona:Persona= new Persona();
  constructor(private router:Router, private service:ServiceService) {
  }

  form:FormGroup =new FormGroup({
    email:new FormControl("",[Validators.required,this.EmailValidator])
  })

  getError(control:any) : string {
    if(control.errors?.required && control.touched)
      return 'Este campo es requerido';
    else if(control.errors?.emailError && control.touched)
      return 'Por favor ingresar una direccion de correo valida';
    else return '';
}

  EmailValidator(control:AbstractControl) {
    const pattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,20}$/;
    const value = control.value;
    if(!pattern.test(value) && control.touched) 
      return {
        emailError:true
      }
    else return null;
}

  Guardar(){
    this.service.createPersona(this.persona)
    .subscribe(data=>{
      alert("Se agregó la persona.");
      this.router.navigate(["listar"]);
    })
  }

  ngOnInit() {
  }
}
