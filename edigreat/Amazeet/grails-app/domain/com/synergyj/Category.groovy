package com.synergyj

class Category {

    String name 
    String description
    Date   dateCreated
    Date   lastUpdated
    static hasMany=[products:Product]

    static descriptionValidator = {val,obj -> 
                          def Tamanio = val.tokenize(" ").size()   
                          if( Tamanio < 5) 
                          //"className.property.customError"
                          //  "category.description.badSize"
                         //primer parametro mensaje de error, parametros posicionales                             
                         ["category.description.badSize",val.toString(),Tamanio]  
                         }

    static transients = ['descriptionValidator']   
    
    static constraints ={
    name nullable:false,blank:false,size:3..50
                                                       //val valor actual, obj referencia objeto   
    description nullable:false,blank:false,size:1..1000,validator:descriptionValidator

    }

    String toString(){
    name
    }

}
