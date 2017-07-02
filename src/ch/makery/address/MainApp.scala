package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.model.{Food,Drinks,DrinkDao,FoodDao}


object MainApp extends JFXApp {
  var drinks = ObservableBuffer[Drinks]()
  var food = new ObservableBuffer[Food]()
   

  // transform path of RootLayout.fxml to URI for resource location.
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initialize the loader object.
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Load root layout from fxml file.
  loader.load();

  // retrieve the root component BorderPane from the FXML 
  val roots = loader.getRoot[jfxs.layout.BorderPane]
   DrinkDao.readFromCsv()
   FoodDao.readFromCsv()
  DrinkDao.writeToFile()
  FoodDao.writeToFile()
  // initialize stage
  stage = new PrimaryStage {
    title = "Restaurant POS System" 
    scene = new Scene {
      root = roots    
     
    }
  }
  // actions for display Main page window 
  def showMainPage() = {
    val resource = getClass.getResource("view/MainPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  } 
  
  def showManageMenuPage() = {
    val resource = getClass.getResource("view/ManageMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
//   call to display MainPage when app start
  showMainPage()
  

  

  
}
