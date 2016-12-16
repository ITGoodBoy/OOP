

public class Queen extends ChessFigure {

    //inheritance and polymorphism
    public Queen(boolean white, int positionX, int positionY, String image) {
        super(white, positionX, positionY, image);
    }
    // the logic of the movement of each figure depending on the color and type
    @Override
    public void move(int x, int y) {
        if (isWhite())
        {
            System.out.println("I'm white Queen");
            System.out.println("my position x = " + y + " my position y = " + (7 - x));
        }

        else
        {
            System.out.println("I'm black Queen");
            System.out.println("my position x = " + y + " my position y = " + (7 - x));
        }
    }
}
