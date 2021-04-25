package pl.pedyk.snake;

import java.util.Random;

public class SnakeGame {
    private int xBound;
    private int yBound;
    private Snake snake;
    private Point apple;
    private GamePrinter printer;
    private int EatenApples = 0;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public SnakeGame(int xBound, int yBound, Snake snake, GamePrinter gamePrinter) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.snake = snake;
        printer = gamePrinter;
    }


    public int getEatenApples() {
        return EatenApples;
    }

    public void setEatenApples(int eatenApples) {
        EatenApples = eatenApples;
    }

    public int getxBound() {
        return xBound;
    }

    public int getyBound() {
        return yBound;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getApple() {
        return apple;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "SnakeGame{" +
                "xBound=" + xBound +
                ", yBound=" + yBound +
                ", snake=" + snake +
                '}';
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void putRandomizedApple() {
        Random random = new Random();
        do {
            int x = random.nextInt(xBound);
            int y = random.nextInt(yBound);
            apple = new Point(x, y);
        } while (snake.getSnakeBody().contains(apple));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void startGame() {
        putRandomizedApple();
        printer.printGame(this);
        do {
            //snake.move();
            snake.extend();
            if (!(snake.getSnakeBody().get(0).equals(apple))) {
                snake.cutTail();
            }
            if (snakeAteTail()) {
                break;
            }
            if (ifSnakeAteApple()) {
                putRandomizedApple();
                this.setEatenApples(this.getEatenApples() + 1);
            }
            try {
                Thread.sleep(1000/(this.getEatenApples()+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.printGame(this);
        } while (snakeInBound());
        System.out.println("Gra zakończona!");
    }

    private boolean ifSnakeAteApple() {
        if (snake.getSnakeBody().get(0).equals(apple)) {
            return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean snakeInBound() {
        int headX = snake.getSnakeBody().get(0).getX();
        int headY = snake.getSnakeBody().get(0).getY();

        return 0 <= headX && headX < xBound && 0 <= headY && headY < yBound;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean snakeAteTail() {
        boolean snakeEatTail = false;
        for (int i = 1; i < snake.getSnakeBody().size(); i++) {
            if (snake.getSnakeBody().get(0).equals(snake.getSnakeBody().get(i))) {
                snakeEatTail = true;
            }
        }
        return snakeEatTail;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
}
