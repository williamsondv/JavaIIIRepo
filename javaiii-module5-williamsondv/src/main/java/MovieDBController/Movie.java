package MovieDBController;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Movie {

	private int id;
	private String name;
	private String description;
	private int rating;
	private static ObservableList<Movie> movieList = FXCollections.observableArrayList();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public static ObservableList<Movie> getObservableList() {
		return movieList;
	}
	public static void setObservableList(ObservableList<Movie> observableList) {
		Movie.movieList = observableList;
	}
	
	public Movie(int id, String name, String description, int rating) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rating = rating;
	}
	
	
	
	
}
