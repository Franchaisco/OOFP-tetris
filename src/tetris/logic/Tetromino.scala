package tetris.logic

abstract class Tetromino
{
  def rotateLeft(tetroParts : List[Point], anchorPoint : Point): List[Point] = List[Point]()
  def rotateRight(tetroParts : List[Point], anchorPoint : Point): List[Point] = List[Point]()

  def tetroParts: List[Point] = List[Point]()
  def anchorPoint: Point = null
}
class TetroCentral extends Tetromino
{
  override def rotateLeft(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    val newParts = tetroParts.map { i =>
      val difX = i.x - anchorPoint.x
      val difY = i.y - anchorPoint.y

      Point(anchorPoint.x + difY, anchorPoint.y - difX)
    }

    newParts
  }
  override def rotateRight(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    val newParts = tetroParts.map { i =>
      val difX = i.x - anchorPoint.x
      val difY = i.y - anchorPoint.y

      Point(anchorPoint.x - difY, anchorPoint.y + difX)
      }
    newParts
  }
}
class TetroI() extends Tetromino
{
  override def rotateLeft(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    val newParts = tetroParts.map { i =>
      val difX = i.x - anchorPoint.x
      val difY = i.y - anchorPoint.y

      Point(anchorPoint.x + difY, anchorPoint.y - difX )
    }
    newParts
  }
  override def rotateRight(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    val newParts = tetroParts.map { i =>
      val difX = i.x - anchorPoint.x
      val difY = i.y - anchorPoint.y

      Point(anchorPoint.x - difY + 1, anchorPoint.y + difX)
    }
    newParts
  }
}
class TetroO() extends Tetromino
{
  override def rotateLeft(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    tetroParts
  }
  override def rotateRight(tetroParts : List[Point], anchorPoint : Point): List[Point] = {
    tetroParts
  }
}

case class TetrominoI(gridWidth : Int) extends TetroI {
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, anchorPoint.y),
    Point(anchorCol, anchorPoint.y), Point(anchorCol + 1, anchorPoint.y), Point(anchorCol + 2, anchorPoint.y))
}

case class TetrominoJ(gridWidth : Int) extends TetroCentral
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, 1),
    Point(anchorCol, 1), Point(anchorCol + 1, 1), Point(anchorCol - 1, 0))
}
case class TetrominoL(gridWidth : Int) extends  TetroCentral
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, 1),
    Point(anchorCol, 1), Point(anchorCol + 1, 1), Point(anchorCol + 1, 0))
}

case class TetrominoO(gridWidth : Int) extends TetroO
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol, 0),
    Point(anchorCol, 1), Point(anchorCol + 1, 1), Point(anchorCol + 1, 0))
}
case class TetrominoS(gridWidth : Int) extends  TetroCentral
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, 1),
    Point(anchorCol, 1), Point(anchorCol, 0), Point(anchorCol + 1, 0))
}
case class TetrominoT(gridWidth : Int) extends TetroCentral
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, 1),
    Point(anchorCol, 1), Point(anchorCol, 0), Point(anchorCol + 1, 1))
}
case class TetrominoZ(gridWidth : Int) extends  TetroCentral
{
  private val anchorCol : Int = if(gridWidth % 2 == 0) gridWidth / 2 - 1 else gridWidth / 2
  override def anchorPoint: Point = Point(anchorCol, 1)
  override def tetroParts: List[Point] = List[Point](Point(anchorCol - 1, 0), Point(anchorCol, 1),
    Point(anchorCol, 0), Point(anchorCol + 1, 1))
}

