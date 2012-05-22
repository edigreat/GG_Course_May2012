package com.synergyj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)//Permite hacer mockDomain y mockForConstraints
class ProductTests {

    void testConstraintsAllEmpty() {
         //Implementacion Mock de los constraints
        mockForConstraintsTests(Product)
        def product = new Product()
        //Antes que los objetos persistan, se validan constraints con validate
        assertFalse product.validate()
        assert "nullable" == product.errors.name
        assert "nullable" == product.errors["description"]
        assert "nullable" == product.errors.technicalDetails
        assert "nullable" == product.errors.sku
        assert "nullable" == product.errors["price"]

      //  println product.dump()
    }


void testConstraintsAllBlank() {
         //Implementacion Mock de los constraints
        mockForConstraintsTests(Product)
        def product = new Product(name:"",description:"",technicalDetails:"",sku:"")
        //Antes que los objetos persistan, se validan constraints con validate
        assertFalse product.validate()
        assert "blank" == product.errors.name
        assert "blank" == product.errors["description"]
        assert "blank" == product.errors.technicalDetails
        assert "blank" == product.errors.sku
        //println product.dump()
    }

    void testConstraintsWrongValues(){
     mockForConstraintsTests(Product)

    String invalidString=""

    1.upto(1001){ invalidString +="x"}
     
        def product = new Product(name:invalidString,description:invalidString,technicalDetails:invalidString,sku:invalidString)
        //Antes que los objetos persistan, se validan constraints con validate
        assertFalse product.validate()
        assert "size" == product.errors.name
        assert "size" == product.errors["description"]
        assert "size" == product.errors.technicalDetails
        assert "size" == product.errors.sku
       // println product.dump()
   
    }   

    void testConstraintsUnique()
    {
        def p1 = new Product(name:"producto 1",
        description:"Description 1",
        technicalDetails:"detalles tecnicos 1",
        sku:"MYSKU1",
        price:22341)
        
        def p2 = new Product(name:"producto 2",
        description:"Description 2",
        technicalDetails:"detalles tecnicos 2",
        sku:"MYSKU2",
        price:22342)

        //Establecer punto de compracion es el segundo parametro                
        mockForConstraintsTests(Product,[p1,p2])

        def p3 = new Product(name:"producto 3",
        description:"Description 3",
        technicalDetails:"detalles tecnicos 3",
        sku:"MYSKU2",
        price:223443)

        assertFalse p3.validate()
        assert "unique" == p3.errors.sku    
    }


}
