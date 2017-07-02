package ch.makery.address.view

import ch.makery.address.MainApp

import scalafxml.core.macros.sfxml
import scalafx.stage.Stage
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label,TableColumn}

@sfxml
class OrderMenuController {
  
  def handleBack (action: ActionEvent){
    MainApp.showMainPage
  }
  
  //alert box to add the quantity
  def handleAdd (action : ActionEvent){ 
  }
  
  
  def handleDelete (action : ActionEvent){
  }
  
  
  def handleConfirm (action: ActionEvent){
  }
  
}//end of class
