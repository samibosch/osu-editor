package components

import utils.TimeStamp

/**
 * an old uninherited timing point
 * @param t: it's timestamp
 * @param BPM: the song's bpm
 * @param m: the meter
 * @param ss: the sample set
 * @param si: the sample index
 * @param vol: the volume
 * @param ki: kiai
 */
class Uninherited_legacy(t: TimeStamp, BPM: Double, m: Int, ss: Int, si: Int, vol: Int, ki: Boolean) extends TimingPoint_legacy(t, ss, si, vol, ki) {
  private var _bpm: Double = BPM
  private var _meter: Int = m

  // getters and setters

  def bpm: Double = _bpm

  def bpm_=(bpm: Double): Unit = _bpm = bpm

  def meter: Int = _meter

  def meter_=(m: Int): Unit = _meter = m

  def canEqual(a: Any): Boolean = a.isInstanceOf[Uninherited_legacy]

  override def equals(that: Any): Boolean = {
    that match {
      case that: Uninherited_legacy => that.canEqual(this) && this.time == that.time && this.bpm == that.bpm && this.meter == that.meter && this.sampleIndex == that.sampleIndex && this.sampleSet == that.sampleSet && this.volume == that.volume && this.kiai == that.kiai
      case _ => false
    }
  }
}
