package com.synergyj

class ShoppingCartOrder {

  //ShoppingCart shoppingCart
  ShoppingCartOrderStatus shoppingCartOrderStatus
  ShoppingCart shoppingCart
  Date dateCreated
  Date lastUpdated
  
  static hasOne = [payment:Payment]

  static constraints = {
  }
}
