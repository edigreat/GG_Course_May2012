import com.synergyj.Category
import com.synergyj.Product
import grails.util.Environment

class BootStrap {

  def init = { servletContext ->
    
    switch(Environment.current){
      case [Environment.DEVELOPMENT,Environment.TEST]:
        creaCategorias()
        creaProductos()
        break
      case Environment.TEST:
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
    if(!Category.count()){
      log.debug "Creando categorías"
      def c1 = new Category(
        name:"Moda",
        description:"Ropa para desarrolladores de software, qie viven y disfrutan su trabajo"
      ).save()
      def c2 = new Category(
        name:"Accessorios",
        description:"Accesorios para desarrolladores de software, qie viven y disfrutan su trabajo"
      ).save()
      def c3 = new Category(
        name:"Libros",
        description:"Conocimiento siempre contigo a tu alcance"
      ).save()
      log.debug "Categorias creadas: $c1 $c2 $c3"
    }
  }

  def creaProductos(){
    if(!Product.count()){
      log.debug "Creando productos"
      def p1 = new Product(
        name:"T-shirt GrailsMX 2011",
        description:"Playera edición 2011 de la comunidad",
        technicalDetails:"Disponible en S,M,L,XL",
        sku:"GRAILSMX2011",
        price:220.00,
        urlImage:"http://a0.twimg.com/profile_images/1689555085/logo.jpg"
      ).save()
      def p2 = new Product(
        name:"T-shirt Artesanos 2011",
        description:"Playera edición 2011 de la comunidad",
        technicalDetails:"Disponible en S,M,L,XL",
        sku:"ARTESANOS2011",
        price:220.00,
        urlImage:"http://a0.twimg.com/profile_images/1577141713/logo_artesano2.png"
      ).save()
      def p3 = new Product(
        name:"T-shirt Springhispano 2011",
        description:"Playera edición 2011 de la comunidad",
        technicalDetails:"Disponible en S,M,L,XL",
        sku:"SPRING2011",
        price:220.00,
        urlImage:"http://a0.twimg.com/profile_images/59573374/pseudo_logo.png"
      ).save()
      def p4 = new Product(
        name:"Programming Groovy Book",
        description:"Uno de los mejores libros de programación en Groovy",
        technicalDetails:"Author: Venkat Subramaniam",
        sku:"PROGGROOVY011",
        price:330.00,
        urlImage:"http://imagery.pragprog.com/products/100/vslg.jpg"
      ).save()
      def p5 = new Product(
        name:"Grails in action Book",
        description:"Uno de los mejores libros de programación en Grails",
        technicalDetails:"Author: Pter Ledbrook, Glen Smith",
        sku:"PROGGRAILS011",
        price:330.00,
        urlImage:"http://www.flazx.us/data/19/33/98/89/1933988932/0000.L.jpg"
      ).save()
    }
  }

}