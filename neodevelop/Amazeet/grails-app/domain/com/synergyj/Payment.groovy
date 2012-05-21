package com.synergyj

class Payment {

  BigDecimal amount
  BigDecimal commission
  String transactionId = UUID.randomUUID().toString().replaceAll('-','').substring(0,15)
  //UUID.randomUUID().toString().replaceAll('-','').substring(0,15)
  String description
  PaymentStatus paymentStatus

  //ShoppingCartOrder shoppingCartOrder
  Date dateCreated
  Date lastUpdated
  
  static belongsTo = [shoppingCartOrder:ShoppingCartOrder]
  
  static constraints = {
    amount nullable:false, blank:false
    commission nullable:false, blank:false
    description blank:true, size:1..1000
    transactionId blank:false,size:1..15
  }
}
