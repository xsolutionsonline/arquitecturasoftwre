const express = require('express');
const router= express.Router();
const pool = require('../helpers/database');


router.get('/',async function(req,res){
    try{
        const query='SELECT * FROM CLIENTES';
        const rows= await pool.query(query);
        res.setHeader('Content-Type', 'application/json');
        return res.status(200).json(rows);        

    }catch(error){
        res.status(400).send(error.message);        
    }    
});

router.get('/:id',async function(req,res){
    try{
        const query='SELECT * FROM CLIENTES WHERE id=?';
        const rows= await pool.query(query,req.params.id);
        res.setHeader('Content-Type', 'application/json');
        return res.status(200).json(rows);

    }catch(error){
        res.status(400).send(error.message);        
    }    
});

router.post('/create',async function(req,res){
    try{
        const { 
            nombres,
            apellidos,
            tipodoc,
            numerodoc,
            direccion,
            telefono,
            ciudad,
            ocupacion}  = req.body;
        const query='INSERT INTO CLIENTES VALUES(null,?,?,?,?,?,?,?,?)';
        const result= await pool.query(query,[nombres,
            apellidos,
            tipodoc,
            numerodoc,
            direccion,
            telefono,
            ciudad,
            ocupacion]);
        console.log(result);
        
       return res.status(200).json({message:'guardado exitosamente'});

    }catch(error){
        res.status(400).send(error.message);        
    }
   
});

router.put('/:id',async function(req,res){
    try{
        const { 
            nombres,
            apellidos,
            tipodoc,
            numerodoc,
            direccion,
            telefono,
            ciudad,
            ocupacion}  = req.body;

            console.log('llego id',req.params.id);
        
        const query='UPDATE CLIENTES SET nombres=?,apellidos=?,tipodoc=?,numerodoc=?,direccion=?,telefono=?,ciudad=?,ocupacion=? WHERE id='+req.params.id ;

            console.log('query',query);
        var params = [];

        params.push(nombres);  
        params.push(apellidos); 
        params.push(tipodoc); 
        params.push(numerodoc); 
        params.push(direccion); 
        params.push(telefono); 
        params.push(ciudad); 
        params.push(ocupacion); 
        
        const result= await pool.query(query,params);
        
      return  res.status(200).json({message:'actualizado exitosamente'});

    }catch(error){
        res.status(400).send(error.message);        
    }
    
});


router.delete('/:id',async function(req,res){
    try{
        
        const query='DELETE FROM CLIENTES WHERE id='+req.params.id ;
        
        const result= await pool.query(query);
        
        return res.status(200).json({message:'eliminado exitosamente'});

    }catch(error){
        res.status(400).send(error.message);        
    }
   
});

module.exports = router;