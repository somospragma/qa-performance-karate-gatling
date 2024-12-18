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
        KarateProtocolBuilder protocol = karateProtocol(
                uri("/neg/api/v1/auth/auth").nil()
//                uri("/neg/api/v1/auth/auth").pauseFor(method("post",5))
        );
        //get config params
        Map<String, Object> params = Runner.runFeature("classpath:karate/config.feature", null, true);
        String rampUsers = params.get("rampUsers").toString();
        String during = params.get("during").toString();
        //build scenarios to run
        ScenarioBuilder featureToRun = scenario("test").exec(karateFeature("classpath:karate/test.feature"));
        //set up simulation
        setUp(
                featureToRun.injectOpen(
                        rampUsers(Integer.parseInt(rampUsers)).during(Integer.parseInt(during)),
                        rampUsersPerSec(Integer.parseInt(rampUsers)).to(20).during(Integer.parseInt(during))
                ).protocols(protocol)
        ).assertions(
                forAll().requestsPerSec().around(6.0,11.0),
                forAll().failedRequests().percent().lte(5.0),
                forAll().responseTime().max().lt(1500),
                forAll().successfulRequests().count().gte(100L)
//                details("test","/neg/api/v1/cards/pay").successfulRequests().count().gte(100L)
        );
    }
}
