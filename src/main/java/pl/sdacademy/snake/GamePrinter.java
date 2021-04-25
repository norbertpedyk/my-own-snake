package pl.sdacademy.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GamePrinter {

    private GraphicsContext gc;
    private int pointSize;

    public GamePrinter(GraphicsContext gc, int pointSize) {
        this.gc = gc;
        this.pointSize = pointSize;
    }

    public void drawPoint(Point point, Color color) {
        gc.setFill(color);
        gc.fillRect(point.getX()*pointSize, point.getY()*pointSize, pointSize, pointSize);
    }

    private void clearBoard(SnakeGame snakeGame) {
        gc.clearRect(0, 0, snakeGame.getxBound() * pointSize, snakeGame.getyBound() * pointSize);
    }

    public void printGame(SnakeGame snakeGame) {
        clearBoard(snakeGame);
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,400,400);
        snakeGame.getSnake().getSnakeBody()
                .forEach(point -> drawPoint(point,Color.GREEN));
        drawPoint(snakeGame.getApple(),Color.ORANGE);

    }
}
