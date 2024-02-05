package controller;


import java.io.File;
import java.util.List;

import application.Vendedor;
import application.FileutilVendedor ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class loginVendedorController {



	@FXML
	private TextField userTestVendedor;

	@FXML
	private TextField password;

	@FXML
	private Hyperlink forgotPasswordLinkVendedor;

	FileutilVendedor  fu = new FileutilVendedor();

	@FXML
	void mostrarHomepageVendedor(ActionEvent event) {

		System.out.println(userTestVendedor.getText());
		System.out.println(password.getText());

		List<Vendedor> vendedores = fu.leer();
		System.out.print(vendedores);

		//System.out.println(vendedores.size());


		boolean entro = false;	
		for(Vendedor v : vendedores) {
			if(v.getUsername().equals(userTestVendedor.getText()) & v.getPassword().equals(password.getText())) {
				try {
					FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/HomepageVendedor.fxml"));
					entro = true;

					HomepageVendedorController control3 = new HomepageVendedorController();

					loader3.setController(control3);


					Parent root3 = loader3.load();


					Stage stage = new Stage();

					stage.setScene(new Scene(root3));
					stage.initModality(Modality.WINDOW_MODAL);
					stage.initOwner(((Node)(event.getSource())).getScene().getWindow());
					stage.show();

				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}


		}

		if(!entro) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Mensaje de Alerta");
			alert.setHeaderText(null);
			alert.setContentText("Password or Username incorrect.");

			// Mostrar y esperar
			alert.showAndWait();
		}
	}




	@FXML
	void mostrarSignupVendedor(ActionEvent event) {

		try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/SignupVendedor.fxml"));

			SignupVendedorController control3 = new SignupVendedorController ();

			loader3.setController(control3);

			Parent root3 = loader3.load();			
			Stage stage = new Stage();

			stage.setScene(new Scene(root3));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow());
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@FXML
	void recoverPassVendedor(ActionEvent event) {

		try {
			FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/CheckUsername.fxml"));

			CheckUsernameController control3 = new CheckUsernameController();

			loader3.setController(control3);

			Parent root3 = loader3.load();			
			Stage stage = new Stage();

			stage.setScene(new Scene(root3));
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)(event.getSource())).getScene().getWindow());
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private ImageView createImageView(String imagePath) {
		Image image = new Image(new File(imagePath).toURI().toString());
		ImageView imageView = new ImageView(image);

		// Adjuntar la ruta de la imagen como un dato adicional al ImageView
		imageView.setUserData(imagePath);

		return imageView;
	}
}