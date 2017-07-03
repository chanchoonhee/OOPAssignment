package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.model.{Drinks,DrinkDao}
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent

@sfxml
class AddDrinksController(
    private val drinksIDField : TextField,
    private val drinksNameField  : TextField,
    private val drinksPriceField  : TextField,
    private val drinkTypeField : TextField ){
  

  private var drinks     : Drinks = null
  var okClicked = false

//  def drink = _drinks
//  def drinks_=(x : Drinks) {
//        _drinks = x
//         
//        drinksIDField.text = _drinks.menuId.value
//        drinksNameField.text = _drinks.name.value
//        drinksPriceField.text = _drinks.price.toString
//        drinkTypeField.text = _drinks.drinkType.value
//  }

 
  def handleOk(action :ActionEvent){

     if (isInputValid()) {
       drinks= new Drinks(drinksIDField.text.value ,drinksNameField.text.value ,drinksPriceField.text.value.toDouble,drinkTypeField.text.value)
       MainApp.drinks+= drinks
       DrinkDao.writeToFile()
        okClicked = true
        MainApp.showManageMenuPage
    }
  }
   def handleCancel(action :ActionEvent) {
         MainApp.showManageMenuPage
  }
  def nullChecking (x : String) = x == null || x.length == 0

  def isInputValid() : Boolean = {
    var errorMessage = ""

    if (nullChecking(drinksIDField.text.value))
      errorMessage += "No valid ID!\n"
    if (nullChecking(drinksNameField.text.value))
      errorMessage += "No valid name!\n"
    if (nullChecking(drinksPriceField.text.toString))
      errorMessage += "No valid price!\n"
    if (nullChecking(drinkTypeField.text.value))
      errorMessage += "No valid Drink Type!\n"
      if (errorMessage.length() == 0) {
        return true;
    } else {
        // Show the error message.
      var stage : Stage = null
        val alert = new Alert(Alert.AlertType.Error){
          
          initOwner(stage)
          title = "Invalid Fields"
          headerText = "Please correct invalid fields"
          contentText = errorMessage
        }.showAndWait()

        return false;
    }
    }
    
   }
