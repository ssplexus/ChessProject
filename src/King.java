/**
 * Класс фигуры "король"
 */
public class King extends ChessPiece
{
    public King(String color)
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

        // Если разность линий и столбцов по модулю меньше или равна 1
        if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1)
        {
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
     * Метод проверки находится ли заданная позиция под атакой
     * @param chessBoard
     * @param line
     * @param column
     * @return возвращает результат проверки да или нет
     */
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(chessBoard.board[i][j] != null)
                {
                    if(chessBoard.nowPlayerColor().equals("White") && chessBoard.board[i][j].getColor().equals("Black"))
                    {
                        if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i , j, line, column))
                            return true;
                    }
                }
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
        return "K";
    }
}
