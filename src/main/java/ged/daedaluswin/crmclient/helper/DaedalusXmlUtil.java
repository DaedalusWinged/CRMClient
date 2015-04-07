package ged.daedaluswin.crmclient.helper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * Created by Romanos Trechlis on 5/4/2015.
 */
public class DaedalusXmlUtil {

    /**
     * Helper method that turns a pojo to an xml that contains only
     * filled fields.
     *
     * @param obj
     * @return
     */
    public static String toXML(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, stringWriter);
        } catch (JAXBException e) {e.printStackTrace();}
        return stringWriter.toString();
    }

    public static Object toPojo(String xml, Class c) {
        Object object = null;
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        try {
            JAXBContext jc = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            object = unmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) stream.close();
            } catch (IOException e) {}
        }
        return object;
    }

/*
    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        contacts.setFirstName("Romanos");
        contacts.setLastName("Trechlis");
        System.out.println(DaedalusXmlUtil.toXML(contacts));
    }
*/
}
