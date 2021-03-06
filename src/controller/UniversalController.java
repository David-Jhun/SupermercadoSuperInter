package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exception.ElementRepeatedException;
import exception.EmptyFieldException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Candidate;
import model.Laptop;
import model.Management;
import model.Supermarket;
import thread.ThreadClock1;

public class UniversalController implements Initializable{
	
	@FXML
    private Label labelClock;

    @FXML
    private BorderPane mainPanel;
    
    @FXML
    private TextField textLaptop;
    
    @FXML
    private TextField textClientDT;

    @FXML
    private TextField textClientDN;

    @FXML
    private TextField textClientN;

    @FXML
    private TextField textClientE;

    @FXML
    private TextField textClientA;
    
    private Supermarket supermarket;
    
    private ThreadClock1 thread1;
    
    public UniversalController( Supermarket supermarket ) {
		this.supermarket = supermarket;
	}

    @FXML
    public void addACandidate(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/AddCandidate.fxml"));
    	loader.setController(this);
    	Parent addCandidate = loader.load();
    	mainPanel.setCenter(addCandidate);
    }

    @FXML
    public void addAClient(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/AddClient.fxml"));
    	loader.setController(this);
    	Parent addClient = loader.load();
    	mainPanel.setCenter(addClient);
    }

    @FXML
    public void addALaptop(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/AddLaptop.fxml"));
    	loader.setController(this);
    	Parent addLaptop = loader.load();
    	mainPanel.setCenter(addLaptop);
    }

    @FXML
    public void addAManager(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/AddManager.fxml"));
    	loader.setController(this);
    	Parent addManager = loader.load();
    	mainPanel.setCenter(addManager);
    }

    @FXML
    public void generateALaptopReport(ActionEvent event) {
    	try {
    		supermarket.printAllComputers();
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setContentText("The laptop report was generated.");
        	alert.show();
    	}catch( FileNotFoundException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error");
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}
    }
    
    @FXML
    public void searchALaptop(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/SearchLaptop.fxml"));
    	loader.setController(this);
    	Parent searchLaptop = loader.load();
    	mainPanel.setCenter(searchLaptop);
    }
    
    @FXML
    public void searchCandidate(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/SearchCandidate.fxml"));
    	loader.setController(this);
    	Parent searchCandidate = loader.load();
    	mainPanel.setCenter(searchCandidate);
    }

    @FXML
    public void searchManager(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/SearchManager.fxml"));
    	loader.setController(this);
    	Parent searchManager = loader.load();
    	mainPanel.setCenter(searchManager);
    }
    
    @FXML
    public void showCandidateWeight(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Number of candidates registered.");
    	alert.setContentText("The number of candidates are: " + supermarket.getWeightCandidateTree());
    	alert.show();
    }

    
    @FXML
    public void showChart1(ActionEvent event) {
    	Stage stage = new Stage();
    	Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void showChart2(ActionEvent event) {
    	Stage stage = new Stage();
    	final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Supermarket growth");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Purchases");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void showManagerWeight(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Number of managers registered.");
    	alert.setHeaderText("Managers");
    	alert.setContentText("The number of managers are: " + supermarket.getWeigtManagementTree());
    	alert.show();
    }
    
    //------------------------------------------------------------------------
    @FXML
    public void searchLaptop(ActionEvent event) {
    	String name = textLaptop.getText();
    	Laptop l = supermarket.binarySearchLaptopByName(name);
    	if( l == null )
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Not found");
    		alert.setHeaderText("The product was not found");
    		alert.setContentText("Try to type better.");
    		alert.show();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Object found");
    		alert.setHeaderText("The product was found");
    		alert.setContentText("" + l.getName());
    		alert.show();
    	}
    }
    
    @FXML
    private TextField textSearchCandidate;

    @FXML
    public void buscarAspirante(ActionEvent event) {
    	String name = textSearchCandidate.getText();
    	Candidate c = supermarket.searchCandidate(name);
    	if( c == null )
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Not found");
    		alert.setHeaderText("The candidate was not found");
    		alert.setContentText("Try to type better.");
    		alert.show();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Candidate found");
    		alert.setHeaderText("The candidate was found");
    		alert.setContentText("" + c.getName());
    		alert.show();
    	}
    }
    
    @FXML
    private TextField textSearchManager;

    @FXML
    public void buscarMiembro(ActionEvent event) {
    	String name = textSearchManager.getText();
    	Management c = supermarket.searchManagement(name);
    	if( c == null )
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Not found");
    		alert.setHeaderText("The manager was not found");
    		alert.setContentText("Try to type better.");
    		alert.show();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Manager found");
    		alert.setHeaderText("The manager was found");
    		alert.setContentText("" + c.getName());
    		alert.show();
    	}
    }
    
    @FXML
    public void agregarCliente(ActionEvent event) {
    	try {
    		if( textClientDT.getText() == "" ) {
        		throw new EmptyFieldException("The field must not be empty.");
        	}else if( textClientDN.getText() == "" ) {
        		throw new EmptyFieldException("The field must not be empty.");
        	}else if( textClientN.getText() == "" ) {
        		throw new EmptyFieldException("The field must not be empty.");
        	}else if( textClientE.getText() == "" ) {
        		throw new EmptyFieldException("The field must not be empty.");
        	}else if( textClientA.getText() == "" ) {
        		throw new EmptyFieldException("The field must not be empty.");
        	}
    		String dt = textClientDT.getText();
    		String dn = textClientDN.getText();
    		String n = textClientN.getText();
    		String e = textClientE.getText();
    		String a = textClientA.getText();
    		
    		supermarket.addClient(dt, dn, n, e, a);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("The client was successfully added.");
    		alert.show();
    	}catch( EmptyFieldException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setHeaderText(null);
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}
    }
    
    @FXML
    private TextField textCDT;

    @FXML
    private TextField textCDN;

    @FXML
    private TextField textCN;

    @FXML
    private TextField textCE;

    @FXML
    private TextField textCP;

    @FXML
    private TextField textCA;

    @FXML
    private TextField textCYE;

    @FXML
    public void agregarCandidato(ActionEvent event) {
    	try {
    		
    		if( textCDT.getText() == "" || textCDN.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textCN.getText() == "" || textCE.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textCP.getText() == "" || textCA.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textCYE.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    			
    		String dt = textCDT.getText();
    		String dn = textCDN.getText();
    		String n = textCN.getText();
    		String e = textCE.getText();
    		String p = textCP.getText();
    		String a = textCA.getText();
    		int ye = Integer.parseInt(textCYE.getText());
    		
    		supermarket.addCandidate(dt, dn, n, e, p, a, ye);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("The candidate was added.");
    		alert.show();
    		
    	}catch( EmptyFieldException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setHeaderText(null);
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}catch( NumberFormatException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setHeaderText(null);
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}catch( ElementRepeatedException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setHeaderText(null);
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}
    }
    
    @FXML
    private TextField textMDT;

    @FXML
    private TextField textMDN;

    @FXML
    private TextField textMN;

    @FXML
    private TextField textME;

    @FXML
    private TextField textMP;

    @FXML
    private TextField textMA;

    @FXML
    private TextField textMPos;

    @FXML
    public void agregarGerencia(ActionEvent event) {
    	try {
    		
    		if( textMDT.getText() == "" || textMDN.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textMN.getText() == "" || textME.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textMP.getText() == "" || textMA.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textMPos.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		
    		String dt = textCDT.getText();
    		String dn = textCDN.getText();
    		String n = textCN.getText();
    		String e = textCE.getText();
    		String p = textCP.getText();
    		String a = textCA.getText();
    		String pos = textMPos.getText();
    		
    		supermarket.addManagement(dt, dn, n, e, p, a, pos);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("The manager was added.");
    		alert.show();
    		
    	}catch( EmptyFieldException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}catch( ElementRepeatedException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}
    }
    
    @FXML
    private TextField textLN;

    @FXML
    private TextField textLB;

    @FXML
    private TextField textLP;

    @FXML
    private TextField textLL;

    @FXML
    private TextField textLProce;

    @FXML
    private TextField textLR;

    @FXML
    private TextField textLST;

    @FXML
    private TextField textLAM;

    @FXML
    public void agregarPortatil(ActionEvent event) {
    	try {
    		
    		if( textLN.getText() == "" || textLB.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textLP.getText() == "" || textLL.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textLProce.getText() == "" || textLR.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		else if( textLST.getText() == "" || textLAM.getText() == "" )
    			throw new EmptyFieldException("Enter a value");
    		
    		String n = textLN.getText();
    		String b = textLB.getText();
    		double p = Double.parseDouble(textLP.getText());
    		String l = textLL.getText();
    		String pro = textLProce.getText();
    		int r = Integer.parseInt(textLR.getText());
    		String st = textLST.getText();
    		int a = Integer.parseInt(textLAM.getText());
    		
    		supermarket.addLaptop(n, b, p, l, pro, r, st, a);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText(null);
    		alert.setContentText("The laptop was added.");
    		alert.show();
    		
    	}catch( EmptyFieldException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}catch( NumberFormatException e ) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error!");
    		alert.setContentText(e.getMessage());
    		alert.show();
    	}
    }
    
    public void updateTime( String time ) {
    	labelClock.setText(time);
    }
    
    public void startClock() {
    	thread1 = new ThreadClock1(this);
    	thread1.start();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startClock();
	}
	
}
