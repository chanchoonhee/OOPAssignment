package ch.makery.address.view
import scalafx.Includes._
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.{TableView, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import ch.makery.address.model.Food
import ch.makery.address.model.Drinks
import scalafx.beans.property.StringProperty
import scalafx.scene.control.ChoiceDialog
import scalafx.stage.Stage

@sfxml
class ManageMenuController(
    private val foodTable : TableView[Food],
    
    private val foodId : TableColumn[Food, String],
    
    private val foodName : TableColumn[Food, String],
    
    private val foodPrice : TableColumn[Food, String],
    
    private val foodCuisine : TableColumn[Food, String],
    
    private val drinksTable : TableView[Drinks],
    
    private val drinksId : TableColumn[Drinks, String],
    
    private val drinksName : TableColumn[Drinks, String],
    
    private val drinksPrice : TableColumn[Drinks, String],
    
    private val drinksType : TableColumn[Drinks, String]
    ){
  
  var stage : Stage = null
  
  foodTable.items = MainApp.food
  foodId.cellValueFactory = {_.value.menuId}
  foodName.cellValueFactory  = {_.value.name}
  foodPrice.cellValueFactory = {_.value.price}
  foodCuisine.cellValueFactory = {_.value.cuisine}

  drinksTable.items = MainApp.drinks
  drinksId.cellValueFactory = {_.value.menuId}
  drinksName.cellValueFactory  = {_.value.name}
  drinksPrice.cellValueFactory = {_.value.price}
  drinksType.cellValueFactory = {_.value.drinkType}

  def chooseMenuType() = {
    val types = Seq("Food", "Drinks")
    val dialog = new ChoiceDialog(defaultChoice = "Food", choices = types){
      initOwner(stage)
      title = "Menu Type"
      contentText = "Choose menu type."
    }
    
    val result = dialog.showAndWait()
    
    result match{
      case Some(choice) => foodOrDrinks(choice)
    }
  }
  
  def foodOrDrinks(choice: String)= {
    if(choice == "Food")
      MainApp.showAddAndEditFoodMenu
    else
      MainApp.showAddAndEditDrinksMenu
  }
  
  def handleAddMenu(action : ActionEvent)={
    chooseMenuType
  }
  
  def handleEditMenu(action : ActionEvent)={
    MainApp.showAddMenu
  }
  
  def handleDeleteMenu(action : ActionEvent)={
    print("to be done")
  }
  
}