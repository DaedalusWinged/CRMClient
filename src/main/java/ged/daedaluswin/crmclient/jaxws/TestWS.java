package ged.daedaluswin.crmclient.jaxws;

import ged.daedaluswin.crmclient.jaxws.artifacts.testclient.UserOperationService;
import ged.daedaluswin.crmclient.jaxws.artifacts.testclient.UserOperationServiceService;

/**
 * Created by Romanos Trechlis on 20/3/2015.
 */

public class TestWS {

    public static String Greetings(String name) {
        UserOperationServiceService service = new UserOperationServiceService();
        UserOperationService port = service.getUserOperationServicePort();
        return port.sayHello(name);
    }
}
