package java4web.entity;

public class Car {


    private Wheel wheels[];

    private Engine engine;

    public Car(Wheel wheels [], Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public void turnOn() throws Exception{
        checkWheels();
        engine.start();
        System.out.println("Car is turned on!");
    }
    private void checkWheels() throws Exception{
        for (Wheel w: wheels) {
            if (w == null){
                throw new Exception("Not enough wheels");
            }
        }
    }
    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Injected car with:" +
                 "\n\tEngine:\n\t\t" + engine.toString() +
                "\n\tWheels:" + representWheels();
    }

    private String representWheels(){
        String result = "";
        int counter = 0;
        for(Wheel wheel: wheels){
            counter++;
            result+= "\n" + counter + ". " + wheel.toString();
        }
        return result;
    }
}
