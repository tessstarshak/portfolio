import scala.io.Source

val text = Source.fromFile("EditedWithoutDashes.txt").getLines.mkString.split("\\W").filterNot(_.isEmpty)
val smallwords = text.map(_.toLowerCase)
val words = smallwords.toVector.mkString(",")

println(words)

val textTwo = Source.fromFile("WilliamofTyreUneditedTxt.txt").getLines.mkString.split("\\W").filterNot(_.isEmpty)
val moreSmallWords = textTwo.map(_.toLowerCase)
val wordsTwo = moreSmallWords.toVector.mkString(",")


println(wordsTwo)
