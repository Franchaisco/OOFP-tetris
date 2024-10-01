package tetris.logic

import engine.random.{RandomGenerator, ScalaRandomGen}
import tetris.logic.TetrisLogic._

/** To implement Tetris, complete the ``TODOs`` below.
 *
 * If you need additional files,
 * please also put them in the ``tetris`` package.
 */
class TetrisLogic(val randomGen: RandomGenerator,
                  val gridDims : Dimensions,
                  val initialBoard: Seq[Seq[CellType]]) {

  def this(random: RandomGenerator, gridDims : Dimensions) =
    this(random, gridDims, makeEmptyBoard(gridDims))

  def this() =
    this(new ScalaRandomGen(), DefaultDims, makeEmptyBoard(DefaultDims))

  private val tetrominoList =
    List[Tetromino](TetrominoI(gridDims.width), TetrominoJ(gridDims.width), TetrominoL(gridDims.width),
      TetrominoO(gridDims.width), TetrominoS(gridDims.width), TetrominoT(gridDims.width),
      TetrominoZ(gridDims.width))
  private val initialTetromino: Tetromino = generateTetromino()
  private val initialFrame: Frame = Frame(initialTetromino, initialTetromino.tetroParts)
  private var frameList: List[Frame] = List[Frame](initialFrame)

  private def setCurFrame() : Frame = {
    frameList.head
  }

  def rotateLeft(): Unit = {
    val curFrame = setCurFrame()
    val anchorPoint = getAnchorPoint
    val newTetroParts = curFrame.curTetromino.rotateLeft(curFrame.tetroParts, anchorPoint)
    val newFrame = Frame(curFrame.curTetromino, newTetroParts)
    frameList = newFrame :: frameList
  }
  private def getAnchorPoint: Point = {
    val curParts = setCurFrame().tetroParts

    curParts(1)
  }

  def rotateRight(): Unit = {
    val curFrame = setCurFrame()
    val anchorPoint = getAnchorPoint
    val newTetroParts = curFrame.curTetromino.rotateRight(curFrame.tetroParts, anchorPoint)
    val newFrame = Frame(curFrame.curTetromino, newTetroParts)
    frameList = newFrame :: frameList
  }

  // TODO implement me
  def moveLeft(): Unit = {
    val curFrame = setCurFrame()
    val newTetroParts = createNewParts(curFrame.tetroParts, Point(-1, 0))
    val newFrame = Frame(curFrame.curTetromino, newTetroParts)
    frameList = newFrame :: frameList
  }

  private def generateTetromino() : Tetromino = {
    tetrominoList(randomGen.randomInt(tetrominoList.length))
  }

  // TODO implement me
  def moveRight(): Unit = {
    val curFrame = setCurFrame()
    val newTetroParts = createNewParts(curFrame.tetroParts, Point(1, 0))
    val newFrame = Frame(curFrame.curTetromino, newTetroParts)
    frameList = newFrame :: frameList
  }

  private def createNewParts(tetroParts : List[Point], toPoint : Point) : List[Point] = {
    var newTetroParts = List[Point]()
    for(i <- tetroParts){
      newTetroParts = Point(i.x + toPoint.x, i.y + toPoint.y) :: newTetroParts
    }
    newTetroParts
  }

  // TODO implement me
  def moveDown(): Unit = {
    val curFrame = setCurFrame()
    val newTetroParts = createNewParts(curFrame.tetroParts, Point(0, 1))
    val newFrame = Frame(curFrame.curTetromino, newTetroParts)
    frameList = newFrame :: frameList
  }

  // TODO implement me
  def doHardDrop(): Unit = ()

  // TODO implement me
  def isGameOver: Boolean = false

  private def getTetromino: CellType = {
    setCurFrame().curTetromino match  {
      case TetrominoI(gridDims.width) => ICell
      case TetrominoJ(gridDims.width) => JCell
      case TetrominoL(gridDims.width) => LCell
      case TetrominoO(gridDims.width) => OCell
      case TetrominoS(gridDims.width) => SCell
      case TetrominoT(gridDims.width) => TCell
      case TetrominoZ(gridDims.width) => ZCell
    }
  }

  // TODO implement me
  def getCellType(p : Point): CellType =
  {
    if(setCurFrame().tetroParts.contains(p))
      {
          getTetromino
      }
    else
      {
        Empty
      }
  }


}

case class Frame(curTetromino : Tetromino, tetroParts : List[Point])
{

}

object TetrisLogic {

  val FramesPerSecond: Int = 5 // change this to speed up or slow down the game

  val DrawSizeFactor = 1.0 // increase this to make the game bigger (for high-res screens)
  // or decrease to make game smaller



  def makeEmptyBoard(gridDims : Dimensions): Seq[Seq[CellType]] = {
    val emptyLine = Seq.fill(gridDims.width)(Empty)
    Seq.fill(gridDims.height)(emptyLine)
  }


  // These are the dimensions used when playing the game.
  // When testing the game, other dimensions are passed to
  // the constructor of GameLogic.
  //
  // DO NOT USE the variable DefaultGridDims in your code!
  //
  // Doing so will cause tests which have different dimensions to FAIL!
  //
  // In your code only use gridDims.width and gridDims.height
  // do NOT use DefaultDims.width and DefaultDims.height


  val DefaultWidth: Int = 10
  val NrTopInvisibleLines: Int = 4
  val DefaultVisibleHeight: Int = 20
  val DefaultHeight: Int = DefaultVisibleHeight + NrTopInvisibleLines
  val DefaultDims : Dimensions = Dimensions(width = DefaultWidth, height = DefaultHeight)


  def apply() = new TetrisLogic(new ScalaRandomGen(),
    DefaultDims,
    makeEmptyBoard(DefaultDims))

}