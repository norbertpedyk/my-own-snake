package pl.sdacademy.snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
   private List<Point> snakeBody;
   private Direction direction;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Snake(List<Point> snakeBody, Direction direction) {
        this.snakeBody = new ArrayList<>(snakeBody);
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Point> getSnakeBody() {
        return snakeBody;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Direction getDirection() {
        return direction;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        return "Snake{" +
                "snakeBody=" + snakeBody +
                ", direction=" + direction +
                '}';
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void cutTail(){
        snakeBody.remove(snakeBody.size() - 1);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void extend() {
        switch (direction) {
            case LEFT:
                snakeBody.add(0,new Point(snakeBody.get(0).getX()-1,snakeBody.get(0).getY()));
                break;
            case RIGHT:
                snakeBody.add(0,new Point(snakeBody.get(0).getX()+1,snakeBody.get(0).getY()));
                break;
            case DOWN:
                snakeBody.add(0,new Point(snakeBody.get(0).getX(),snakeBody.get(0).getY()+1));
                break;
            case UP:
                snakeBody.add(0,new Point(snakeBody.get(0).getX(),snakeBody.get(0).getY()-1));
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

}
