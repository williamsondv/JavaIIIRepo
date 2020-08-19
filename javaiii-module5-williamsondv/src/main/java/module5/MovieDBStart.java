package module5;
//added search and basic error correction
//David Williamson
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;

import com.sun.tools.javac.launcher.Main;

import MovieDBController.Movie;
import MovieDBView.MovieDBController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MovieDBStart extends Application implements Runnable {
	
	Thread T1 = new Thread();
	Thread T2 = new Thread();
	public synchronized void showWindow(Stage primaryStage) {
		primaryStage.show();
	}
	
	
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	ObservableList<Movie> movieList = FXCollections.observableArrayList();
        Movie.setObservableList(movieList);
        
        MovieQueries movieQuery = new MovieQueries();
    	
    	
    	Parent root;
    	root = FXMLLoader.load(getClass().getResource("/MovieDBView/movieMenu.fxml"));
		primaryStage.setScene(new Scene(root, 1000, 610));
	    showWindow(primaryStage); 
	    movieQuery.setAllToArrayList();
		
    }
    
    public static void main(String[] args) throws SQLException, InterruptedException {
    	
        Application.launch(args);
        
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
