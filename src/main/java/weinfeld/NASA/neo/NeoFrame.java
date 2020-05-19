package weinfeld.NASA.neo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;

public class NeoFrame extends JFrame {

    public NeoFrame(NearEarthObjectView view, NeoController controller) {
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEO Today");
        setLayout(new BorderLayout());


        add(view, BorderLayout.CENTER);


        controller.requestData();
    }

    public static void main(String[] args) {

        NearEarthObjectView view = new NearEarthObjectView();
        NeoService service = new NeoServiceFactory().getInstance();

        NeoController controller = new NeoController(service, view);
        new NeoFrame(view, controller).setVisible(true);

    }


}
