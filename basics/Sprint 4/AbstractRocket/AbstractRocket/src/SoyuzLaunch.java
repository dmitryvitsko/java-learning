public class SoyuzLaunch extends AbstractRocketLaunch {

    private int check1 = 0;
    private int check2 = 0;

    public SoyuzLaunch() {
        super("Союз-2Б");
    }

    public SoyuzLaunch(String name) {
        super(name);
    }

    @Override
    public void preLaunchCheck() {
        if (check1 == 0) {
            check1 = 1;
        } else if (check2 == 0) {
            check2 = 1;
        } else {
            super.preLaunchCheck();
        }
    }

}