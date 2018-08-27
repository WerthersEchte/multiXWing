package de.fh_kiel.roboticlab.multixwing.javafx;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;

public class Helper {
    static Parent initControllerForTUIOFX( Parent aController ) {

        aController.setOnZoom(new EventHandler<ZoomEvent>() {
            @Override
            public void handle(ZoomEvent event) {
                double scaleX = aController.getScaleX() * event.getZoomFactor();
                double scaleY = aController.getScaleY() * event.getZoomFactor();
                aController.setScaleX(scaleX);
                aController.setScaleY(scaleY);
            }
        });
        aController.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                aController.setTranslateX(aController.getTranslateX() + event.getDeltaX());
                aController.setTranslateY(aController.getTranslateY() + event.getDeltaY());
            }
        });
        aController.setOnRotate(new EventHandler<RotateEvent>() {
            @Override
            public void handle(RotateEvent event) {
                aController.setRotate(aController.getRotate() + event.getAngle());
            }
        });

        return aController;
    }
}
