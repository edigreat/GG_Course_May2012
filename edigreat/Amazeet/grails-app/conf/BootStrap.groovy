import com.synergyj.Category
import com.synergyj.Product
import grails.util.Environment
class BootStrap {

	def init = { servletContext ->
		//Se ejecutan de acuerdo a el modo indicado

		switch(Environment.current)
		{
			case [
				Environment.DEVELOPMENT,
				Environment.TEST
			]:
				creaCategorias()
				creaProductos()
				break
			case Environment.PRODUCTION:
				break
		}




	}
	def destroy = {
	}

	def creaCategorias(){


		if(!Category.count())
		{
			log.debug "Creando categorias"
			
			def c1 = new Category(name:"Moda",description:"Ropa para desarrolladores de software a tu alcance").save()
			def c2 = new Category(name:"Accesorios",description:"Accesorios para desarrolladores de software  a tu alcance ").save()
			def c3 = new Category(name:"Libros",description:"Libros para desarrolladores de software  a tu alcance").save()
			log.debug "Categorias creadas $c1 $c2 $c2"
			
		}


	}
	
	def creaProductos(){
		if(!Product.count())
		{
			log.debug "Creando productos"
			def prod1 = new Product(name:"Tshirt grailsmx2010",description:"Playera edicion 2012",technicalDetails:"Disponible en s,x,xl",sku:"GRAILSMX2011",price:220.0,urlImage:"http://www.henriksen-rom.com/william/wp-content/uploads/2010/04/grails-300x292.jpg").save()
			def prod2 = new Product(name:"Tshirt artesanosmx2010",description:"Playera edicion 2012",technicalDetails:"Disponible en s,x,xl",sku:"ARTESANOS2011",price:225.0,urlImage:"http://wordpress.transentia.com.au/wordpress/wp-content/uploads/2009/05/gm7_400.jpg").save()
			def prod3 = new Product(name:"Tshirt spring hispano mx2010",description:"Playera edicion 2012",technicalDetails:"Disponible en s,x,xl",sku:"SPH2011",price:255.0,urlImage:"http://wordpress.transentia.com.au/wordpress/wp-content/uploads/2009/05/gm7_400.jpg").save()
			def prod4 = new Product(name:"Programing groovy ",description:"Los mejores libros de programacion",technicalDetails:"Author:Subramian",sku:"PROGGROOVY2011",price:325.0,urlImage:"http://ecx.images-amazon.com/images/I/51Kfuns5IrL._BO2,204,203,200_PIsitb-sticker-arrow-click,TopRight,35,-76_AA300_SH20_OU01_.jpg").save()
			def prod5 = new Product(name:"Grails in action ",description:"Libro de grails in action",technicalDetails:"Author:P Lederbrok",sku:"GGINACTION2011",price:425.0,urlImage:"http://www.flazx.us/data/19/33/98/89/1933988932/0000.L.jpg").save()
			//println prod3.validate()
			//println prod3.errors
		}


	}


}
