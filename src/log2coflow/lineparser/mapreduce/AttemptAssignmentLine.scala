package log2coflow.lineparser.mapreduce
import log2coflow.lineparser.common.{LogLineMatcher, ParsedLogLine}

/**
 * Created by wakira on 15-7-15.
 */
object AttemptAssignmentLine extends LogLineMatcher{
  final val regex = "".r // FIXME fill in the regex
  override def matches(s : String) = s match {
    case regex(container, attempt) => Some(new AttemptAssignmentLine(container, attempt))
    case _ => None
  }

  // a quick unit test
  def main (args: Array[String]) {
    // FIXME use correct example log line
    val s = AttemptAssignmentLine.matches("Container: container_1436860055866_0006_01_000001 on controller_46119")
    s match {
      case Some(AttemptAssignmentLine(c, a)) => println(c + " " + a)
      case None => println("NG")
    }
    val s2 = AttemptAssignmentLine.matches("Pontiner: container_1436860055866_0006_01_000001 on controller_46119")
    s2 match {
      case Some(AttemptAssignmentLine(c, a)) => println(c + " " + a)
      case None => println("NG")
    }
  }
}

case class AttemptAssignmentLine(container: String, attempt: String) extends ParsedLogLine
