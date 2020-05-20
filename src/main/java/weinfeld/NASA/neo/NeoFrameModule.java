package weinfeld.NASA.neo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class NeoFrameModule extends AbstractModule {

    @Provides
    static NeoService providesNeoService() {
        return new NeoServiceFactory().getInstance();
    }
}
