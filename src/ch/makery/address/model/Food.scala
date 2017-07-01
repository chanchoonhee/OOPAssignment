package ch.makery.address.model
import scalafx.beans.property.{StringProperty, IntegerProperty, ObjectProperty}
import java.time.LocalDate;

class Food(menuID:Integer ,var name:String ,var price:Double ,val cuisines:String){
  var ID = IntegerProperty(menuID)
}