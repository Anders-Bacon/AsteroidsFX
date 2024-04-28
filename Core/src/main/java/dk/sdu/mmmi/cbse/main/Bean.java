package dk.sdu.mmmi.cbse.main;

import javafx.application.Application;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bean extends Application {
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ModuleConfig.class);

        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        Main game = ctx.getBean(Main.class);
        game.start(window);
        game.render();
    }
}