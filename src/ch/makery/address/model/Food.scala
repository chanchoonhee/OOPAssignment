
package ch.makery.address.model

import scalafx.beans.property.StringProperty
class Food(val menuIdS:String ,var nameS:String ,var priceS:Double ,val cuisineS:String ) extends Menu {

val menuId= StringProperty(menuIdS.toString)
var name= new StringProperty(nameS)
var price= StringProperty(priceS.toString) 
val cuisine= new StringProperty(cuisineS)

}
