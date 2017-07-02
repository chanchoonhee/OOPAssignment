package ch.makery.address.model
import scalafx.beans.property.StringProperty
class Drinks(val menuIdS:Integer,var nameS:String ,var priceS:Double ,val drinkTypeS:String) extends Menu {
val menuId= StringProperty(menuIdS.toString)
var name= new StringProperty(nameS)
var price= StringProperty(priceS.toString) 
val drinkType= new StringProperty(drinkTypeS)
}
  


