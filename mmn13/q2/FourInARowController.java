import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import static javafx.scene.paint.Color.*;

public class FourInARowController {

    Logic logic = new Logic();
    @FXML
    private Label message;

    @FXML
    private GridPane grid;

    private boolean win=true;
    public int bt1 = 5, bt2 = 5, bt3 = 5, bt4 = 5, bt5 = 5, bt6 = 5, bt7 = 5;
    public static boolean turnRed = true;

    public void initialize() {
        logic.initializeMatrix();
    }

    //Column selection buttons
    @FXML
    void bt1(ActionEvent event) { bt1=pressBtn(0,bt1); }

    @FXML
    void bt2(ActionEvent event) { bt2=pressBtn(1,bt2); }

    @FXML
    void bt3(ActionEvent event) { bt3=pressBtn(2,bt3); }
    @FXML
    void bt4(ActionEvent event) { bt4=pressBtn(3,bt4); }
    @FXML
    void bt5(ActionEvent event) { bt5=pressBtn(4,bt5); }
    @FXML
    void bt6(ActionEvent event) { bt6=pressBtn(5,bt6); }
    @FXML
    void bt7(ActionEvent event) { bt7=pressBtn(6,bt7);}

    //This function is responsible for the selection of the column
    public int pressBtn(int col,int bt){
        clearMessage();
        if (bt != -1) {
            addCircle(col, bt);
            bt--;
        }
        else
            message.setText("please try another column");

        win=logic.checkWinner();
        if(win)
            message.setText("please press clear for a new game");

        return bt;
    }

    //this function create a circle and add the circle to the logic matrix
    int addCircle(int col, int row) {
        Circle redCircle = new Circle(55, RED);
        Circle blueCircle = new Circle(55, BLUE);

        if (turnRed) {
            logic.logicMatrix[row][col] = logic.R;
            grid.add(redCircle,col ,row);
            turnRed = false;
        }
        else {
            logic.logicMatrix[row][col] = logic.B;
            grid.add(blueCircle, col, row);
            turnRed = true;
        }

        return row;
    }

    //this function (button) responsible for clear the grid and the matrix
    @FXML
    void clearPressed(ActionEvent event) {
        int cnt=grid.getChildren().size();

        while(cnt>2) {
            grid.getChildren().remove(cnt - 1);
            cnt--;
        }
        bt1=5;bt2=5;bt3=5;bt4=5;bt5=5;bt6=5;bt7=5;
       logic. initializeMatrix();
        message.setText(" ");

    }

    //for clear the message label
    void clearMessage(){
        message.setText(" ");
    }
}
