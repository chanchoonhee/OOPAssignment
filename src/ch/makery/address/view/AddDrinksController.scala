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
    if (MainApp.selectedDrinks != null){
      print(MainApp.selectedFood)
				drinksIDField.text = MainApp.selectedDrinks.menuId.value
				drinksIDField.disable = true
				drinksNameField.text = MainApp.selectedDrinks.name.value
				drinksPriceField.text = MainApp.selectedDrinks.price.value
				drinkTypeField.text = MainApp.selectedDrinks.drinkType.value
				drinkTypeField.disable = true
    }
  def modeAddDrinks(x:Boolean)= x match{
					  case true =>addDrinks()
					  case false =>editDrinks()
					}
      
def editDrinks(){
	   MainApp.selectedDrinks.menuId.value= drinksIDField.text.value
				MainApp.selectedDrinks.name.value = drinksNameField.text.value
				 MainApp.selectedDrinks.price.value=drinksPriceField.text.value
				 MainApp.selectedDrinks.drinkType.value=drinkTypeField.text.value
				 MainApp.drinks.remove(n=MainApp.dIndex,count =1)
				 MainApp.drinks+=MainApp.selectedDrinks
				 DrinkDao.writeToFile()
				 MainApp.showManageMenuPage
	}
	def addDrinks(){
   if (isInputValid()) {

		drinks= new Drinks(drinksIDField.text.value ,drinksNameField.text.value ,drinksPriceField.text.value.toDouble,drinkTypeField.text.value)
				MainApp.drinks+= drinks
				DrinkDao.writeToFile()
				
				MainApp.showManageMenuPage


	}}
 
  def handleOk(action :ActionEvent){
	if(MainApp.selectedDrinks != null){
				modeAddDrinks(false)
			}else{
			  modeAddDrinks(true)
			}
 		MainApp.selectedDrinks = null
 		MainApp.selectedFood = null
  }
   def handleCancel(action :ActionEvent) {
     MainApp.selectedDrinks = null
     MainApp.selectedFood = null
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
