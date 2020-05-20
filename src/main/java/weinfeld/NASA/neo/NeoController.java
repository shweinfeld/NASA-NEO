package weinfeld.NASA.neo;

import com.google.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Request data from the NeoService and populate the View
 */

public class NeoController implements Callback<NeoFeed> {

        private NeoService service;
        private NearEarthObjectView view;

        @Inject
        public NeoController(NeoService service, NearEarthObjectView view) {
             this.service = service;
             this.view = view;
        }

        public void requestData() {
            service.getAsteroids("2020-05-05", "2020-05-05").enqueue(this);
        }

                @Override
                public void onResponse(Call<NeoFeed> call, Response<NeoFeed> response) {

                    NeoFeed.NearEarthObject nearEarthObject = response.body().getFirstObject("2020-05-05");
                    view.setNearEarthObject(nearEarthObject);
                }

                @Override
                public void onFailure(Call<NeoFeed> call, Throwable t) {
                    t.printStackTrace();
                }

}
