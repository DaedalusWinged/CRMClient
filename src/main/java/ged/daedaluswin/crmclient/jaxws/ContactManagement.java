package ged.daedaluswin.crmclient.jaxws;

import ged.daedaluswin.crmclient.jaxws.artifacts.testclient.ContactManagementWS;
import ged.daedaluswin.crmclient.jaxws.artifacts.testclient.ContactManagementWSService;

/**
 * Created by TeoGia on 04 April 2015.
 */

public class ContactManagement {

    public static String contactList() {
        ContactManagementWSService service = new ContactManagementWSService();
        ContactManagementWS port = service.getContactManagementWSPort();
        return port.getContactList();
    }
}

