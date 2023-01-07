package io;

import model.Info;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterXml {

    private static final Logger logger = Logger.getLogger(WriterXml.class.getName());

    private WriterXml() {
    }

    public static void generateXmlReq(Info Info) {

        try {
            logger.log(Level.INFO, "XML started");

            JAXBContext jaxbContext = JAXBContext.newInstance(Info.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Directory created successfully");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Directory already created", ioEx);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(Info, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML failed", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML marshalling finished successfully");
    }
}


