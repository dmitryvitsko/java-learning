public interface RocketLaunchSequence {

    void preLaunchCheck();

    void purge();

    void umbilicalPullOut();

    void ignition();

    void liftoff();

    void executeLaunchSequence();
}