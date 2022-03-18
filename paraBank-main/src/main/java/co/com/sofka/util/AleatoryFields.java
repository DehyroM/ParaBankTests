package co.com.sofka.util;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class AleatoryFields {

    Faker faker = new Faker();

    public List<String> Fields(){

        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String address = faker.address().secondaryAddress();
        String city = faker.address().cityName();
        String state = faker.address().state();
        String zCode = faker.address().zipCode();
        String phone = faker.phoneNumber().cellPhone();
        String ssn = String.valueOf(faker.number().numberBetween(00000001,99999999));
        String user = fName + zCode;
        String pass = lName + ssn;
        String email = fName + "_" + lName + "@gmail.com";

        List<String> fields = new ArrayList<>();

        fields.add(fName);
        fields.add(lName);
        fields.add(address);
        fields.add(city);
        fields.add(state);
        fields.add(zCode);
        fields.add(phone);
        fields.add(ssn);
        fields.add(user);
        fields.add(pass);
        fields.add(fName+" "+lName);
        fields.add(email);
        fields.add("Buen día, mi nombre es "+fName+" "+lName+", mi correo es "+email+", espero que estén bien.");

        return fields;
    }

}
