import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/model/Persona';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})

export class EditarComponent {

  persona:Persona = new Persona();
  constructor(private router:Router,private service:ServiceService) { }

  ngOnInit() {
    let id = localStorage.getItem("id");
    if(id != null) {
      this.service.getPersonaId(parseInt(id)).subscribe(data => {
        this.persona = data;
      })
    }
  }

  Editar(){
    let id = localStorage.getItem("id");
    if (id != undefined) {
      this.persona.id = parseInt(id);
      this.service.updatePersona(this.persona).subscribe(data => {
        this.persona = data;
        this.msgAlertEditar('top-center','success','Persona actualizada correctamente.','false','1000');    
        this.router.navigate(["listar"]);
      })        
    }
  }

  Cancelar() {
    this.router.navigate(["listar"]);
  }

  msgAlertEditar = (position : any, icon : any, title: any, showConfirmButton: any, timer: any) => {
    Swal.fire({
      position,
      icon,
      title,
      showConfirmButton,
      timer
    })
  }
}
