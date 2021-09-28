/**
 * Класс фигуры "пешка"
 */
public class Pawn extends ChessPiece
{
    public Pawn(String color)
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
        if(line == toLine && column == toColumn || // Если позиция не изменилась
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) // или выходим за доску
            return false;

        if(chessBoard.nowPlayerColor() == "White")
        {
            // Проверка возможен ли ход на 1 клетку
            if(line + 1 == toLine && column == toColumn && chessBoard.board[toLine][toColumn] == null) return true;

            // Проверка возможен ли ход на 2 клетки
            if(line + 2 == toLine && column == toColumn && line == 1 &&
                    chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine - 1][toColumn] == null)
                return true;

            // Проверка возможна ли атака
            if((toLine == line + 1 && toColumn == column + 1) || (toLine == line + 1 && toColumn == column - 1) &&
                    chessBoard.board[toLine][toColumn] != null &&
                    !chessBoard.nowPlayerColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            {
                return true;
            }
        }
        else
        {
            // Проверка возможен ли ход на 1 клетку
            if(line - 1 == toLine && column == toColumn && chessBoard.board[toLine][toColumn] == null) return true;

            // Проверка возможен ли ход на 2 клетки
            if(line - 2 == toLine && column == toColumn && line == 6 &&
                    chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine + 1][toColumn] == null)
                return true;

            // Проверка возможна ли атака
            if((toLine == line - 1 && toColumn == column + 1) || (toLine == line - 1 && toColumn == column - 1) &&
                    chessBoard.board[toLine][toColumn] != null &&
                    !chessBoard.nowPlayerColor().equals(chessBoard.board[toLine][toColumn].getColor()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод получения символьного обозначения фигуры
     * @return символьное обозначение фигуры
     */
    public String getSymbol()
    {
        return "P";
    }
}
