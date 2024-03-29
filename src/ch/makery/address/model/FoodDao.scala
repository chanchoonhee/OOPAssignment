package ch.makery.address.model
import java.io._
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.MainApp
object FoodDao extends App{

  val pWriter = new PrintWriter(new File("Food.csv"))
  
  
  def writeToFile(){
    
     val bw = new BufferedWriter(new FileWriter("Food.csv"))
     for(items <- MainApp.food){
     var values = (items.menuId.value+","+items.name.value+","+items.price.value.toDouble+","+items.cuisine.value+" ")
     bw.write(s"$values \n")
     print(values)
  }
  bw.close()
    
  }
    

    def readFromCsv(){
      var price:Double = 0.00
      val bufferedSource = io.Source.fromFile("Food.csv")
      for(line <- bufferedSource.getLines){
      val cols = line.split(",").map(_.trim)
      price=cols(2).toDouble
      MainApp.food += new Food(cols(0),cols(1),price,cols(3))
      
    } 
      bufferedSource.close
    }
  
}