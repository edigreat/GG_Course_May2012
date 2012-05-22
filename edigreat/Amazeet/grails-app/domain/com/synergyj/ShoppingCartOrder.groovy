package com.synergyj

import java.util.Date;

class ShoppingCartOrder {

	
//	ShoppingCart shoppingCart no se necesita
	
	ShoppingCartOrderStatus shoppingCartOrderStatus
	ShoppingCart shoppingCart
	Date   dateCreated
	Date   lastUpdated
	
	static hasOne = [payment:Payment] //relacion uno a uno
	
	
    static constraints = {
    }
}
