package com.interswitch.webservicepractice;

import com.interswitch.webservicepractice.model.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.StringWriter;

@SpringBootApplication
public class WebServicePracticeApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(WebServicePracticeApplication.class, args);

		Person person = new Person();
		person.setName("John Doe");
		person.setAge("25");

		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = context.createMarshaller();

		StringWriter writer = new StringWriter();
		marshaller.marshal(person, writer);

		System.out.println(writer.toString());

		//UNMARSHALLING
		Unmarshaller unmarshaller = context.createUnmarshaller();
		File file = new File("person.xml");

		Person per = (Person) unmarshaller.unmarshal(file);
		System.out.println(per.toString());



	}

}
