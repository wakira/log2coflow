package log2coflow
import log2coflow.lineparser.common.{ParsedLogLine, ContainerInfoLine, LogLineMatcher}
import log2coflow.lineparser.mapreduce.AttemptAssignmentLine

/**
 * Created by wakira on 15-7-15.
 */

class YarnMapReduceLogParser(input : Iterator[String]) extends LogParser(input) {
  // FIXME add reducer fetch matcher as well
  final val lineMatchers : List[LogLineMatcher] = List(ContainerInfoLine, AttemptAssignmentLine)

  def processLine(l : String) = {
    val parsedLine = tryMatchers(lineMatchers, l)
    // TODO call coflow builder on parsedLine
  }
}
