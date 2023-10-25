import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/model/Persona';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})

export class AgregarComponent {

  ngOnInit() {
  }

  persona:Persona= new Persona();
  constructor(private router:Router, private service:ServiceService) {
  }

  Guardar(){
      this.service.createPersona(this.persona)
      .subscribe(data=>{
        this.msgAlertGuardar('top-center','success','Persona guardada correctamente.','false','1000');    
        this.router.navigate(["listar"]);
      });
    }

msgAlertGuardar = (position : any, icon : any, title: any, showConfirmButton: any, timer: any) => {
    Swal.fire({
      position,
      icon,
      title,
      showConfirmButton,
      timer
    })
  }
}


