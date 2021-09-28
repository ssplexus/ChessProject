/**
 * Класс фигуры "королева"
 */
public class Queen extends ChessPiece
{
    public Queen(String color)
    {
        super(color);
    }

    /**
     * Получение цвета фигуры
     * @return цвет фигуры
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Метод проверки возможности хода для фигуры
     * @param chessBoard
     * @param line
     * @param column
     * @param toLine
     * @param toColumn
     * @return результат проверки
     */
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn)
    {
        /* Королева может ходить как "ладья" и как "слон"
         создадим их объекты и используем их методы проверки
        */
        Bishop b = new Bishop(chessBoard.nowPlayerColor());
        Rook r = new Rook(chessBoard.nowPlayerColor());

        if(b.canMoveToPosition(chessBoard, line, column, toLine, toColumn) ||
           r.canMoveToPosition(chessBoard, line, column, toLine, toColumn))
            return true;

        return false;
    }

    /**
     * Метод получения символьного обозначения фигуры
     * @return символьное обозначение фигуры
     */
    public String getSymbol()
    {
        return "Q";
    }
}
