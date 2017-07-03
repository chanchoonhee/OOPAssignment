package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.view.{AddAndEditFoodMenuController, AddAndEditDrinksMenuController}
import scalafx.stage.{ Stage, Modality }
import ch.makery.address.model.{Food,Drinks,Menu,DrinkDao,FoodDao}


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
  
   //shows the manage menu page
  def showManageMenuPage() = {
    val resource = getClass.getResource("view/ManageMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  
  //shows the manage menu page
  def showLoginPage() = {
    val resource = getClass.getResource("view/Login.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  
  //shows the order menu
  def showOrderMenu() = {
    val resource = getClass.getResource("view/OrderMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  
  def showAddAndEditFoodMenu() = {
    val resource = getClass.getResource("view/AddAndEditDrinksMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  
  def showAddAndEditDrinksMenu() = {
    val resource = getClass.getResource("view/AddAndEditDrinksMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  
  def showAddMenu() = {
    val resource = getClass.getResource("view/AddMenu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  
//   call to display MainPage when app start
  showMainPage()
  

  

  
}
