package application;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.*;

public class YoneticiController {
	
	Connection baglanti;
	PreparedStatement ps;
	ResultSet getirilen;
	String sql;
	 public YoneticiController() {
		 baglanti=VeriTabaniUtil.Baglan();
	 }
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button arabtn;

    @FXML
    private TextField txt_arama;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;
    
    @FXML
    private TableColumn<Kayitlar , Integer> ID;
   

    @FXML
    private TextField txt_barkod;

    @FXML
    private TextField txt_kategori;

    @FXML
    private TextField txt_satis_fiyati;
    @FXML
    private TextField txt_alis_fiyati;


    @FXML
    private TextField txt_stok;

    @FXML
    private TextField txt_urun_adi;


    @FXML
    private TableView<Kayitlar> tableView_Aramalar;

   
    @FXML
    private TableColumn<Kayitlar, Integer> barkod_no;

    @FXML
    private TableColumn<Kayitlar, String> kategori;

    @FXML
    private TableColumn<Kayitlar, String> urun_adi;

    @FXML
    private TableColumn<Kayitlar, Double> alis_fiyati;

    @FXML
    private TableColumn<Kayitlar, Double> satis_fiyati;

    @FXML
    private TableColumn<Kayitlar, Integer> stok;
    
    /*public void veri_guncelle(int barkod_no, String urun_adi, String kategori, Double alis_fiyati , Double satis_fiyati ,int stok) {
    	
   
         Kayitlar record = new Kayitlar();
		record=(Kayitlar) tableView_Aramalar.getItems().get(tableView_Aramalar.getSelectionModel().getSelectedIndex());
    	 System.out.println(record);
    	try {
    		  String sql = "UPDATE  `estate` SET "
             		 + "`barkod_no`=?,"
             		 + "`urun_adi`=?,"
             		 + "`kategori`=?,"
             		 + "`alis_fiyati`=?,"
             		 + "`satis_fiyati`=?,"
             		 + "`stok`=?  "
             		+ "WHERE barkod_no = ?"+record.getBarkod_no()+"'";
              	
    		ps=baglanti.prepareStatement(sql);
    		
        	ps.setString(1,txt_barkod.getText().trim());
        	ps.setString(2,txt_kategori.getText().trim());
        	ps.setString(3,txt_urun_adi.getText().trim());
        	ps.setString(4,txt_alis_fiyati.getText().trim());
            ps.setString(5,txt_satis_fiyati.getText().trim());
        	ps.setString(6,txt_stok.getText().trim());
        	
        	System.out.println(record);
    		ps.executeUpdate();
    		System.out.println("Guncellendi");
    }catch(Exception e)
    	{
    	System.out.println(e.getMessage().toString());
    	}
    
    }*/	
    
    
    
    
    @FXML
    void araclick(ActionEvent event) {

    	String getir=("Select * from urunler");
    	try {
    		
    		ps=baglanti.prepareStatement(sql);
    		
        	
        	ps.setString(1,txt_kategori.getText().trim());
        	
    		ps.executeUpdate();
    		System.out.println("ara");
    }catch(Exception e)
    	{
    	System.out.println(e.getMessage().toString());
    	
    }

    }
    
    @FXML
    void btn_ekle_Click(ActionEvent event) {
     
    	sql ="insert into urunler(barkod_no,kategori,urun_adi,alis_fiyati,satis_fiyati,stok) values (?,?,?,?,?,?)";
		
    	try {
    		
    		ps=baglanti.prepareStatement(sql);
    		
        	ps.setString(1,txt_barkod.getText().trim());
        	ps.setString(2,txt_kategori.getText().trim());
        	ps.setString(3,txt_urun_adi.getText().trim());
        	ps.setString(4,txt_alis_fiyati.getText().trim());
            ps.setString(5,txt_satis_fiyati.getText().trim());
        	ps.setString(6,txt_stok.getText().trim());
        	
    		ps.executeUpdate();
    		//System.out.println("Eklendi");
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Bilgi mesaji");
    		alert.setHeaderText("Ekleme mesaji");
    		alert.setContentText("Ekleme islemi basarili bir sekilde olmustur.");
    		alert.showAndWait();
    		
    }catch(Exception e)
    	{
    	System.out.println(e.getMessage().toString());
    	
    }
    	}
    	
    

    @FXML
    void btn_guncelle_Click(ActionEvent event) throws IOException {
    
    
sql ="UPDATE urunler set satis_fiyati=?, stok=? where barkod_no=? and kategori=? and urun_adi=?";
		
    	try {
    		
    		ps=baglanti.prepareStatement(sql);
    		
        	ps.setString(3,txt_barkod.getText().trim());
        	ps.setString(4,txt_kategori.getText().trim());
        	ps.setString(5,txt_urun_adi.getText().trim());
            ps.setString(1,txt_satis_fiyati.getText().trim());
        	ps.setString(2,txt_stok.getText().trim());
        	
    		ps.executeUpdate();
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Bilgi mesaji");
    		alert.setHeaderText("Guncelleme mesaji");
    		alert.setContentText("Guncelleme islemi basarili bir sekilde olmustur.");
    		alert.showAndWait();
    		
    }catch(Exception e)
    	{
    	System.out.println(e.getMessage().toString());
    	
    }
    
    
    
    }
    	
    

    	
    
    

    @FXML
    void btn_sil_Click(ActionEvent event) {
     sql ="Delete from urunler where barkod_no=?"; // and kategori=? and urun_adi=? and alis_fiyati=? and satis_fiyati=? and stok=?";
    	try {
    	
    	
    	ps = baglanti.prepareStatement(sql);
    	ps.setString(1,txt_barkod.getText().trim());
    	//ps.setString(2,txt_kategori.getText().trim());
    	//ps.setString(3,txt_urun_adi.getText().trim());
    	//ps.setString(4,txt_alis_fiyati.getText().trim());
       // ps.setString(5,txt_satis_fiyati.getText().trim());
    	//ps.setString(6,txt_stok.getText().trim());
    	
	    ps.executeUpdate();
	    //System.out.println("Silme islemi gerceklesti.");
	    Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bilgi mesaji");
		alert.setHeaderText("Silme mesaji");
		alert.setContentText("Silme islemi basarili bir sekilde olmustur.");
		alert.showAndWait();
		
	 
	    }
    
		
    
    catch (Exception e) {
    	System.out.println(e.getMessage().toString());
    
    }
}

    @FXML
    void txt_arama_Action(ActionEvent event) {
    	//String getir=("Select * from urunler");

    }


    @FXML
    void txt_arama_Keypressed(KeyEvent event) {
    	
    	//String sql;
//if(txt_arama.getText().equals("")) {
// sql="Select * from urunler";
//}
//else {
// sql= "Select * from urunler where kategori like '%"+txt_arama.getText()+"%' or urun_adi like '%"+txt_arama.getText()+"%' " ;
//}


    }
public void DegerleriGetir(TableView tablo) { // string sql
		sql="Select*from urunler";
		
		ObservableList<Kayitlar>kayitlarListe=FXCollections.observableArrayList();
		
		try {
			  
			ps = baglanti.prepareStatement(sql);
			ResultSet getirilen=ps.executeQuery();
			while (getirilen.next()) {
			kayitlarListe.add(new Kayitlar(getirilen.getInt("barkod_no"),
					getirilen.getString("kategori"),getirilen.getString("urun_adi"),
					getirilen.getDouble("alis_fiyati"),getirilen.getDouble("satis_fiyati") ,
					getirilen.getInt("stok")));
			
				
			}

			barkod_no.setCellValueFactory(new PropertyValueFactory<>("barkod_no"));
			kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
			urun_adi.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
			alis_fiyati.setCellValueFactory(new PropertyValueFactory<>("alis_fiyati"));
			
			satis_fiyati.setCellValueFactory(new PropertyValueFactory<>("satis_fiyati"));
			stok.setCellValueFactory(new PropertyValueFactory<>("stok"));
			tableView_Aramalar.setItems(kayitlarListe);
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}



@FXML
void btn_mause_click(MouseEvent event) {
//	barkod_no.setCellValueFactory(new PropertyValueFactory<>("barkod_no"));
//	kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
//	urun_adi.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
//	alis_fiyati.setCellValueFactory(new PropertyValueFactory<>("alis_fiyati"));
//	satis_fiyati.setCellValueFactory(new PropertyValueFactory<>("satis_fiyati"));
//	stok.setCellValueFactory(new PropertyValueFactory<>("stok"));
//	

}


    @FXML
    void initialize() {
    	//String sql = "Select * from urunler";
       // DegerleriGetir(tableView_Aramalar,sql);
        DegerleriGetir(tableView_Aramalar);
        //DegerleriGetir(tableView_Aramalar,"Select * from urunler");
    }
}
