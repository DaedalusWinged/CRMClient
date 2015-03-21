package ged.daedaluswin.jaxws;

import ged.daedaluswin.jaxws.artifacts.testclient.UserOperationService;
import ged.daedaluswin.jaxws.artifacts.testclient.UserOperationServiceService;

/**
 * Created by Romanos Trechlis on 20/3/2015.
 */
public class TestWS {

    public static void main(String[] args) {
        UserOperationServiceService service = new UserOperationServiceService();
        UserOperationService port = service.getUserOperationServicePort();
        System.out.println(port.sayHello("Romanos"));
    }
}
