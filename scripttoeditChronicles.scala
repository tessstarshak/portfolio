
import scala.io.Source
val uneditedtxt = Source.fromFile("EditedWithoutHeadingsandNumbers.txt").getLines.toVector.mkString
val allwords = uneditedtxt.split("\\W+")
val words = allwords.filterNot(_.isEmpty)

allwords.replaceAll("""[\p{Punct}&&[^.,!?]""", "")
//have to map strings first

map( l => l.replaceFirst("- $", "") ).mkString
