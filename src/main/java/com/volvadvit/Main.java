package com.volvadvit;

import com.volvadvit.models.Contact;
import com.volvadvit.models.ContactType;
import com.volvadvit.models.User;
import com.volvadvit.xml.UserXmlConverter;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    private final UserXmlConverter converter = new UserXmlConverter();

    public static void main(String[] args) {
        Main m = new Main();
        User user = new User(
                1L,
                "John",
                24,
                List.of(
                        new Contact(ContactType.EMAIL, "email.com"),
                        new Contact(ContactType.PHONE, "+1111111")
                        )
        );
        String xmlResult = m.convertUserToXml(user);
        System.out.println(xmlResult);
        User userResult = m.getUserFromXml(xmlResult);
        System.out.println(userResult);
    }

    private String convertUserToXml(final User user) {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            converter.marshalUser(user, baos);
            return baos.toString(StandardCharsets.UTF_8);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return "error";
        }
    }

    private User getUserFromXml(String xml) {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
            return converter.unmarshalUser(bais);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
