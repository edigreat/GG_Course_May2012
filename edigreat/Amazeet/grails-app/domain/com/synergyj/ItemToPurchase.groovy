package com.synergyj

class ItemToPurchase {

	Integer quantity
	Date    dateCreated
	Date    lastUpdated
	Product product
	
	static belongsTo=[shoppingCart:ShoppingCart]
	
    static constraints = {
		quantity range:1..10
    }
}
