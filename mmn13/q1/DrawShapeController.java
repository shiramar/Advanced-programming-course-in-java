import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class DrawShapeController{

    @FXML
    private ToggleGroup shapeGroup;
    @FXML
    private RadioButton bt1,bt2,bt3;
    @FXML
    private ColorPicker MyColorPicker;

    @FXML
    private CheckBox checkBoxFill;

    @FXML
    private Pane pan;

    private DrawShape.ShapeName currentShape;
    private boolean mouseOn;
    private double x,y;

    //initialize function
    public void initialize() {

        pan.setClip(new Rectangle(0,2, 598,800));

        currentShape = null;
        mouseOn = false;

    }

    //this function check which shape is choose
    @FXML
    void shapeMode(ActionEvent event) {
        if(bt1.isSelected()){
            currentShape= DrawShape.ShapeName.ELLIPSE;
        }
        else if(bt2.isSelected()){
            currentShape= DrawShape.ShapeName.RECTANGLE;

        }
        else if(bt3.isSelected()){
            currentShape= DrawShape.ShapeName.LINE;
        }
    }

    //this function get the Coordinates of x and y when the user press on the mouse
    @FXML
    void onMousePressed(MouseEvent event) {
        mouseOn=true;
        x=event.getX();
        y=event.getY();

    }

    //This function creates the shapes as soon as the mouse is released
    @FXML
    void onMouseReleased(MouseEvent event) {

        Shape thisShape=null;
        Paint color=MyColorPicker.getValue();

        if(mouseOn && currentShape!=null){
            switch(currentShape){
                case ELLIPSE:
                    double centerPointX= (x+event.getX())/2;
                    double centerPointY= (y+event.getY())/2;
                    double radiusX= Math.abs(x-centerPointX);
                    double radiusY= Math.abs(y-centerPointY);
                    thisShape =new Ellipse(centerPointX,centerPointY,radiusX,radiusY);
                    break;
                case RECTANGLE:
                    double topLeftPointX=Math.min(x, event.getX());
                    double topLeftPointY=Math.min(y, event.getY());
                    double width=Math.abs(event.getX()-x);
                    double height= Math.abs(event.getY()-y);
                    thisShape= new Rectangle(topLeftPointX,topLeftPointY,width,height);
                    break;
                case LINE:
                    thisShape=new Line(x,y,event.getX(),event.getY());
                    break;
            }


            if(currentShape!= DrawShape.ShapeName.LINE && checkBoxFill.isSelected())
                thisShape.setFill(color);
            else {
                thisShape.setStroke(color);
                thisShape.setFill(null);
            }

            pan.getChildren().add(thisShape);
            mouseOn=false;
        }

    }
    //clear the pane for the next time
    @FXML
    void pressClear(ActionEvent event) {
        pan.getChildren().clear();
    }

    //clear shape by shape
    @FXML
    void pressUndo(ActionEvent event) {
        int cnt=pan.getChildren().size();

        if(cnt>0)
            pan.getChildren().remove(cnt-1);
    }


}
