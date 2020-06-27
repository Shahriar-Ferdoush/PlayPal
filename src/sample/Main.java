package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TransparentDesign.fxml"));
        primaryStage.setTitle("PlayPal");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Scene primaryScene = new Scene(root, 643, 439);

        primaryScene.setOnMouseClicked( mouseEvent -> {
            if(mouseEvent.getClickCount() == 2 && primaryStage.isFullScreen() == false) {
                primaryStage.setFullScreen(true);
            } else if(mouseEvent.getClickCount() == 2 && primaryStage.isFullScreen() == true){
                primaryStage.setFullScreen(false);
            }
        });

        root.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            if( !primaryStage.isFullScreen() ){
                primaryStage.setX(mouseEvent.getScreenX() - xOffset);
                primaryStage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
visit
MediaPlayer Docs : https://openjfx.io/javadoc/11/javafx.media/javafx/scene/media/MediaPlayer.html
for more information..

other URLs:
Music Player : https://www.youtube.com/watch?v=anm4pY1KJFQ
This Project : https://www.youtube.com/watch?v=7Gdxl2045l8&list=PLZ0TKHiKR9wFOlOrLfdfCOxsB50iicvEj&fbclid=IwAR35wBCe3d_4MjB6uI2dbpsI_4ISezd2ErCkv6DHeHZJqACzhY4svNtagVM
This Related : https://www.youtube.com/watch?v=bWl98dhvf8Q
               https://www.youtube.com/watch?v=bLek4Ycb7p8
 */
