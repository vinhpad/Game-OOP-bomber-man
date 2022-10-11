package GameController;

import Map.Map;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

import static Constants.Constants.*;
import static Constants.Constants.STATUS.*;
import static Graphics.Sprite.SCALED_SIZE;

public class Message {
    public static Map gameMap = Map.getGameMap();

    public static Text stage = new Text();
    public static Text bombs = new Text();
    public static Text flame = new Text();
    public static Text speed = new Text();
    public static Text life = new Text();
    public static Text sound = new Text();

    static {
        Font font = Font.loadFont(FONT_PATH[2],20);
        stage.setFont(font);
        bombs.setFont(font);
        flame.setFont(font);
        life.setFont(font);
        sound.setFont(font);
    }

    public static Text createText(String content,int size) {
        Font font = Font.loadFont(FONT_PATH[1],size);
        Text text = new Text(content);
        text.setFont(font);
        text.setFill(Color.WHITE);
        return text;
    }

    public static void updateBoard() {
        stage.setText("STAGE: " + 0);
        life.setText("LIFE: " + 0);
        bombs.setText("BOMBS_MAX: "+0);
        flame.setText("LEVEL_BOMBS: "+0);
        speed.setText("LEVEL_SPEED: "+0);
        sound.setText("MIX: " +"ON");
    }

    public static HBox getBoard() {
        HBox hBox = new HBox(stage,life,bombs,flame,speed,sound);
        hBox.setSpacing(100.0);
        hBox.setAlignment(Pos.CENTER);
        hBox.setBackground(new Background(new BackgroundFill(Color.rgb(185,185,185),null,null)));
        return hBox;
    }

    public static void showNextStageMessenger() {
        Bomberman.status = PAUSE;
        Text text = createText("Stage " + Map.getGameMap().getStage(), 30);
        StackPane root = new StackPane(text);
        root.setPrefSize(SCALED_SIZE * WIDTH, SCALED_SIZE * HEIGHT);
        root.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0),null,null)));
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            Bomberman.stage.close();
            Bomberman.createStage();
        });
        Bomberman.stage.setScene(scene);
        Bomberman.stage.show();
    }

    public static void showDefeatMessage() {
        Bomberman.status = PAUSE;
        Text text1 = createText("DEFEAT!", 50);
        Text text2 = createText("ENTER: to play again." + Map.getGameMap().getScore(), 20);
        Text text3 = createText("ESC: to exit.",20);
        VBox root = new VBox(text1, text2,text3);
        root.setAlignment(Pos.CENTER);  root.setSpacing(10);
        root.setPrefSize(SCALED_SIZE * WIDTH, SCALED_SIZE * HEIGHT);
        root.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0),null,null)));
        Scene scene = new Scene(root);

        Bomberman.stage.setScene(scene);
        Bomberman.stage.show();
    }

    public static void showPauseMessage() {
        if (Bomberman.status == PLAYING) {
            Bomberman.status = PAUSE;
            Text text1 = createText("PAUSE", 30);
            Text text2 = createText("Press P to continue", 20);
            VBox root = new VBox(text1, text2);
            root.setAlignment(Pos.CENTER);  root.setSpacing(10);
            root.setPrefSize(SCALED_SIZE * WIDTH, SCALED_SIZE * HEIGHT);
            root.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0),null,null)));
            Scene scene = new Scene(root);
            scene.setOnKeyPressed(
                    e -> {
                        String code = e.getCode().toString();
                        if (code.equals("P")) {
                            Message.showPauseMessage();
                        }
                    });
            Bomberman.stage.setScene(scene);
            Bomberman.stage.show();

        } else {
            Bomberman.status = PLAYING;
            Bomberman.createStage();
        }
    }

    public static void showMenu() throws IOException {
//        Sound.backgroundSound = Sound.playSound("Title");
        Bomberman.stage.setScene(MenuController.getScene());
        Bomberman.stage.show();
    }

    public static void showGuideMessage(){
        Text setup = createText("Keybroad setting.",80);
        Text up = createText("W: move UP bomber",50);
        Text down = createText("S: move DOWN bomber", 50);
        Text left = createText("A: move LEFT bomber",50);
        Text right = createText("D: move RIGHT bomber", 50);
        Text space = createText("SPACE: place bomb",50);
        Text pause = createText("P: to pause game",50);
        Text enter = createText("( ENTER to back )",50);
        VBox root = new VBox(setup, up,down,left,right,space,pause,enter);
        root.setAlignment(Pos.CENTER);  root.setSpacing(15);
        root.setPrefSize(SCALED_SIZE * WIDTH, SCALED_SIZE * HEIGHT);
        root.setBackground(new Background(new BackgroundFill(Color.GREY,null,null)));
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    if (code.equals("ENTER")) {
                        try {
                            Message.showMenu();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
        Bomberman.stage.setScene(scene);
        Bomberman.stage.show();
    }
}
