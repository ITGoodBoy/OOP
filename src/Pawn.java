

public class Pawn extends ChessFigure {

    //inheritance and polymorphism
    public Pawn(boolean white, int positionX, int positionY, String image) {
        super(white, positionX, positionY, image);
    }

    //the logic of the movement of each figure depending on the color and type
    @Override
    public void move(int x, int y) {
        if (isWhite())
        {
            System.out.println("I'm white Pawn");
            System.out.println("my position x = " + y + " my position y = " + (7 - x));
        }

        else
        {
            System.out.println("I'm black Pawn");
            System.out.println("my position x = " + y + " my position y = " + (7 - x));
        }
    }
}
