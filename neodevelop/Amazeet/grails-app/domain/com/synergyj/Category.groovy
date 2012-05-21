package com.synergyj

class Category {
  
  String name
  String description
  Date dateCreated
  Date lastUpdated
  
  static hasMany = [products:Product]
  
  static descriptionValidator = {val,obj ->
    if(val.tokenize(" ").size() < 5)
      false
      //['category.description.badSize',(val.toString()),val.tokenize(" ").size().value]
  }
  static transients = ['descriptionValidator']

  static constraints = {
    name(nullable:false,blank:false,size:3..50)
    description nullable:false,blank:false,size:1..1000,validator:this.descriptionValidator
  }
  
  String toString(){
    name
  }
}
