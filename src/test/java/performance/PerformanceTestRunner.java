package performance;


import com.intuit.karate.gatling.javaapi.KarateProtocolBuilder;
import com.intuit.karate.Runner;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.util.Map;

import static com.intuit.karate.gatling.javaapi.KarateDsl.*;
import static io.gatling.javaapi.core.CoreDsl.*;

public class PerformanceTestRunner extends Simulation {


    public PerformanceTestRunner() {

        // Define el protocolo para agrupar métricas por endpoint
        // Puedes agregar más endpoints si es necesario (Solo es requerido si se tiene un parametro variante en la url como id, page, etc)
        KarateProtocolBuilder protocol = karateProtocol(
                uri("/posts").nil(),
                uri("/comments").nil(),
                uri("/posts/1/comments").nil()
//                uri("/neg/api/v1/auth/auth").pauseFor(method("post",5))
        );

        // Obtén parámetros dinámicos desde config.feature
        Map<String, Object> params = Runner.runFeature("classpath:karate/config.feature", null, true);
        String rampUsers = params.get("rampUsers").toString();
        String during = params.get("during").toString();

        // Define el escenario que ejecuta tu feature, se puedene definir más escenarios si es necesario
        ScenarioBuilder posts = scenario("test get posts").exec(karateFeature("classpath:karate/testPosts.feature","@posts"));
        ScenarioBuilder users = scenario("test get users").exec(karateFeature("classpath:karate/testUsers.feature"));


        // Configura la simulación
        setUp(
                //duracion de la prueba en segundos y usuarios concurrentes
                posts.injectOpen(rampUsers(Integer.parseInt(rampUsers)).during(Integer.parseInt(during)),
                        rampUsersPerSec(Integer.parseInt(rampUsers)).to(20).during(Integer.parseInt(during))).protocols(protocol),
                users.injectOpen(rampUsers(Integer.parseInt(rampUsers)).during(Integer.parseInt(during)),
                        rampUsersPerSec(Integer.parseInt(rampUsers)).to(20).during(Integer.parseInt(during))).protocols(protocol)
        ).assertions(
                forAll().requestsPerSec().around(6.0,11.0),
                forAll().failedRequests().percent().lte(5.0),
                forAll().responseTime().max().lt(1500),
                forAll().successfulRequests().count().gte(100L)
        );
    }
}
