package com.synergyj

class Payment {

	BigDecimal 			amount
	BigDecimal 			commision
	String     			transactionID = UUID.randomUUID().toString().replaceAll('-','').substring(0,15)
	String     			description
	
	//ShoppingCartOrder 	shoppingCartOrder
	Date    			dateCreated
	Date    			lastUpdated
	
	PaymentStatus paymentStatus
	
	static belongsTo = [shoppingCartOrder:ShoppingCartOrder]
	
    static constraints = {
	amount nullable:false,blank:false //range:0f..999f
	commision nullable:false,blank:false //range:0f..9f	
	description blank:true,size:1..1000 //nullable:false
	transactionID blank:false,size:1..15
	//shoppingCartOrder notNull:true
	}
}
