import ua.application.builder.Builder;
import ua.application.builder.Configuration;


public class Application {

    public static void main(String[] args) {

            new Builder(Configuration.workingDirectory).build();

    }
}
