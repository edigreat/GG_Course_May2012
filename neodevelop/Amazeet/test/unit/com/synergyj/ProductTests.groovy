package com.synergyj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductTests {

    void testConstraintsAllEmpty() {
      // Metodo que me ayuda a hacer objetos mock de los constraints
      println "Haciendo prueba"
      mockForConstraintsTests(Product)
      def product = new Product()
      assertFalse product.validate()
      assert "nullable" == product.errors.name
      assert "nullable" == product.errors["description"]
      assert "nullable" == product.errors.technicalDetails
      assert "nullable" == product.errors.sku
      assert "nullable" == product.errors["price"]
      println product.dump()
    }
    
    void testConstraintsAllBlank() {
      mockForConstraintsTests(Product)
      def product = new Product(
        name:"",description:"",technicalDetails:"",sku:""
      )
      assertFalse product.validate()
      assert "blank" == product.errors.name
      assert "blank" == product.errors["description"]
      assert "blank" == product.errors.technicalDetails
      assert "blank" == product.errors.sku
    }
    
    void testConstraintsWrongValues(){
      mockForConstraintsTests(Product)
      String invalidString = ""
      1.upto(1001){ invalidString+="x" }
      def product = new Product(
        name:invalidString,
        description:invalidString,
        technicalDetails:invalidString,
        sku:invalidString
      )
      assertFalse product.validate()
      assert "size" == product.errors.name
      assert "size" == product.errors["description"]
      assert "size" == product.errors.technicalDetails
      assert "size" == product.errors.sku
    }
    
    void testConstraintsUnique(){
      def p1 = new Product(
        name:"Producto 1",
        description:"Descripción del producto 1",
        technicalDetails:"Detalles tecnicos del producto 1",
        sku:"MYSKU1",
        price:0
      )
      def p2 = new Product(
        name:"Producto 2",
        description:"Descripción del producto 2",
        technicalDetails:"Detalles tecnicos del producto 2",
        sku:"MYSKU2",
        price:0
      )
      mockForConstraintsTests(Product,[p1,p2])
      def p3 = new Product(
        name:"Producto 3",
        description:"Descripción del producto 3",
        technicalDetails:"Detalles tecnicos del producto 3",
        sku:"MYSKU2",
        price:0
      )
      assertFalse p3.validate()
      assert "unique" == p3.errors.sku
    }
}
