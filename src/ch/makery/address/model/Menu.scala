package ch.makery.address.model

abstract class Menu {
  val menuId:Integer
  val name:String
  var price:Double 
  
  def newMenuItem(name:String,price:Double)={
    
  }
  
  
}