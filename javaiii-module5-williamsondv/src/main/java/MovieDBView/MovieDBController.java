package MovieDBView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;



import MovieDBController.Movie;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import module5.MovieQueries;

public class MovieDBController {

	Alert alert = new Alert(AlertType.NONE);
	Integer idValue = 0;
	String descriptionValue = new String();
	String nameValue = new String();
	Integer ratingValue = 0;
	
	public MovieDBController() {
         
    }
	
	@FXML
    private  TableView<Movie> tableView;
	
    @FXML
    private TableColumn<Movie,Integer> ratingColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField ratingTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Movie,String> nameColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextArea descriptionTextField;
    
    @FXML
    private Button viewButton;

    public TableColumn<Movie, Integer> getRatingColumn() {
		return ratingColumn;
	}

	public void setRatingColumn(TableColumn<Movie, Integer> ratingColumn) {
		this.ratingColumn = ratingColumn;
	}

	public TextField getIdTextField() {
		return idTextField;
	}

	public void setIdTextField(TextField idTextField) {
		this.idTextField = idTextField;
	}

	public TextField getRatingTextField() {
		return ratingTextField;
	}

	public void setRatingTextField(TextField ratingTextField) {
		this.ratingTextField = ratingTextField;
	}

	public Button getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(Button searchButton) {
		this.searchButton = searchButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}

	public TableColumn<Movie, String> getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(TableColumn<Movie, String> nameColumn) {
		this.nameColumn = nameColumn;
	}

	public TextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(TextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}

	public TextArea getDescriptionTextField() {
		return descriptionTextField;
	}

	public void setDescriptionTextField(TextArea descriptionTextField) {
		this.descriptionTextField = descriptionTextField;
	}

	public TableColumn<Movie, Integer> getIdColumn() {
		return idColumn;
	}

	public void setIdColumn(TableColumn<Movie, Integer> idColumn) {
		this.idColumn = idColumn;
	}

	public TableColumn<Movie, String> getDescriptionColumn() {
		return descriptionColumn;
	}

	public void setDescriptionColumn(TableColumn<Movie, String> descriptionColumn) {
		this.descriptionColumn = descriptionColumn;
	}

	@FXML
    private TableColumn<Movie, Integer> idColumn;

    @FXML
    private TableColumn<Movie, String> descriptionColumn;
    
    //Search function allows user to search by I.D. Number or, if I.D. is null(empty String), by name.
    @FXML
    void searchMovie(ActionEvent event) throws SQLException {
    	Movie workingMovie = new Movie(idValue, descriptionValue, descriptionValue, idValue);
    	MovieQueries movieQuery = new MovieQueries();
    	ResultSet resultSet = movieQuery.getResultSet();
    	if (!idTextField.getText().contentEquals("")) {
    	idValue = Integer.parseInt(idTextField.getText());
    	} else {
    		idValue = 0;
    	}
    	nameValue = nameTextField.getText();
    	
    	if (idValue != 0 && idValue != null) {
    		while (resultSet.next()) {
    			if (idValue == resultSet.getInt(1)) {
    				for (int i = 0; i < Movie.getObservableList().size(); i++) {
    					if (idValue == Movie.getObservableList().get(i).getId()) {
    						workingMovie = Movie.getObservableList().get(i);
    					}
    				}
    			} 
    		}tableView.getSelectionModel().select(workingMovie);
    		 idTextField.setText(String.valueOf(workingMovie.getId()));
    		 nameTextField.setText(workingMovie.getName());
    		 descriptionTextField.setText(workingMovie.getDescription());
    		 ratingTextField.setText(String.valueOf(workingMovie.getRating()));
    	} else if (nameValue != null && !nameValue.contentEquals("")){
    		while (resultSet.next()) {
    			if (nameValue.contentEquals(resultSet.getString(2))) {
    				for (int i = 0; i < Movie.getObservableList().size(); i++) {
    					
    					if (nameValue.contentEquals(Movie.getObservableList().get(i).getName())) {
    						workingMovie = Movie.getObservableList().get(i);
    					}
    				}
    			} 
    		}tableView.getSelectionModel().select(workingMovie);
    		 idTextField.setText(String.valueOf(workingMovie.getId()));
    		 nameTextField.setText(workingMovie.getName());
    		 descriptionTextField.setText(workingMovie.getDescription());
    		 ratingTextField.setText(String.valueOf(workingMovie.getRating()));
    	} else {
    		 alert.setAlertType(AlertType.INFORMATION);
			  alert.setContentText("Please enter a valid name or I.D. Number");
			  alert.setTitle("Information");
			  alert.show();
    		
    	}
    }

    //add movie adds a new Movie to the ObservableList and Database
    @FXML
    void addMovie(ActionEvent event) throws SQLException, NumberFormatException {
    	try {
    	MovieQueries movieQuery = new MovieQueries();
    	ResultSet resultSet = movieQuery.getResultSet();
    	idValue = Integer.parseInt(idTextField.getText());
    	descriptionValue = new String();
    	descriptionValue = descriptionTextField.getText().replace("\\r\\\\n|\\\\r|\\\\n", " ");
    	nameValue = nameTextField.getText();
    	ratingValue = Integer.parseInt(ratingTextField.getText());
    	
    	if (ratingValue < 11 && ratingValue > 0) {
    	
    		while (resultSet.next()) {
    		 if (resultSet.getInt("id") == idValue) {
    			  alert.setAlertType(AlertType.INFORMATION);
    			  alert.setContentText("You have entered a duplicate I.D. Number. Please try again.");
    			  alert.setTitle("Information");
    			  alert.show();
    		 } else {
    			 
    		 }
    		 }
    			
 				
    	 	movieQuery.addItemToDatabase(MovieDBController.this);
    	 	Movie.getObservableList().add(new Movie(idValue,nameValue,descriptionValue,ratingValue));
    	 	
    	 	tableView.setItems(Movie.getObservableList());
    	} else if (ratingValue < 0 || ratingValue > 10) {
    		  alert.setAlertType(AlertType.INFORMATION);
			  alert.setContentText("Ratings must be whole numbers from 1 to 10");
			  alert.setTitle("Information");
			  alert.show();
    		
    	}
    		 } catch (NumberFormatException e) {
    		  alert.setAlertType(AlertType.INFORMATION);
   			  alert.setContentText("I.D. and Rating must be entered as whole numbers.");
   			  alert.setTitle("Information");
   			  alert.show();
    		 } finally {
    			 
    		 }
    	 
    		  
    	 
}
    
    public Integer getIdValue() {
		return idValue;
	}

	public void setIdValue(Integer idValue) {
		this.idValue = idValue;
	}

	public String getDescriptionValue() {
		return descriptionValue;
	}

	public void setDescriptionValue(String descriptionValue) {
		this.descriptionValue = descriptionValue;
	}

	public String getNameValue() {
		return nameValue;
	}

	public void setNameValue(String nameValue) {
		this.nameValue = nameValue;
	}

	public Integer getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}
	//Populating tableView here. I was unable to cause the tableView to populate properly on startup.
	@FXML
    void viewTextfield(ActionEvent event) {
    	idColumn.setCellValueFactory(new PropertyValueFactory<Movie,Integer>("id"));
    	descriptionColumn.setCellValueFactory(new PropertyValueFactory<Movie,String>("description"));
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Movie,String>("name"));
    	ratingColumn.setCellValueFactory(new PropertyValueFactory<Movie,Integer>("rating"));
    	tableView.setItems(Movie.getObservableList());
    }

    public TableView<Movie> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Movie> tableView) {
		this.tableView = tableView;
	}

	//delete movie function removes movie from Database and ObservableList
	@FXML
    void deleteMovie(ActionEvent event) throws SQLException {
		MovieQueries movieQuery = new MovieQueries();
		if (tableView.getSelectionModel().getSelectedItem() != null) {
			alert.setAlertType(AlertType.CONFIRMATION);
			  alert.setContentText("Are you sure you want to delete this item?");
			  alert.setTitle("Confirmation");
			  Optional<ButtonType> result = alert.showAndWait();
			  
			if (result.get() == ButtonType.OK) { 
			movieQuery.deleteItemFromDatabase(tableView.getSelectionModel().getSelectedItem());
			Movie.getObservableList().remove(tableView.getSelectionModel().getSelectedItem());
			} else {
				
			}
		} else {
			  alert.setAlertType(AlertType.INFORMATION);
 			  alert.setContentText("Please click an item to select it for deletion");
 			  alert.setTitle("Information");
 			  alert.show();
		}
		
    	
    }
    
    public synchronized void setTableView() throws InterruptedException {
    		
    	
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    }

}