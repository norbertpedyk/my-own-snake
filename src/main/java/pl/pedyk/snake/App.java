package pl.pedyk.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;


/**
 * JavaFX App
 */
public class App extends Application {
    int pointSize = 20;

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas(400, 400);
        VBox vBox = new VBox();
        vBox.getChildren().add(canvas);

        StackPane stackPane = new StackPane();
        Text text = new Text("Sterowanie za pomocą klawiszy: W, S, A, D");


        HBox hBox = new HBox();
        hBox.getChildren().addAll(text);

        vBox.getChildren().add(hBox);

        stackPane.getChildren().add(vBox);


        Scene scene = new Scene(stackPane);
        stage.setTitle("Snake Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        List<Point> snakeBody = Arrays.asList(
                new Point(8, 3),
                new Point(9, 3),
                new Point(9, 4),
                new Point(9, 5),
                new Point(9, 6)
        );
        Snake snake = new Snake(snakeBody, Direction.LEFT);
        GamePrinter gamePrinter = new GamePrinter(canvas.getGraphicsContext2D(), pointSize);
        SnakeGame snakeGame = new SnakeGame(20, 20, snake, gamePrinter);
        Thread thread = new Thread(snakeGame::startGame);
        thread.setDaemon(true);
        thread.start();

    // ustawianie klawiszy W,S,A,D do sterowania wężem
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                snake.setDirection((Direction.UP));
            } else if (key.getCode() == KeyCode.S) {
                snake.setDirection(Direction.DOWN);
            } else if (key.getCode() == KeyCode.A) {
                snake.setDirection(Direction.LEFT);
            } else if (key.getCode() == KeyCode.D) {
                snake.setDirection(Direction.RIGHT);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

}