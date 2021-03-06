package core

import components.{Circle, Inherited_legacy, Slider, Spinner, TimingPoint, Uninherited_legacy}
import utils.{Hitsound, Position, TimeStamp}

private class ObjectHandler() {
  private var _timestamp: TimeStamp = 0
  private var _endtimestamp: TimeStamp = 0
  private var _position: Position = (0, 0)
  private var _repeat: Int = 0
  private var _BPM: Double = 120.0
  private var _multiplier: Double = 1.0
  private var _sampleset: Int = 0
  private var _sampleindex: Int = 0
  private var _volume: Int = 100
  private var _kiai: Boolean = false
  private var _meterA: Int = 4
  private var _meterB: Int = 4
  private var _whistle: Boolean = false
  private var _finish: Boolean = false
  private var _clap: Boolean = false
  private var _additionsHitsound: Hitsound = new Hitsound()

  def timestamp: TimeStamp = _timestamp

  def timestamp_=(value: TimeStamp): Unit = {
    _timestamp = value
  }

  def endtimestamp: TimeStamp = _endtimestamp

  def endtimestamp_=(value: TimeStamp): Unit = {
    _endtimestamp = value
  }

  def position: Position = _position

  def position_=(value: Position): Unit = {
    _position = value
  }

  def repeat: Int = _repeat

  def repeat_=(value: Int): Unit = {
    _repeat = value
  }

  def BPM: Double = _BPM

  def BPM_=(value: Double): Unit = {
    _BPM = value
  }

  def multiplier: Double = _multiplier

  def multiplier_=(value: Double): Unit = {
    _multiplier = value
  }

  def sampleset: Int = _sampleset

  def sampleset_=(value: Int): Unit = {
    _sampleset = value
  }

  def sampleindex: Int = _sampleindex

  def sampleindex_=(value: Int): Unit = {
    _sampleindex = value
  }

  def volume: Int = _volume

  def volume_=(value: Int): Unit = {
    _volume = value
  }

  def kiai: Boolean = _kiai

  def kiai_=(value: Boolean): Unit = {
    _kiai = value
  }

  def meterA: Int = _meterA

  def meterA_=(value: Int): Unit = {
    _meterA = value
  }

  def meterB: Int = _meterB

  def meterB_=(value: Int): Unit = {
    _meterB = value
  }

  def hitsound: Hitsound = (sampleset, sampleindex)

  def hitsound_=(value: Hitsound): Unit = {
    sampleset = value.sampleSet
    sampleindex = value.sampleIndex
  }

  def whistle: Boolean = _whistle

  def whistle_=(value: Boolean): Unit = {
    _whistle = value
  }

  def finish: Boolean = _finish

  def finish_=(value: Boolean): Unit = {
    _finish = value
  }

  def clap: Boolean = _clap

  def clap_=(value: Boolean): Unit = {
    _clap = value
  }

  def additionsHitsound: Hitsound = _additionsHitsound

  def additionsHitsound_=(value: Hitsound): Unit = {
    _additionsHitsound = value
  }

  def Circle: Circle = {
    val c = new Circle(position, timestamp, hitsound)
    c.additions = Array(whistle, finish, clap)
    c.additionsHitsound = additionsHitsound
    c
  }

  def Slider: Slider = {
    val s = new Slider(position, timestamp, endtimestamp, multiplier, repeat, hitsound)
    s.additions = Array(whistle, finish, clap)
    s.additionsHitsound = additionsHitsound
    s
  }

  def Spinner: Spinner = {
    val s = new Spinner(timestamp, endtimestamp, hitsound)
    s.additions = Array(whistle, finish, clap)
    s.additionsHitsound = additionsHitsound
    s
  }

  def TimingPoint: TimingPoint = new TimingPoint(timestamp, BPM, meterA, meterB)

  def Inherited: Inherited_legacy = new Inherited_legacy(timestamp, multiplier, sampleset, sampleindex, volume, kiai)

  def Uninherited: Uninherited_legacy = new Uninherited_legacy(timestamp, BPM, meterA, sampleset, sampleindex, volume, kiai)
}

object ObjectHandler {
  private val handler: ObjectHandler = new ObjectHandler()

  def timestamp: TimeStamp = handler.timestamp

  def MakeTimeStamp(value: Int): TimeStamp = new TimeStamp(value)

  def timestamp_=(value: TimeStamp): Unit = handler.timestamp = value

  def endtimestamp: TimeStamp = handler.endtimestamp

  def endtimestamp_=(value: TimeStamp): Unit = handler.endtimestamp = value

  def position: Position = handler.position

  def MakePosition(x: Int, y: Int): Position = new Position(x, y)

  def MakePosition(pos: (Int, Int)): Position = new Position(pos)

  def position_=(value: Position): Unit = handler.position = value

  def repeat: Int = handler.repeat

  def repeat_=(value: Int): Unit = handler.repeat = value

  def BPM: Double = handler.BPM

  def BPM_=(value: Double): Unit = handler.BPM = value

  def bpm: Double = handler.BPM

  def bpm_=(value: Double): Unit = handler.BPM = value

  def multiplier: Double = handler.multiplier

  def multiplier_=(value: Double): Unit = handler.multiplier = value

  def sampleset: Int = handler.sampleset

  def sampleset_=(value: Int): Unit = handler.sampleset = value

  def sampleindex: Int = handler.sampleindex

  def sampleindex_=(value: Int): Unit = handler.sampleindex = value

  def volume: Int = handler.volume

  def volume_=(value: Int): Unit = handler.volume = value

  def kiai: Boolean = handler.kiai

  def kiai_=(value: Boolean): Unit = handler.kiai = value

  def meterA: Int = handler.meterA

  def meterA_=(value: Int): Unit = handler.meterA = value

  def meterB: Int = handler.meterB

  def meterB_=(value: Int): Unit = handler.meterB = value

  def hitsound: Hitsound = handler.hitsound

  def hitsound_=(value: Hitsound): Unit = handler.hitsound = value

  def whistle: Boolean = handler.whistle

  def whistle_=(value: Boolean): Unit = handler.whistle = value

  def finish: Boolean = handler.finish

  def finish_=(value: Boolean): Unit = handler.finish = value

  def clap: Boolean = handler.clap

  def clap_=(value: Boolean): Unit = handler.clap = value

  def additionsHitsound: Hitsound = handler.additionsHitsound

  def additionsHitsound_=(value: Hitsound): Unit = handler.additionsHitsound = value

  def MakeHitsound(ss: Int = 0, si: Int = 0): Hitsound = new Hitsound(ss, si)

  def MakeHitsound(pos: (Int, Int)): Hitsound = new Hitsound(pos)

  def MakeHitsound: Hitsound = new Hitsound()

  def MakeCircle: Circle = handler.Circle

  def MakeSlider: Slider = handler.Slider

  def MakeSpinner: Spinner = handler.Spinner

  def MakeTimingPoint: TimingPoint = handler.TimingPoint

  def MakeInherited: Inherited_legacy = handler.Inherited

  def MakeUninherited: Uninherited_legacy = handler.Uninherited

  def MakeCircle(p: Position = null, t: TimeStamp = null, hs: Hitsound = null): Circle = {
    if (p != null)
      position = p
    if (t != null)
      timestamp = t
    if (hs != null)
      hitsound = hs
    MakeCircle
  }

  def MakeSlider(p: Position = null, t: TimeStamp = null, et: TimeStamp = null, v: Double = -1, r: Int = -1, hs: Hitsound = null): Slider = {
    if (p != null)
      position = p
    if (t != null)
      timestamp = t
    if (et != null)
      endtimestamp = et
    if (v >= 0)
      multiplier = v
    if (r >= 0)
      repeat = r
    if (hs != null)
      hitsound = hs
    MakeSlider
  }

  def MakeSpinner(t: TimeStamp = null, et: TimeStamp = null, hs: Hitsound = null): Spinner = {
    if (t != null)
      timestamp = t
    if (et != null)
      endtimestamp = et
    if (hs != null)
      hitsound = hs
    MakeSpinner
  }

  def MakeTimingPoint(t: TimeStamp = null, b: Double = -1, m1: Int = -1, m2: Int = -1): TimingPoint = {
    if (t != null)
      timestamp = t
    if (b >= 0)
      BPM = b
    if (m1 >= 0)
      meterA = m1
    if (m2 >= 0)
      meterB = m2
    MakeTimingPoint
  }

  def MakeInherited(t: TimeStamp = null, multi: Double = -1, ss: Int = -1, si: Int = -1, vol: Int = -1, ki: Boolean = kiai): Inherited_legacy = {
    if (t != null)
      timestamp = t
    if (multi >= 0)
      multiplier = multi
    if (ss >= 0)
      sampleset = ss
    if (si >= 0)
      sampleindex = si
    if (vol >= 0)
      volume = vol
    if (ki != kiai)
      kiai = ki
    MakeInherited
  }

  def MakeUninherited(t: TimeStamp = null, b: Double = -1, m: Int = -1, ss: Int = -1, si: Int = -1, vol: Int = -1, ki: Boolean = kiai): Uninherited_legacy = {
    if (t != null)
      timestamp = t
    if (b >= 0)
      BPM = b
    if (m >= 0)
      meterA = m
    if (ss >= 0)
      sampleset = ss
    if (si >= 0)
      sampleindex = si
    if (vol >= 0)
      volume = vol
    if (ki != kiai)
      kiai = ki
    MakeUninherited
  }
}