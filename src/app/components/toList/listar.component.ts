import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import { ServiceService } from '../../Service/service.service';
import { Persona } from 'src/app/model/Persona';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit{

  personas: Persona[]=[];
  constructor(private service:ServiceService, private router:Router) {}

  ngOnInit() {
    this.service.getPersonas().subscribe(data => {
      this.personas = data;
    });
  }

  Editar(persona:Persona):void {
    localStorage.setItem("id",persona.id.toString());
    this.router.navigate(["editar"]);
  }

  Delete(persona:Persona) {
    this.service.deletePersona(persona).subscribe(data => {
      this.personas= this.personas.filter(p => p!== persona);
      this.msgAlertDelete('top-center','success','Persona eliminada correctamente.','false','1000');    
    })
  }

  msgAlertDelete = (position : any, icon : any, title: any, showConfirmButton: any, timer: any) => {
    Swal.fire({
      position,
      icon,
      title,
      showConfirmButton,
      timer
    })
  }
}
