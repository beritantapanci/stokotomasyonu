package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Util.VeriTabaniUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KullaniciController {
	
	Connection baglanti;
	PreparedStatement ps;
	String sql;
	 public KullaniciController() {
		 baglanti=VeriTabaniUtil.Baglan();
	 }
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txt_arama;

    @FXML
    private Button sepet_ekle;

    @FXML
    private Button sepet_bosalt;

    @FXML
    private Button secilen_sil;
    

    @FXML
    private Button sepet;

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
    private TableColumn<Kayitlar, Double> satis_fiyat;

    @FXML
    private TableColumn<Kayitlar, Integer> stok;
    
    VeriTabaniUtil db = new VeriTabaniUtil();
    
    ResultSet rs;
/*
    @FXML
     void secilen_sil_Click(ActionEvent event) {
ObservableList<Kayitlar>secilenKayit,t¸mKayit;
t¸mKayit=tableView_Aramalar.getItems();
secilenKayit=tableView_Aramalar.getSelectionModel().getSelectedItems();
secilenKayit.forEach(t¸mKayit::remove);
    } */

    @FXML
    void sepet_Click(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Sepet.fxml"));
        Stage anapencere = new Stage();
        anapencere.setTitle("Sepet");
       
        anapencere.setScene(new Scene(root));
        anapencere.show();
	
}
    

   /* @FXML
    void sepet_bosalt_Click(ActionEvent event) {
    	
    	
    	tableView_Aramalar.getItems().clear();;
    	
    	
   
    }*/
    Kayitlar kayitlarModel;
    @FXML
    void sepet_ekle_Click(ActionEvent event) {
    	
    	String sql ="insert into urunler(barkod_no,kategori,urun_adi,alis_fiyati,satis_fiyati,stok) values (?,?,?,?,?,?)";
    	try {
    		
    	
    		ps=baglanti.prepareStatement(sql);
    		
    		//.setInt(1, kayitlarModel.getText());
    		//ps.setS(2, kayitlarModel.getText());
    		//ps.setString(3,kayitlarModel.getText());
    		//ps.setDouble(5, kayitlarModel.getText());
    		//ps.setDouble(5, kayitlarModel.getText());
    		//ps.setInt(6, kayitlarModel.getText());
    		
    		ps.executeUpdate();
    		System.out.println("Sepete Eklendi");
    }catch(Exception ex)
    	{
    	System.out.println(ex);
    	}
    }
    @FXML
    void txt_arama_Action(ActionEvent event) {

    }

    @FXML
    void txt_arama_Keypressed(KeyEvent event) {
    	
if(txt_arama.getText().equals("")) {
	 sql="Select * from urunler";
}
else {
 sql= "Select * from urunler where kategori like '%"+txt_arama.getText()+"%' or urun_adi like '%"+txt_arama.getText()+"%' " ;
}

DegerleriGetir(tableView_Aramalar,sql);
    }
    
public void DegerleriGetir(TableView tablo,String sql) {
		
		ObservableList<Kayitlar>kayitlarListe=FXCollections.observableArrayList();
		
		try {
			  
			ps = baglanti.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
			kayitlarListe.add(new Kayitlar(rs.getInt("barkod_no"),
					rs.getString("kategori"),rs.getString("urun_adi"),
					rs.getDouble("alis_fiyati"),rs.getDouble("satis_fiyati") ,
					rs.getInt("stok")));
			
				
			}

			barkod_no.setCellValueFactory(new PropertyValueFactory<>("barkod_no"));
			kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
			urun_adi.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
			alis_fiyati.setCellValueFactory(new PropertyValueFactory<>("alis_fiyati"));
			
			satis_fiyat.setCellValueFactory(new PropertyValueFactory<>("satis_fiyati"));
			stok.setCellValueFactory(new PropertyValueFactory<>("stok"));
			tableView_Aramalar.setItems(kayitlarListe);
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}


    @FXML
    void initialize() {
    	String sql = "Select * from urunler";
        DegerleriGetir(tableView_Aramalar,sql);

    }
}
