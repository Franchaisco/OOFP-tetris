package tetris.logic

abstract class Tetromino
{
  def rotateLeft(): Unit.type = Unit
  def rotateRight(): Unit.type = Unit
}
class RotateCentral() extends Tetromino
class RotateI() extends Tetromino
class RotateO() extends Tetromino

case class TetrominoI() extends Tetromino
case class TetrominoJ() extends Tetromino
case class TetrominoL() extends Tetromino
case class TetrominoO() extends Tetromino
case class TetrominoS() extends Tetromino
case class TetrominoT() extends Tetromino
case class TetrominoZ() extends Tetromino

