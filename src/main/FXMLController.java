package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {

	@FXML
	private TableView<Penilaian> penilaianListTableView;
	@FXML
	private TableColumn<?, ?> idTableColumn;
	@FXML
	private TableColumn<?, ?> namaTableColumn;
	@FXML
	private TableColumn<?, ?> nilaiAngkaTableColumn;
	@FXML
	private TableColumn<?, ?> nilaiHurufTableColumn;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		TableViewPenilaian();
	}

	private void TableViewPenilaian() {

		ObservableList<Penilaian> listPenilaian = FXCollections.observableArrayList();

		String user = "username";
		String passwd = "passwd";
		String url = "jdbc:mysql://localhost:3306/siadb";

		try ( Connection connection = DriverManager.getConnection(url, user, passwd)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM penilaian");
			while (resultSet.next()) {
				String idTable = resultSet.getString("id");
				String namaTable = resultSet.getString("nama");
				Integer nilaiAngkaTable = resultSet.getInt("nilaiangka");
				String nilaiaHurufTable = resultSet.getString("nilaihuruf");

				Penilaian penilaian = new Penilaian();
				penilaian.setId(idTable);
				penilaian.setNama(namaTable);
				penilaian.setNilaiAngka(nilaiAngkaTable);
				penilaian.setPenilaianHuruf(nilaiaHurufTable);

				listPenilaian.add(penilaian);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		namaTableColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
		nilaiAngkaTableColumn.setCellValueFactory(new PropertyValueFactory<>("nilaiAngka"));
		nilaiHurufTableColumn.setCellValueFactory(new PropertyValueFactory<>("PenilaianHuruf"));

		penilaianListTableView.setItems(listPenilaian);
	}

}
