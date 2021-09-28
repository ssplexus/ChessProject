/**
 * Класс фигуры "конь"
 */
public class Horse extends ChessPiece
{
    public Horse(String color)
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

        // Класс позиции шахматной доски
        class ChessPos
        {
            int line,col;
            ChessPos(int line, int col)
            {
                setPos(line,col);
            }
            void setPos(int line, int col)
            {
                this.line = line;
                this.col = col;
            }
            boolean equals(int line, int col)
            {
                return line == this.line && col == this.col;
            }
        }

        // Массив для хранения позиций возможных движений коня
        ChessPos horseMoves[] = new ChessPos[8];

        horseMoves[0] = new ChessPos(line - 2, column + 1);
        horseMoves[1] = new ChessPos(line - 1, column + 2);
        horseMoves[2] = new ChessPos(line + 2, column + 1);
        horseMoves[3] = new ChessPos(line + 1, column + 2);
        horseMoves[4] = new ChessPos(line + 2, column - 1);
        horseMoves[5] = new ChessPos(line + 1, column - 2);
        horseMoves[6] = new ChessPos(line - 2, column - 1);
        horseMoves[7] = new ChessPos(line - 1, column - 2);

        // Обход массива и сравнение возможных позиций
        for(ChessPos hm: horseMoves)
        {
            if(hm.equals(toLine, toColumn))
            {
                if(chessBoard.board[toLine][toColumn] != null) // Если на конечной позиции есть фигура
                {
                    if(chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.nowPlayerColor())) // Если это не вражеская фигура то ход невозможен
                        return false;
                }
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
        return "H";
    }
}
