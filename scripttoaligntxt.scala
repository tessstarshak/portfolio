import scala.io.Source

def matchingwds(s: String, parsedList: Vector[Array[String]] ) = {
    val parsed = parsedList.filter(_(0) == s)
    if (parsed.size == 0) {
      s
    } else {
      parsed.map(_(1)).mkString(",")
    }
  }

  val text = Source.fromFile("EditedWithoutDashes.txt").getLines.toVector.mkString
  val textChunks = text.split("§")
  val newText= textChunks.filterNot(_.isEmpty)
  val numbChunks = textChunks.zipWithIndex

  val chunks = numbChunks.map(_._1)
  val reff = numbChunks.map(_._2)

  val parsedList = Source.fromFile("parsingresultsChronofRichI.txt").getLines.toVector
  val listWds = parsedList.map(_.split("\t")).filter(_.size == 2 )

  val list = chunks.map { s =>
    val wds = s.split("\\W").filterNot(_.isEmpty)
    wds.map ( w => matchingwds(w,listWds) ).mkString(" ")
  }

  for (chnk <- list) {
    println(chnk)
  }
