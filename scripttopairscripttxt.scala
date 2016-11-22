
import scala.io.Source


def matchingwds(s: String, parsedList: Array[Array[String]] ) = {
    val parsed = parsedList.filter(_._1 == s)
    if (parsed.size == 0) {
      s
    } else {
      parsed.map(_._2).mkString(",")
    }

  }

//object aligningtext {
  val text = Source.fromFile("EditedWithoutDashes.txt").getLines.toVector.mkString
  val textChunks = text.split("§")
  val newText= textChunks.filterNot(_.isEmpty)
  val numbChunks = textChunks.zipWithIndex

  val chunks = numbChunks.map(_._1)
  val reff = numbChunks.map(_._2)
  val wds = chunks.mkString

  val parsedList = Source.fromFile("parsingresultsChronofRichI.txt").getLines.toVector
  val listWds = parsedList.map(_.split("\t")).filter(_.size == 2 )



for (words <- wds) {
  val list = words.split("//W").filterNot(_.isEmpty)
  val parsing = list.map { w => matchingwds(w, listWds)}
  println(parsing.mkString(" "))
}
//}
