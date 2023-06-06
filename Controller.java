
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

        @FXML
        private MediaView mediaView;

        @FXML
        private Button playButton, pauseButton, resetButton;

        private File file;
        private Media media;
        private MediaPlayer mediaPlayer;

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {

            file = new File("5 Second Video： Watch the Milky Way Rise.mp4");
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

        }

        public void playMedia() {

            mediaPlayer.play();
        }

}
