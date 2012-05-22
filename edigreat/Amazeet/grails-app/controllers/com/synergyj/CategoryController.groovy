package com.synergyj

//import org.springframework.dao.DataIntegrityViolationException

class CategoryController {

//Si no hiciste save o delete, se deduce que es update por post ,por eso la url de la forma dirige a index para evitar ataques, es dificil leer el accion si dirige a otra direccion 

    //static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def scaffold = Category
  
}
