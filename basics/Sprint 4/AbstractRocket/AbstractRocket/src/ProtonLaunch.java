import java.util.ArrayList;
import java.util.List;

public class ProtonLaunch extends SoyuzLaunch {

    List<SoyuzLaunch> parts = new ArrayList<>();

    public ProtonLaunch() {
        super("Протон-М");
        for (int p = 1; p <= 4; p++) {
            parts.add(new SoyuzLaunch("Протон-М."+p));
        }
    }

    @Override
    public void preLaunchCheck() {
        for (SoyuzLaunch s : parts) {
            s.preLaunchCheck();
        }
        super.preLaunchCheck();
    }

    @Override
    public void purge() {
        for (SoyuzLaunch s : parts) {
            s.purge();
        }
        super.purge();
    }

    @Override
    public void ignition() {
        for (SoyuzLaunch s : parts) {
            s.ignition();
        }
        super.ignition();
    }
}