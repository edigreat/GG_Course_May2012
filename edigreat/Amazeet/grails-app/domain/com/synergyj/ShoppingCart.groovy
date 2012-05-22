package com.synergyj

class ShoppingCart {

	//User user
	//List<ItemToPurchase> itemsToPurchase no se necesita el atributo por que se define en la relacion
	
	ShoppingCartStatus shoppingCartStatus
	Date    dateCreated
	Date    lastUpdated
	
	static hasMany=[items:ItemToPurchase]
	
	
    static constraints = {
    
		}
}
