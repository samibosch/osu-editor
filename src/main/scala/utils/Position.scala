package utils

/**
 * a pixel position on screen
 * @param pos1: the x pixel
 * @param pos2: the y pixel
 */
class Position(pos1: Int, pos2: Int) {
  private var _pos_x: Int = pos1
  private var _pos_y: Int = pos2

  def this(pos: (Int, Int)) = this(pos._1, pos._2)

  // getters and setters

  def x: Int = _pos_x

  def y: Int = _pos_y

  private def _pos: (Int, Int) = (_pos_x, _pos_y)

  def x_=(x: Int): Unit = _pos_x = x

  def y_=(y: Int): Unit = _pos_y = y

  def canEqual(a: Any): Boolean = a.isInstanceOf[Position]

  override def equals(that: Any): Boolean = {
    that match {
      case that: Position => that.canEqual(this) && this._pos_x == that._pos_x && this._pos_y == that._pos_y
      case _ => false
    }
  }

  override def toString: String = "x" + x + " y" + y
}

// conversion to tuple
object Position {
  implicit def tupleToPosition(pos: (Int, Int)): Position = new Position(pos)

  implicit def positionToTuple(pos: Position): (Int, Int) = pos._pos
}