abstract class AbstractRocketLaunch implements RocketLaunchSequence {
    private final String name;
    private boolean checked = false;
    private boolean purged = false;
    private boolean pulled = false;
    private boolean ignited = false;
    private boolean lifted = false;

    public AbstractRocketLaunch(String name) {
        this.name = name;
    }

    @Override
    public void preLaunchCheck() {
        System.out.println("Проверка");
        checked = true;
    }

    @Override
    public void purge() {
        System.out.println("Продувка");
        purged = true;
    }

    @Override
    public void umbilicalPullOut() {
        System.out.println("Протяжка");
        pulled = true;
    }

    @Override
    public void ignition() {
        System.out.println("Зажигание");
        ignited = true;
    }

    @Override
    public void liftoff() {
        System.out.println("Поехали");
        lifted = true;
    }

    @Override
    public final void executeLaunchSequence() {
        System.out.printf("Запуск %s\n", name);
        System.out.println("Минутная готовность!");
        try {
            int checks = 8;
            while (checks > 0 && !checked) {
                preLaunchCheck();
                System.out.println(".");
                checks--;
            }
            if (!checked) {
                throw new RuntimeException("проверка не прошла");
            }
            int purges = 4;
            while (purges > 0 && !purged) {
                purge();
                System.out.println(".");
                purges--;
            }
            if (!purged) {
                throw new RuntimeException("продувка неуспешна");
            }
            int pulls = 2;
            while (pulls > 0 && !pulled) {
                umbilicalPullOut();
                System.out.println(".");
                pulls--;
            }
            if (!pulled) {
                throw new RuntimeException("протяжка сорвана");
            }
            ignition();
            if (!ignited) {
                throw new RuntimeException("нет зажигания");
            }
            liftoff();
            if (lifted) {
                System.out.println("Пуск успешен!");
            } else {
                throw new RuntimeException("сигнал потерян");
            }
        } catch (Exception e) {
            System.out.println("Пуск отменён: " + e.getMessage());
        }
    }
}
