package weinfeld.NASA.neo;

import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NeoControllerTest {

    @Test
    public void requestData() {

        //given
        NearEarthObjectView view = mock(NearEarthObjectView.class);
        NeoService service = mock(NeoService.class);
        Call<NeoFeed> call = mock(Call.class);
        doReturn(call).when(service).getAsteroids("2020-05-05", "2020-05-05");
        NeoController controller = new NeoController(service, view);

        //when
        controller.requestData();

        //then
        verify(call).enqueue(controller);

    }

    @Test
    public void onResponse() {

        //given
        NearEarthObjectView view = mock(NearEarthObjectView.class);
        NeoService service = mock(NeoService.class);
        NeoController controller = new NeoController(service, view);
        Call<NeoFeed> call = mock(Call.class);
        Response<NeoFeed> response = mock(Response.class);

        NeoFeed.NearEarthObject neo = new NeoFeed.NearEarthObject();
        NeoFeed feed =  mock(NeoFeed.class);
        doReturn(neo).when(feed).getFirstObject("2020-05-05");

        doReturn(feed).when(response).body();

        //when
        controller.onResponse(call, response);

        //then
        verify(view).setNearEarthObject(neo);

    }
}