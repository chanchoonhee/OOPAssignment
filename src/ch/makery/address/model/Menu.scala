package ch.makery.address.model
import scalafx.beans.property.{StringProperty, IntegerProperty, DoubleProperty, ObjectProperty}

abstract class Menu {
  val menuId:Integer
  var name:String
  var price:Double 
  

  
}