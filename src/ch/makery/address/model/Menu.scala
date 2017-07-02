package ch.makery.address.model

import scalafx.beans.property.StringProperty


abstract class Menu {
  val menuId:StringProperty
  var name:StringProperty
  var price:StringProperty
  

  
}