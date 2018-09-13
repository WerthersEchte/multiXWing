package de.fh_kiel.roboticlab.multixwing;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.tuiofx.Configuration;
import org.tuiofx.TuioFX;

import java.io.IOException;

public class TouchTest extends Application {

    public static void main(String[] args) {
        TuioFX.enableJavaFXTouchProperties();
        launch(args);
    }

    private static final Pane mRoot = new Pane();
    private Canvas mCanvas;

    public static Pane getRootPane(){
        return mRoot;
    }

    public static void addChildToRootPane(Node aNode){
        mRoot.getChildren().add(aNode);
    }

    public static void removeChildFromRootPane(Node aNode){
        mRoot.getChildren().remove(aNode);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        final int vGameOfLife[];

        final Scene scene = new Scene(getRootPane());

        TuioFX tuiofx = new TuioFX(primaryStage, Configuration.pqLabs());
        tuiofx.start();

        primaryStage.setTitle("TouchTest");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        final int vWidth = (int) getRootPane().getWidth(), vHeight = (int) getRootPane().getHeight();

        mCanvas = new Canvas(vWidth, vHeight);
        getRootPane().getChildren().add(mCanvas);

        final int vSegments = 10;
        for(int vX = 0; vX < vSegments; ++vX){
            for(int vY = 0; vY <= vSegments; ++vY){
                Circle circle = new Circle(vX*(vWidth/(vSegments-1)), vY*(vHeight/(vSegments-1)),5, Color.BLUE);
                getRootPane().getChildren().add(circle);
            }
        }

        mCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Circle circle = new Circle(event.getX(), event.getY(),5, Color.RED);
                getRootPane().getChildren().add(circle);

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        getRootPane().getChildren().remove(circle);
                                    }
                                });
                            }
                        },
                        1000
                );

                /*
                GraphicsContext vGC = mCanvas.getGraphicsContext2D();

                vGC.setFill(Color.GREEN);
                vGC.setStroke(Color.GREEN);

                vGC.setLineWidth(5);

                vGC.strokeRect(event.getX(), event.getY(), 10, 10);
                */
            }
        });
    }
}
