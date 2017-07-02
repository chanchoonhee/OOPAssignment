package ch.makery.address.view
import scalafx.Includes._
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafx.scene.control.{TableView, TableColumn, Label, Alert}
import scalafxml.core.macros.sfxml
import ch.makery.address.model.Food
import ch.makery.address.model.Drinks
import scalafx.beans.property.{StringProperty, IntegerProperty, DoubleProperty, ObjectProperty}


@sfxml
class ManageMenuController(
    private val foodTable : TableView[Food],
    
    private val foodId : TableColumn[Food, Integer],
    
    private val foodName : TableColumn[Food, String],
    
    private val foodPrice : TableColumn[Food, Double],
    
    private val foodCuisine : TableColumn[Food, String],
    
    private val drinksTable : TableView[Drinks],
    
    private val drinksId : TableColumn[Drinks, Integer],
    
    private val drinksName : TableColumn[Drinks, String],
    
    private val drinksPrice : TableColumn[Drinks, Double],
    
    private val drinksType : TableColumn[Drinks, String]
    ){
  foodTable.items = MainApp.food
  
  //foodId.cellValueFactory = {_.value.menuId}
//  foodName.cellValueFactory = {_.value.name}
  //foodPrice.cellValueFactory = {_.value.price}
//  foodCuisine.cellValueFactory = {_.value.cuisine}
  drinksTable.items = MainApp.drinks
  //drinksName.cellValueFactory = {_.value.name}
  
  def handleAddMenu(action : ActionEvent)={
  }
  
  def handleEditMenu(action : ActionEvent)={
    val selectedMenuItem = foodTable.selectionModel().selectedItem.value
    print(selectedMenuItem)
  }
  
  def handleDeleteMenu(action : ActionEvent)={
    print("to be done")
  }
  
}