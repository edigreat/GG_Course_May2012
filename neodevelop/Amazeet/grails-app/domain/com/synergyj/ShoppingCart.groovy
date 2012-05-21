package com.synergyj

class ShoppingCart {

  //User user
  // No necesito este atributo por que esta
  // definido en la relacion
  //List<ItemToPurchase> itemsToPurchase
  ShoppingCartStatus shoppingCartStatus
  Date dateCreated
  Date lastUpdated
  
  static hasMany = [items:ItemToPurchase]
  
  static constraints = {
  }
}
