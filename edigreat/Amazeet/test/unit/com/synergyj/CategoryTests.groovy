package com.synergyj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategoryTests {

    void testSaveCategory() {
        //Implementar en modo mock los metodos que se relacionan con base de datos
        mockDomain(Category)
        def category = new Category(name:"Nombre de categoria",description:"hola mundo como estas hoy")
        category.save()
        assert category.id > 0
    }

    void testSaveCategoryNoSave() {
        //Implementar en modo mock los metodos que se relacionan con base de datos
        mockDomain(Category)
        def category = new Category(name:"Nombre de categoria",description:"hola mundo")
        assert  !category.save()
        assert  !category.id   
    }

}
