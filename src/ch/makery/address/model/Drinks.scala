package ch.makery.address.model
import scalafx.beans.property.StringProperty
class Drinks(val menuIdS:String,var nameS:String ,var priceS:Double ,val drinkTypeS:String) extends Menu {
val menuId= StringProperty(menuIdS)
var name= new StringProperty(nameS)
var price= StringProperty(priceS.toString) 
val drinkType= new StringProperty(drinkTypeS)
}
  


