package ch.makery.address.view

import ch.makery.address.MainApp

import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label,TableColumn, TextInputDialog, TableView}
import ch.makery.address.model.{Food, Drinks, Menu}




@sfxml
class OrderMenuController(
    private val foodTable : TableView[Food],
    private val foodId : TableColumn[Food, String],
    private val foodName : TableColumn[Food, String],
    private val foodPrice : TableColumn[Food, String],
    private val drinksTable : TableView[Drinks],
    private val drinksId : TableColumn[Drinks, String],
    private val drinksName : TableColumn[Drinks, String],
    private val drinksPrice : TableColumn[Drinks, String],
    private val orderTable : TableView[Menu],
    private val orderName : TableColumn[Menu, String],
    private val orderPrice: TableColumn[Menu, String]
    )
    {
  
  foodTable.items = MainApp.food
  foodId.cellValueFactory = {_.value.menuId}
  foodName.cellValueFactory  = {_.value.name}
  foodPrice.cellValueFactory = {_.value.price}

  drinksTable.items = MainApp.drinks
  drinksId.cellValueFactory = {_.value.menuId}
  drinksName.cellValueFactory  = {_.value.name}
  drinksPrice.cellValueFactory = {_.value.price}
  
  
  
  def handleBack (action: ActionEvent){
    MainApp.showMainPage
  }
  
  
  def handleAdd (action : ActionEvent){ 
    var selectedFood = foodTable.selectionModel().selectedItem.value
    var selectedDrinks = drinksTable.selectionModel().selectedItem.value
    val checkFood = foodTable.selectionModel().selectedIndex.value
    val checkDrinks = drinksTable.selectionModel().selectedIndex.value
    orderTable.items = MainApp.order
    
    if(checkFood >= 0 && checkDrinks >= 0){
      foodTable.selectionModel().clearSelection()
      drinksTable.selectionModel().clearSelection()
      selectedFood = foodTable.selectionModel().selectedItem.value
      selectedDrinks = drinksTable.selectionModel().selectedItem.value
    } else if (checkFood>= 0 && checkDrinks < 0){
        MainApp.order += selectedFood.asInstanceOf[Menu]
        displayOrder()
        foodTable.selectionModel().clearSelection()
    } else if (checkDrinks >= 0 && checkFood < 0){
        MainApp.order += selectedDrinks.asInstanceOf[Menu]
        displayOrder()
        drinksTable.selectionModel().clearSelection()
    }
    
    //to be deleted after finalizing 
    //MainApp.order += selectedFood.asInstanceOf[Menu]
    //orderTable.items = MainApp.order
    //store the selected into the the order table
    //displayOrder()
    
  }
  
  
  def handleDelete (action : ActionEvent){
    val selected = orderTable.selectionModel().selectedItem.value
    orderTable.items().remove(selected)
    orderTable.selectionModel().clearSelection()
  }
  
  def handleClear (action : ActionEvent) {
    print("\nHello World")
    MainApp.order.clear()
    displayOrder()
  }
  
  
  def handleConfirm (action: ActionEvent){
    print("\nHello World\n")
    
    MainApp.showPrintReceipt()
    
    //to get sum of the total orders
    var sum : Double = 0.00
    for (items <- MainApp.order){
      sum += items.price.value.toDouble
    }
    //to print sum with 2 decimals
    print(f"$sum%.2f")
    
  }
  
  
  //method for displaying order
  def displayOrder() {
    for(items <- MainApp.order){
      print("\n"+items.name) //can remove when finalized
      orderName.cellValueFactory = {_.value.name}
      orderPrice.cellValueFactory= {_.value.price}
    }
  }
  
}//end of class
