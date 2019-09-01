package com.hospital;

import com.hospital.domain.XmlDome;
import com.hospital.domain.XmlList;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: xiaofu
 * Date: 2018-1-23
 * Time: 9:11
 * Function:
 */
public class TestJaxb {

    @Test
    public void beanToXML() {
        List<XmlList> list =new ArrayList<>();
        list.add(new XmlList("医生1","主任医生1"));
        list.add(new XmlList("医生2","主任医生2"));
        list.add(new XmlList("医生3","主任医生3"));
        list.add(new XmlList("医生4","主任医生4"));
        list.add(new XmlList("医生5","主任医生5"));
        list.add(new XmlList("医生6","主任医生6"));
        list.add(new XmlList("医生7","主任医生7"));
        list.add(new XmlList("医生8","主任医生8"));
        list.add(new XmlList("医生9","主任医生9"));


        XmlDome xmlDome = new XmlDome(1, "小明", 20,list);

        try {
            JAXBContext context = JAXBContext.newInstance(XmlDome.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(xmlDome, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void XMLStringToBean() {
        try {
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><xmlDome><age>21</age><id>1</id><name>小明</name></xmlDome>";
            JAXBContext context = JAXBContext.newInstance(XmlDome.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XmlDome student = (XmlDome) unmarshaller.unmarshal(new StringReader(xmlStr));
            System.out.println(student.getAge());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
