import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public class MyProjectController {
    final int SIZE= 10;//size of pixel

    @FXML
    private Canvas canv;
    private GraphicsContext gc;

    //draw the matrix
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        int i=0,j=0;

        //create the matrix
        while(i< canv.getHeight()){
            while(j<canv.getWidth()) {
                gc.strokeRect(0 + i, 0 + j, SIZE, SIZE);
                j+= SIZE;
            }
            j=0;
            i+=SIZE;
        }
    }

    @FXML
    void btnPressed(ActionEvent event) {
         draw();
    }

    //draw the squares
    public void draw() {
        gc.clearRect(0,0,canv.getWidth(), canv.getHeight());//clear between pass

        initialize();//create the matrix after clear

        Random r=new Random();
        int x=0,y=0,i=0,tenPercent;

        tenPercent=((int)canv.getHeight()*(int)canv.getWidth()/100)/100*10;//calculate 10%

        while(i<tenPercent){
            x=r.nextInt((int)canv.getWidth());//max number random
            x=x/10*10;//check the num is 10 divided
            y=r.nextInt((int)canv.getHeight());
            y=y/10*10;

            gc.fillRect(x,y,SIZE,SIZE);//draw squares

            i++;
        }
    }

}

