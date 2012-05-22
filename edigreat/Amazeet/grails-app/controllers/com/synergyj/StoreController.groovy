package com.synergyj

class StoreController {

	//Se ejecuta antes de cada accion
	
	def beforeInterceptor = {
		
		log.debug "Estoy en la accion ${actionName} del controlador ${controllerName} [${session.shoppingCart}]"

		if(!session.shoppingCart)
		{
			log.debug "Se crea Carrito"
			def shoppingCart =  new ShoppingCart(shoppingCartStatus:ShoppingCartStatus.SHOPPING)
			shoppingCart.items = []
			session.shoppingCart =shoppingCart
			
		}
		
		log.debug "Despues en la accion ${actionName} del controlador ${controllerName} [${session.shoppingCart}]"
		
		
	}
	
    def index() {
		//TODO: Catalogo de productos
		def products = Product.list()
		//Catalogo de categorias
		//def categories = Category.list()
		//Todas las acciones regresan un mapa
		
		[products:products]
		
		}
	
	def reviewItem = {
		//TODO: Obtener el id de producto y mostrar el detalle de los productos
		//log.debug "Params ${params.id}"
		redirect(controller:'product',action:'show',id:params.id)
		
		}
	
	def addItem() {
		def product = Product.get(params.productId)
		def item = new ItemToPurchase(product:product,quantity:params.int('quantity'))
		session.shoppingCart.items << item
		log.debug item.dump()
		
		//Render puede recibir el objeto modelo  como un mapa y se lo pega a la vista
		
		//log.debug request.dump()
		//log.debug response.dump()
//		log.debug session
	//	log.debug servletContext.dump()
	//	log.debug flash.dump()
		flash.message = "Haz agregado un producto a tu carrito"
		redirect action:'index'
		
		}
	
	
	def addItemAsync(){
		
		log.debug "Hola mundo ajax"
		
		render "Hola mundo ajax"
		}
	
	
}
