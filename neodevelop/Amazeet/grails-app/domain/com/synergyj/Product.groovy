package com.synergyj

class Product {
  
  String name
  String description
  String technicalDetails
  String sku
  BigDecimal price
  String urlImage
  Date dateCreated
  Date lastUpdated
  
  //static belongsTo = [category:Category]

  static constraints = {
    name nullable:false,blank:false,size:3..50
    description nullable:false,blank:false,size:1..1000
    technicalDetails nullable:false,blank:false,size:1..1000
    sku nullable:false,blank:false,unique:true,size:5..15
    price blank:false
    urlImage url:true,size:10..250 
  }
}
