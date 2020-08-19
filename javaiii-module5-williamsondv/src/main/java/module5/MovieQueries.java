package module5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MovieDBController.Movie;
import MovieDBView.MovieDBController;



public class MovieQueries {
	private static final String URL = "jdbc:derby:Example;create=true";

	private Connection connection;
	private PreparedStatement selectAllExample;
	

	public MovieQueries() {
		try {
			System.out.println("Connecting to database URL: " + URL);
			connection = DriverManager.getConnection(URL);

			resetExampleDatabase();

			System.out.println("Creating Example prepareStatement");
			selectAllExample = connection.prepareStatement("Select * From example");

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	void resetExampleDatabase() {
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			
			System.out.println("adding values into example table");
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
	}
	
	
	public void addItemToDatabase(MovieDBController movieController) throws SQLException {
		
		connection = DriverManager.getConnection(URL);
		String addItem = new String("INSERT INTO Movies"
				+ " VALUES (" + movieController.getIdValue() + ",'" + movieController.getNameValue() + "','" + movieController.getDescriptionValue() + "'," + movieController.getRatingValue() + ")");
		
		Statement statement = connection.createStatement();
		System.out.println(addItem);
		statement.executeUpdate(addItem);
	}
	
    public void deleteItemFromDatabase(Movie movie) throws SQLException {
    	ResultSet resultSet = getResultSet();
		while (resultSet.next()) {
			if (movie.getId() == resultSet.getInt(1)){
				String deleteItem = new String("Delete FROM Movies WHERE id = " + movie.getId());
				Statement statement = connection.createStatement();
				System.out.println(deleteItem);
				statement.executeUpdate(deleteItem);
			} 
		}
	}
	
	public ResultSet getResultSet() throws SQLException {
		connection = DriverManager.getConnection(URL);
		String selectAll = new String("SELECT * FROM MOVIES");
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(selectAll);
		return resultSet;
			}
		
	public synchronized void setAllToArrayList() throws SQLException {
		ResultSet resultSet = getResultSet();
		
		
			while(resultSet.next()) {
				int IDNumber = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int rating = resultSet.getInt("rating");
				
				Movie movieToStore = new Movie(IDNumber, name, description, rating);
				Movie.getObservableList().add(movieToStore);
								
		        }}
	
	
}
