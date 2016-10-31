
import scala.io.Source
import scala.xml._

object ParsedWdList {
  def main(args: Array[String]) {
    val words = Source.fromFile(args(0)).getLines.toVector.mkString.split("\\W+")
    val listOfWords = words.filterNot(_.isEmpty).distinct

  def lemmaForEntry (nseq: NodeSeq) = {
    if (nseq.size > 0) {
    nseq(0).text
   } else ""
 }

 def idForEntry (nseq: NodeSeq) = {
   if (nseq.size > 0) {
    nseq(0).text.replaceFirst("http://data.perseus.org/collections/urn:cite:perseus:latlexent.","")
  } else ""
}

def formatEntry(e: Elem) : String = {
  val uriGroup = e \ "@uri"
  val uri = idForEntry(uriGroup)
  val headwordList = e \\ "hdwd"
  val headword = lemmaForEntry (headwordList)
  uri + "_" + headword
}

def parsedWd (s: String) = {
  val baseUrl = "https://services.perseids.org/bsp/morphologyservice/analysis/word?&lang=lat&engine=morpheuslat&word="
  val requestUrl = baseUrl + s
  val replyText = scala.io.Source.fromURL(requestUrl).mkString

  val root = XML.loadString(replyText)
  val uniqueWords = root \\ "entry"

  val lexent = uniqueWords.map( e => e match {
   case el: Elem => formatEntry(el)
   case _ => ""
 } )
 lexent
}

listOfWords.map (w => (w, parsedWd(w)) )
}
}

ParsedWdList.main(args)
