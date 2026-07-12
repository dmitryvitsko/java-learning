class Transport {
    public double speed;
    public double maxSpeed;
    public double acceleration;
    public double brakingSpeed;
    public int wheelsNumber;

    public void accelerate() {
        if (speed < maxSpeed) {
            speed += acceleration;
        }
    }

    public void brake() {
        if (speed > 0) {
            speed -= brakingSpeed;
        }
    }
}