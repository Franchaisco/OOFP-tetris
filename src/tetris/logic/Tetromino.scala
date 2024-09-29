package tetris.logic

abstract class Tetromino
{
  def rotateLeft(): Unit = ()
  def rotateRight(): Unit = ()

  def tetroParts: List[Point] = List[Point]()
  def anchorPoint: Point = null
}
class RotateCentral() extends Tetromino
class RotateI() extends Tetromino
class RotateO() extends Tetromino

case class TetrominoI() extends Tetromino {
  override def tetroParts: List[Point] = List[Point](Point(2, 1), Point(3, 1), Point(4, 1), Point(5, 1))

  override def anchorPoint: Point = tetroParts(tetroParts.length / 2)
}

case class TetrominoJ() extends Tetromino
case class TetrominoL() extends Tetromino
case class TetrominoO() extends Tetromino
case class TetrominoS() extends Tetromino
case class TetrominoT() extends Tetromino
case class TetrominoZ() extends Tetromino

