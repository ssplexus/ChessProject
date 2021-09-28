/**
 * Абстрактный класс шахматной фигуры
 */
abstract public class ChessPiece
{
    // Цвет фигуры
    protected String color;
    // Параметр определяющий двигалась ли фигура
    protected boolean check;

    public ChessPiece(String color)
    {
        this.color = color;
        check = true;
    }

    abstract public String getColor();
    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    abstract public String getSymbol();
}
