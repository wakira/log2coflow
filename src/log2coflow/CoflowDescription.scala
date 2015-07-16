package log2coflow

/**
 * Created by wakira on 15-7-15.
 */
class CoflowDescription(val flows: List[FlowDescription]) {
  // build node information from flows
  val nodes : Set[String] = {
    val nodes_setup = new scala.collection.mutable.HashSet[String]()
    flows.foreach(flow => {nodes_setup += flow.dest; nodes_setup += flow.source})
    nodes_setup.toSet // convert back to immutable
  }

  val length = flows.maxBy(_.size)
  val width = flows.length
  val size = flows.foldLeft(0)((acc, f) => acc + f.size)
}
