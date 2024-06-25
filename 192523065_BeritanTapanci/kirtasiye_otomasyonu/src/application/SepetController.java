package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Util.VeriTabaniUtil;
import javafx.scene.control.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SepetController {

	Connection baglanti;
	PreparedStatement sorguIfadesi;
	ResultSet getirilen;
	String sql;
	 public SepetController() {
		 baglanti=VeriTabaniUtil.Baglan();
	 }
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button btn_secileni_sil;

    @FXML
    private TableView<SepetKayitlari> tableView_Aramalar;

    @FXML
    private TableColumn<SepetKayitlari, Integer> barkod_no;

    @FXML
    private TableColumn<SepetKayitlari, String> kategori;

    @FXML
    private TableColumn<SepetKayitlari, String> urun_adi;
    

    @FXML
    private TableColumn<SepetKayitlari, Double> satis_fiyati;
    
    @FXML
    private TableColumn<SepetKayitlari, Double> alis_fiyati;
    

    @FXML
    private TableColumn<SepetKayitlari, Integer> stok;
    @FXML
    private Button btn_temizle;
    
    VeriTabaniUtil db = new VeriTabaniUtil();
    PreparedStatement ps;
    ResultSet rs;
    @FXML
    private Label lbl_tutar;
    @FXML
    void btn_secileni_sil(ActionEvent event) {
    	ObservableList<SepetKayitlari>secilenKayit,tumKayit;
    	tumKayit=tableView_Aramalar.getItems();
    	secilenKayit=tableView_Aramalar.getSelectionModel().getSelectedItems();
    	secilenKayit.forEach(tumKayit::remove);
    }
    @FXML
    void btn_temizle(ActionEvent event) {

    	tableView_Aramalar.getItems().clear();
    }
    
    
    
    Double toplamtutar=0.0;
public void DegerleriGetir(TableView tablo,String sql) {
		
		ObservableList<SepetKayitlari>sepetKayitlarListe=FXCollections.observableArrayList();
		
		try {
			
			
			ps = baglanti.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				sepetKayitlarListe.add(new SepetKayitlari(rs.getInt("barkod_no"),rs.getString("kategori"),rs.getString("urun_adi"),rs.getDouble("satis_fiyati"),rs.getDouble("alis_fiyati"),rs.getInt("stok")));
			toplamtutar+=rs.getDouble("satis_fiyati");
				
			}
lbl_tutar.setText(String.valueOf(toplamtutar));
			barkod_no.setCellValueFactory(new PropertyValueFactory<>("barkod_no"));
			kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
			urun_adi.setCellValueFactory(new PropertyValueFactory<>("urun_adi"));
			alis_fiyati.setCellValueFactory(new PropertyValueFactory<>("alis_fiyati"));
			satis_fiyati.setCellValueFactory(new PropertyValueFactory<>("satis_fiyati"));
			stok.setCellValueFactory(new PropertyValueFactory<>("stok"));
			
			tableView_Aramalar.setItems(sepetKayitlarListe);
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}

    @FXML
    void initialize() {

    	
        DegerleriGetir(tableView_Aramalar,"Select * from urunler");
    }
}
