package ch.makery.address.view
import scalafx.Includes._
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class MainPageController {
  
  //leads to login page
  def handleManageMenu(action : ActionEvent)={
    MainApp.showLoginPage
  }
  
  def handleOrder(action : ActionEvent)={
    MainApp.showOrderMenu
  }
  
}// end of class

