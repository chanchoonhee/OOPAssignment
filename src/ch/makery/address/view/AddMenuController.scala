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
class AddMenuController(
    private val idField : TextField,
    private val    nameField  : TextField,
    private val   priceField  : TextField,
    private val cuisineField  : TextField,
    private val menuType: ChoiceBox[String]
	){
 menuType.items = ObservableBuffer("Food","Drinks")
  var         AddMenuStage : Stage  = null
  private var _menu     : Menu = null
  var         okClicked            = false

  def Menu = _menu
  def Menu_=(x : Menu) {
        _menu = x
         
        idField.text = _menu.menuId.value
        nameField.text = _menu.name.value
        priceField.text = _menu.price.toString
//      cuisineField.text = _menu.cuisine.value
  }

  def handleOk(action :ActionEvent){

     if (isInputValid()) {
    _menu.menuId       <== idField.text
	_menu.name    <== nameField.text
	_menu.price    <== priceField.text
//	_menu.cuisine  <== cuisineField.text
       
        okClicked = true;
        AddMenuStage.close()
    }
  }
   def handleCancel(action :ActionEvent) {
        AddMenuStage.close();
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
          initOwner(AddMenuStage)
          title = "Invalid Fields"
          headerText = "Please correct invalid fields"
          contentText = errorMessage
        }.showAndWait()

        return false;
    }
    }
    
   }
