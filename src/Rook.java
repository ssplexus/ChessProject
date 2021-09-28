/**
 * Класс фигуры "ладья"
 */
public class Rook extends ChessPiece
{
    public Rook(String color)
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

        if(toLine == line) // Если движение по горизонтали
        {
            if(column < toColumn)
            {
                for (int j = column + 1; j < toColumn; j++)
                {
                    if(chessBoard.board[line][j] != null) return false;
                }
            }
            else
            {
                for (int j = column - 1; j > toColumn; j--)
                {
                    if(chessBoard.board[line][j] != null) return false;
                }
            }

            if(chessBoard.board[toLine][toColumn] != null) // Если на конечной позиции есть фигура
            {
                if(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())) // Если это не вражеская фигура то ход невозможен
                    return false;
            }
            return true;
        }
        if(toColumn == column) // Если движение по вертикали
        {
            if(line < toLine)
            {
                for (int i = line + 1; i < toLine; i++)
                {
                    if(chessBoard.board[i][column] != null) return false;
                }
            }
            else
            {
                for (int i = line - 1; i > toLine; i--)
                {
                    if(chessBoard.board[i][column] != null) return false;
                }
            }

            if(chessBoard.board[toLine][toColumn] != null) // Если на конечной позиции есть фигура
            {
                if(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())) // Если это не вражеская фигура то ход невозможен
                    return false;
            }
            return true;
        }

        return false;
    }

    /**
     * Метод получения символьного обозначения фигуры
     * @return символьное обозначение фигуры
     */
    public String getSymbol()
    {
        return "R";
    }
}
