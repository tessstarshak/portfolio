
import scala.io.Source

object greeting { println("Hello world!") }

object Zipf {
  def main(args: Array[String]) {
val lines = Source.fromFile(args(0)).getLines.toVector.mkString
val allwords = lines.split("\\W+")
val words = allwords.filterNot(_.isEmpty)
words.groupBy(w => w.charAt(0))
val groupedWords = words.groupBy (w => w)
val wordfreqs = groupedWords.map { case (k,v) => (k,v.size) }
val orderedFreqs = wordfreqs.toSeq
val sorted = orderedFreqs.sortBy(_._2)
for (kvpair <- sorted) { println(kvpair) }
}
}
Zipf.main(args)
