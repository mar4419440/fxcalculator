/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xemacscode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable {

    @FXML
    private Label label;
    private long number1 =0;
    private String operator ="";
    private boolean start = true;
    Model model = new Model();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void processNumbers(ActionEvent event) {
        if (start) {
            label.setText("");
            start = false;
        
        }
        String value = ((Button)event.getSource()).getText();
        label.setText(label.getText()+ value);
    }

    @FXML
    private void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(label.getText());
            label.setText("");
        }else{
                if (operator.isEmpty()) {
                    return;
                }
                    long number2;
                    number2 = Long.parseLong(label.getText());
                    float output = model.calculate(number1,number2, operator);
                    label.setText(String.valueOf(output));
                
        }
    }
    
}
