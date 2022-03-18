package co.com.sofka.util;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.util.AleatoryFields;

import java.util.List;

public class fillRegisterFields{

    private AleatoryFields aleatoryFields;
    private ParabankModel parabankModel;

    public void registerFields(){

        aleatoryFields = new AleatoryFields();
        List<String> newFields = aleatoryFields.Fields();

        parabankModel = new ParabankModel();

        parabankModel.setFirstNameRegister(newFields.get(0));
        parabankModel.setLastNameRegister(newFields.get(1));
        parabankModel.setAddressRegister(newFields.get(2));
        parabankModel.setCityRegister(newFields.get(3));
        parabankModel.setStateRegister(newFields.get(4));
        parabankModel.setZipCodeRegister(newFields.get(5));
        parabankModel.setPhoneRegister(newFields.get(6));
        parabankModel.setSsnRegister(newFields.get(7));
        parabankModel.setUsernameRegister(newFields.get(8));
        parabankModel.setPasswordRegister(newFields.get(9));
        parabankModel.setConfirmPassRegister(newFields.get(9));

    }

}
