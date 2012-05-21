class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		//"/mipropiaUrl"(controller:"product",action:"accion")

		//"/"(view:"/index")
		"/"(controller:"store")
		"500"(view:'/error')
	}
}
