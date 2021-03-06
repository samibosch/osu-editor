package utils

/**
 * A Hitsound instance represents the base hitsound of an object that is (ideally) always played on-hit, meaning on active
 * hit of a circle or slider and the finish of a spinner. sampleSet saves (normal, soft, drum) and the index the custom index.
 * @param s: the sample set (0-default, 1-normal. 2-soft, 3-drum)
 * @param i: the custom sample index
 */
class  Hitsound(s: Int = 0, i: Int = 0) {
  private var _sampleSet: Int = s                               // is normal, soft or drum
  private var _sampleIndex: Int = i                             // is [sampleSet]-hitnormal{index}

  def this(pos: (Int, Int)) = this(pos._1, pos._2)

  // getters and setters

  def sampleSet_=(s: Int): Unit = _sampleSet = s

  def sampleSet: Int = _sampleSet

  def sampleIndex_=(i: Int): Unit = _sampleIndex = i

  def sampleIndex: Int = _sampleIndex

  def canEqual(a: Any): Boolean = a.isInstanceOf[Hitsound]

  override def equals(that: Any): Boolean = {
    that match {
      case that: Hitsound => that.canEqual(this) && this.sampleSet == that.sampleSet && this.sampleIndex == that.sampleIndex
      case _ => false
    }
  }

  override def toString: String = "ss" + sampleSet + " si" + sampleIndex
}

object Hitsound {
  implicit def tupleToHitsound(hs: (Int, Int)): Hitsound = new Hitsound(hs._1, hs._2)
}
