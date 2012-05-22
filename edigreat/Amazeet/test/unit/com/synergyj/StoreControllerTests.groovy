package com.synergyj

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(StoreController)
@Mock(Product) //Permite hacer mock de product en los metodos del controller
class StoreControllerTests {

	//Ya deja una instancia del controlador llamada controller
	
    void testIndex() {
     //simular envio de parametros
		 controller.index()
	 //Se generan objetos mock
		 assert response.text=="hola mundo"
		 assert model == [:]
		 log.debug params.dump()	
    }
	
	void testReviewItem(){
		params.id=1
		controller.reviewItem()
		assert response.redirectUrl == "/product/show/1"
	}
	
	void testAddItem(){
		def p1 = new Product(
			id:1,
			name:"producto 1",
			description:"Description 1",
			technicalDetails:"detalles tecnicos 1",
			sku:"MYSKU1",
			price:22341,
			urlImage:"http://www.misitio.com/imagen.jpeg")
		
		mockDomain(Product,[p1])
		
		params.id=1
		
		controller.addItem()
		assert session.shoppingCart
		assert model.product
		assert view == "/store/added"
		
	
}
	
}
