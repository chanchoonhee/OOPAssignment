package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert, ChoiceBox}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.model.{Menu,Drinks,Food}
import scalafx.collections.ObservableBuffer

import scalafx.event.ActionEvent

@sfxml
class AddAndEditDrinksMenuController(
    private val idField : TextField,
    private val    nameField  : TextField,
    private val   priceField  : TextField,
    private val typeField  : TextField
	){
  var         AddDrinksStage : Stage  = null
  private var _drinks     : Drinks = null
  var         okClicked            = false

  def Drinks = _drinks
  def Drinks_=(x : Drinks) {
        _drinks = x
         
        idField.text = _drinks.menuId.value
        nameField.text = _drinks.name.value
        priceField.text = _drinks.price.toString
//      cuisineField.text = _drinks.cuisine.value
  }

  def handleOk(action :ActionEvent){

     if (isInputValid()) {
    _drinks.menuId       <== idField.text
	_drinks.name    <== nameField.text
	_drinks.price    <== priceField.text
//	_drinks.cuisine  <== cuisineField.text
       
        okClicked = true;
        AddDrinksStage.close()
    }
  }
   def handleCancel(action :ActionEvent) {
        AddDrinksStage.close();
  }
  def nullChecking (x : String) = x == null || x.length == 0

  def isInputValid() : Boolean = {
    var errorMessage = ""

    if (nullChecking(idField.text.value))
      errorMessage += "No valid ID!\n"
    if (nullChecking(nameField.text.value))
      errorMessage += "No valid name!\n"
    if (nullChecking(priceField.text.toString))
      errorMessage += "No valid price!\n"
//    if (nullChecking(cuisineField.text.value))
//      errorMessage += "No valid cuisine!\n"
      if (errorMessage.length() == 0) {
        return true;
    } else {
        // Show the error message.
        val alert = new Alert(Alert.AlertType.Error){
          initOwner(AddDrinksStage)
          title = "Invalid Fields"
          headerText = "Please correct invalid fields"
          contentText = errorMessage
        }.showAndWait()

        return false;
    }
    }
    
   }
