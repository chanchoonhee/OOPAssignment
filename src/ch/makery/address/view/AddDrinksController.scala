package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.scene.control.{TextField, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import ch.makery.address.model.{Drinks,Food}
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent

@sfxml
class AddDrinksController(
    private val drinksIDField : TextField,
    private val drinksNameField  : TextField,
    private val drinksPriceField  : TextField,
    private val drinkTypeField : TextField ){
  
  var         AddDrinksStage : Stage  = null
  private var _drinks     : Drinks = null
  var okClicked = false

  def Drinks = _drinks
  def Drinks_=(x : Drinks) {
        _drinks = x
         
        drinksIDField.text = _drinks.menuId.value
        drinksNameField.text = _drinks.name.value
        drinksPriceField.text = _drinks.price.toString
        drinkTypeField.text = _drinks.drinkType.toString
  }

  def handleOk(action :ActionEvent){

     if (isInputValid()) {
    _drinks.menuId       <== drinksIDField.text
	_drinks.name    <== drinksNameField.text
	_drinks.price    <== drinksPriceField.text
_drinks.drinkType    <==drinkTypeField.text
       
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

    if (nullChecking(drinksIDField.text.value))
      errorMessage += "No valid ID!\n"
    if (nullChecking(drinksNameField.text.value))
      errorMessage += "No valid name!\n"
    if (nullChecking(drinksPriceField.text.toString))
      errorMessage += "No valid price!\n"
    if (nullChecking(drinkTypeField.text.value))
      errorMessage += "No valid cuisine!\n"
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
