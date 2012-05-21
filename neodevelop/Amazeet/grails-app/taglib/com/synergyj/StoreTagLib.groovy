package com.synergyj

class StoreTagLib {
  
  static namespace = "store"
  
  static final small = [width:120,height:120]
  static final medium = [width:300,height:300]
  static final big = [width:400,height:400]

  def showProduct = { attrs,body ->
    def size = attrs?.size ?: 'medium'
    def width = 0
    def height = 0
    switch(size){
      case 'small':
        (width,height) = [small.width,small.height]
        break
      case 'medium':
        (width,height) = [medium.width,medium.height]
        break
      case 'big':
        (width,height) = [big.width,big.height]
        break
    }
    out << """
      <img src="${attrs.url}" width="$width" height="$height" />
    """
  }
  
}
