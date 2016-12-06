
import scala.collection.mutable.ListBuffer
import scala.io.Source

def ngram(n: Int, s: String) = {
  val letters = s.toList
  val threeslideList = letters.sliding(n).toList
  threeslideList.map(_.mkString(""))
}

def nextNgram(s: String, wordlist: Array[String]) = {
  val n = s.size
   val longwords = wordlist.filter(_.size > n)
   val ngramList = longwords.map(w => ngram(n,w))
   val matchingLists =  ngramList.filter(_.contains(s))
   val fullword = matchingLists.map(_.sliding(n)).toVector.mkString("")

   for (flwd <- fullword) {
     println(flwd)
   }

   var nextN = new ListBuffer[String]()
   for (mtch <- matchingLists) {
     val idx = mtch.indexOf(s)
     val nextIndex = idx + 1
     if (nextIndex < mtch.size) {
        nextN += mtch(nextIndex)
     } else {
       //
     }
   }
   nextN
 }

 //val words = Source.fromFile("EntireWordList.txt").getLines.mkString
// s is string to search for
//
object ngram {
def main(args: Array[String]) = {
  val s = args(0)
  val lns = Source.fromFile("EntireWordList.txt").getLines.toVector.mkString
  val words = lns.split("\\W").filterNot(_.isEmpty).map(w => "^" + w + "#")

  val fullwords = words.


  val results = nextNgram(s,words)
  println("Testing ngram searching!")
  println("Searching for n-gram: " + s)
  println("Number possible next ngrams: " + results.size)
  val grouped = results.groupBy(w => w)
  val counts = grouped.map { case (k,v) => (k,v.size) }
  for (cnt <- counts) {
    println(cnt)
  }
  }
}

ngram.main(args)



//save into another text file?
