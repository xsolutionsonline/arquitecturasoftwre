import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from './services/user.service';
import { Clientes } from './interfaces/clientes';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'api-rest-client';
  contactForm!:FormGroup;
  isResultLoaded = false;
  clientes: any[]=[];
  isEdit: boolean=false;
  idEdit: any;
  

  constructor(private fb:FormBuilder,
    private user:UserService){

  }

  ngOnInit(): void {
    this.contactForm=this.initForm();    
    this.llenarListas();
  }

  llenarListas(){
    this.user.getFindAll().subscribe(resultData=>{
      this.clientes = resultData; 
      this.isResultLoaded=true;    
     });;
  }

  initForm():FormGroup {
    return this.fb.group({
      nombres:['',Validators.required],
      apellidos:['',Validators.required],
      tipodoc:['',Validators.required],
      numerodoc:['',Validators.required],
      direccion:['',Validators.required],
      telefono:['',Validators.required],
      ciudad:['',Validators.required],
      ocupacion:['',Validators.required]
    })
  }
  
  OnSubmit(){
        const clientes:Clientes = {
          ...this.contactForm.value
        }
        console.log('form', this.contactForm.value);
        if(this.isEdit){
          this.clientes=[];
          this.initForm();
          this.user.updated(clientes,this.idEdit).subscribe(res => {
            this.llenarListas();
            this.isEdit=false;
          });
        }else{
          this.initForm();
          this.user.create(clientes).subscribe(res => {
            this.llenarListas();
          });
        }
        
  }

  onEdit(cliente:any){
    this.contactForm.patchValue(cliente);
    this.isEdit=true;
    this.idEdit=cliente.id;
    
  }

  onDelete(id:any){
    console.log('este id',id);
    this.user.delete(id).subscribe(res => {
      this.initForm();
      this.llenarListas();      
    });
  }
}
