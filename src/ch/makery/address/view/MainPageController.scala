package ch.makery.address.view
import scalafx.Includes._
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MainPageController {
  def handleManageMenu(action : ActionEvent)={
    MainApp.showManageMenuPage
  }
  
  def handleExit(action : ActionEvent)={
    
  }
  
  def handleOrder(action : ActionEvent)={
    
  }
}// end of class

