package com.synergyj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(StoreController)
@Mock(Product) 
// Importante para hacer el mock de Product en lo metodos del controller
class StoreControllerTests {

  void testIndex() {
    // Aqui podemo simular el envio de parametros
    controller.index()
    // Aqui se generan objetos mock que podemos usar
    assert response.text == "Hola mundo!"
    assert model == [:]
    log.debug params.dump()
  }
  
  void testReviewITem(){
    params.id = 1
    controller.reviewItem()
    assert response.redirectUrl == "/product/show/1"
  }
  
  void testAddItem(){
    def p1 = new Product(
      id:1,
      name:"Producto 1",
      description:"Descripción del producto 1",
      technicalDetails:"Detalles tecnicos del producto 1",
      sku:"MYSKU1",
      price:0,
      urlImage:"http://somehitng.com/imagen.jpg"
    )
    mockDomain(Product,[p1])
    params.id = 1
    controller.addItem()
    assert session.shoppingCart
    assert model.product
    assert view == "/store/added"
  }
  
}
