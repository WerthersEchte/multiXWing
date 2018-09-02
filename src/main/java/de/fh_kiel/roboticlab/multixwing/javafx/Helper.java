package de.fh_kiel.roboticlab.multixwing.javafx;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;

public class Helper {

    static Parent initControllerForTUIOFX( Parent aController ) {
        return initControllerForTUIOFX(aController, true, true, true);
    }
    static Parent initControllerForTUIOFX( Parent aController, boolean aZoom, boolean aScroll, boolean aRotate ) {

        if(aZoom) {
            aController.setOnZoom(new EventHandler<ZoomEvent>() {
                @Override
                public void handle(ZoomEvent event) {
                    double scaleX = aController.getScaleX() * event.getZoomFactor();
                    double scaleY = aController.getScaleY() * event.getZoomFactor();
                    aController.setScaleX(scaleX);
                    aController.setScaleY(scaleY);
                }
            });
        }
        if(aScroll) {
            aController.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent event) {
                    aController.setTranslateX(aController.getTranslateX() + event.getDeltaX());
                    aController.setTranslateY(aController.getTranslateY() + event.getDeltaY());
                }
            });
        }
        if(aRotate) {
            aController.setOnRotate(new EventHandler<RotateEvent>() {
                @Override
                public void handle(RotateEvent event) {
                    aController.setRotate(aController.getRotate() + event.getAngle());
                }
            });
        }

        return aController;
    }

    public static void moveToMouseAndRotateToNearestBorder( Parent aParent, double aX, double aY ){
        aParent.setVisible(false);
        Platform.runLater(new Runnable() {
            public void run() {
                aParent.setTranslateX(aX-aParent.getLayoutBounds().getWidth()/2.0);
                aParent.setTranslateY(aY-aParent.getLayoutBounds().getHeight()/2.0);

                double upperDistance = aY/aParent.getParent().getLayoutBounds().getHeight(),
                       lowerDistance = (aParent.getParent().getLayoutBounds().getHeight() - aY)/aParent.getParent().getLayoutBounds().getHeight(),
                       leftDistance = aX/aParent.getParent().getLayoutBounds().getWidth(),
                       rightDistance = (aParent.getParent().getLayoutBounds().getWidth() - aX)/aParent.getParent().getLayoutBounds().getWidth();

                if( upperDistance < lowerDistance && upperDistance < leftDistance && upperDistance < rightDistance ){
                    aParent.setRotate(180.0);
                }else if( leftDistance < lowerDistance && leftDistance < upperDistance && leftDistance < rightDistance ){
                    aParent.setRotate(90.0);
                }else if( rightDistance < lowerDistance && rightDistance < leftDistance && rightDistance < upperDistance ){
                    aParent.setRotate(-90);
                }
                aParent.setVisible(true);
            }
        });
    }
}
