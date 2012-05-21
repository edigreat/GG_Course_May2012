package com.synergyj



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategoryTests {

    void testSaveCategory() {
       mockDomain(Category)
       def category = new Category(
         name:"Nombre de Categoria",
         description:"hola mundo como estas hoy ?"
       )
       category.save()
       assert category.id > 0
    }
    
    void testCategoryNoSave(){
      mockDomain(Category)
       def category = new Category(
         name:"Nombre de Categoria",
         description:"descripcion"
       )
       assert !category.save()
       assert !category.id
    }
}
