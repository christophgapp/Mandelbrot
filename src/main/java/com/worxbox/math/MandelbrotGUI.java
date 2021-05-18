package com.worxbox.math;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collection;

public class MandelbrotGUI extends Application {


    @Override
    public void start(Stage primaryStage) {

        Mandelbrot mandelbrot = new Mandelbrot();

        Pane fractalRootPane = new Pane();
        Canvas canvas = new Canvas(mandelbrot.getWidth(), mandelbrot.getHeight());

        paintSet(canvas.getGraphicsContext2D(), new Mandelbrot().getSet());

        fractalRootPane.getChildren().add(canvas);

        Scene scene = new Scene(fractalRootPane, mandelbrot.getWidth() + 2, mandelbrot.getHeight() + 2);
        scene.setOnMousePressed(event -> {
            System.out.println("mouse click detected! " + event.getX() + "/" + event.getY());
        });

        scene.setOnZoom(e -> {
            System.out.println("Viereck: Zoom event" + ", inertia: "
                    + e.isInertia() + ", direct: " + e.isDirect());

            e.consume();
        });

        scene.setOnZoomStarted(zoomEvent -> {
            System.out.println("Viereck: Zoom Event begonnen");
            zoomEvent.consume();
        });

        scene.setOnZoomFinished(zoomEvent -> {
            System.out.println("Viereck: Zoom Event beendet");
            zoomEvent.consume();
        });

        primaryStage.setTitle("Mandelbrot Set");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("done");
    }

    private void paintSet(GraphicsContext ctx, Collection<Point> points) {
        PixelWriter pixelWriter = ctx.getPixelWriter();

        points.forEach(e -> {
            Color c = Color.hsb(e.getColor() * 255, 1, 1, 1);
            pixelWriter.setColor(e.getX(), e.getY(), c);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
