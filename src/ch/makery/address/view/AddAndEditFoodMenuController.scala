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
class AddAndEditFoodMenuController(
    private val idField : TextField,
    private val    nameField  : TextField,
    private val   priceField  : TextField,
    private val cuisineField  : TextField,
    private val foodType: ChoiceBox[String]
	){
 foodType.items = ObservableBuffer("Food","Drinks")
  var         AddFoodStage : Stage  = null
  private var _food     : Food = null
  var         okClicked            = false

  def Food = _food
  def Food_=(x : Food) {
        _food = x
         
        idField.text = _food.menuId.value
        nameField.text = _food.name.value
        priceField.text = _food.price.toString
//      cuisineField.text = _food.cuisine.value
  }

  def handleOk(action :ActionEvent){

     if (isInputValid()) {
    _food.menuId       <== idField.text
	_food.name    <== nameField.text
	_food.price    <== priceField.text
//	_food.cuisine  <== cuisineField.text
       
        okClicked = true;
        AddFoodStage.close()
    }
  }
   def handleCancel(action :ActionEvent) {
        AddFoodStage.close();
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
          initOwner(AddFoodStage)
          title = "Invalid Fields"
          headerText = "Please correct invalid fields"
          contentText = errorMessage
        }.showAndWait()

        return false;
    }
    }
    
   }
