package ch.makery.address.model
import java.io._
import scalafx.collections.{ObservableBuffer}
import ch.makery.address.MainApp
object DrinkDao extends App{

  val pWriter = new PrintWriter(new File("drinks.csv"))
  
  
  def writeToFile(){
    
     val bw = new BufferedWriter(new FileWriter("drinks.csv"))
     for(items <- MainApp.drinks){
     var values = (items.menuId.value+","+items.name.value+","+items.price.value.toDouble+","+items.drinkType.value+" ")
     bw.write(s"$values \n")
     print(values)
  }
  bw.close()
    
  }
    

    def readFromCsv(){
     var price:Double = 0.00
     val bufferedSource = io.Source.fromFile("drinks.csv")
      for(line <- bufferedSource.getLines){
      val cols = line.split(",").map(_.trim)
      price=cols(2).toDouble
      new Food(cols(0),cols(1),price,cols(3))
      
    } 
      bufferedSource.close
    }
  
}
