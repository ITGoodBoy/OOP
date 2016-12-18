import javax.swing.*;
import java.awt.*;

public abstract class ChessFigure  {
//encapsulation

    private boolean white;
    private int positionX;
    private int positionY;
    private ImageIcon image;

    public ChessFigure(boolean white, int positionX, int positionY, String image) {
        this.white = white;
        if (positionX < 0 || positionX > 7 || positionY < 0 || positionY > 7)
        {
           error();
        }
        this.positionX = positionX;
        this.positionY = positionY;
        Image img = new ImageIcon(getClass().getResource("resources/" + image)).getImage().getScaledInstance(35, 50, Image.SCALE_DEFAULT);
        this.image = new ImageIcon(img);
    }

    public abstract void move(int positionX, int positionY);

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        if (positionX < 0 || positionX > 7)
        {
            error();
        }
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        if (positionY < 0 || positionY > 7)
        {
            error();
        }
        this.positionY = positionY;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    private void error()
    {
        System.out.println("position must be between 0 and 7 inclusive");
        throw new ArrayIndexOutOfBoundsException();
    }
}
