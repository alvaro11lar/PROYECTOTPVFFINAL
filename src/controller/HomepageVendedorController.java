package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomepageVendedorController {

    @FXML
    private Button buttonTechSupport;

    @FXML
    private ImageView imageEditProduct;
	
    @FXML
    private Label cajaClienttes;

	public Label getCajaClienttes() {
		return cajaClienttes;
	}

	public void setCajaClienttes(Label cajaClienttes) {
		this.cajaClienttes = cajaClienttes;
	}
    
    
    
}
