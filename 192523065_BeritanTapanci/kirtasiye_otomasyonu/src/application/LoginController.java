package application;


import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import Util.VeriTabaniUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.sql.*;

public class LoginController {
	Connection baglanti;
	PreparedStatement sorguIfadesi;
	ResultSet getirilen;
	String sql;
	 public LoginController() {
		 baglanti=VeriTabaniUtil.Baglan();
	 }

	
	
	
	
	
	
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField txt_kulad;

	    @FXML
	    private TextField txt_sifre;

	    @FXML
	    private Button btn_giris;

	    @FXML
	    private Button btn_kullanici;
	    
	    
	    
	    

	    @FXML
	    void btn_giris_Click(ActionEvent event) {
	    String sql="select*from Login where kullanici_adi=? and sifre=? ";
	    	try {
	    		sorguIfadesi=baglanti.prepareStatement(sql);
	    		sorguIfadesi.setString(1,txt_kulad.getText().trim());
	    		sorguIfadesi.setString(2,txt_sifre.getText().trim());
	    		ResultSet getirilen=sorguIfadesi.executeQuery();
	    		if (!getirilen.next()) {
	    			//System.out.println("Hatali Giris.");
	    			Alert alert=new Alert(AlertType.ERROR);
	    	    	alert.setTitle("kirtasiye Otomasyon");
	    	    	alert.setHeaderText("Hata Mesaji");
	    	    	alert.setContentText("hatali islemler yaptiniz.");
	    	    	alert.showAndWait();
	    	    	
	    		}
	    		else {
	    			getirilen.getString(1);
	    			//System.out.println("Id:"+getirilen.getString("id"));
	    			Parent root=FXMLLoader.load(getClass().getResource("Yonetici.fxml"));
	    			Stage stage=new Stage();
	    			Scene scene=new Scene(root);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			stage.setScene(scene);
	    			stage.show();
	    		}
	    		
	    		
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage().toString());
	    		
	    	}
	    	
	    	

	    	
		
		
	}

	    

	    @FXML
	    void btn_kullanici_Click(ActionEvent event) throws IOException  {
	    	sql="select*from Login where kullanici_adi=? and sifre=? ";
	    	try {
	    		sorguIfadesi=baglanti.prepareStatement(sql);
	    		sorguIfadesi.setString(1,txt_kulad.getText().trim());
	    		sorguIfadesi.setString(2,txt_sifre.getText().trim());
	    		ResultSet getirilen=sorguIfadesi.executeQuery();
	    		if (!getirilen.next()) {
	    			System.out.println("Hatali Giris.");
	    		}
	    		else {
	    			getirilen.getString(1);
	    			System.out.println("Id:"+getirilen.getString("id"));
	    			Parent root=FXMLLoader.load(getClass().getResource("Kullanici.fxml"));
	    			Stage stage=new Stage();
	    			Scene scene=new Scene(root);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			stage.setScene(scene);
	    			stage.show();
	    		}
	    		
	    		
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage().toString());
	    		
	    	}
	    	  
	    
	    }

	    @FXML
	    void initialize() {


	    }
	

}
	
	
 