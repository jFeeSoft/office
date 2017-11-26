package com.jfeesoft.office.view.validator;

import com.jfeesoft.office.service.SystemUserService;
import org.primefaces.validate.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

@Component
@Scope("request")
public class EmailValidator implements Validator {

    @Autowired
    private SystemUserService userService;

    private ResourceBundle messagesBundle;

    private Pattern pattern;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Application application = context.getApplication();
        ResourceBundle messagesBundle = application.getResourceBundle(context, "msg");

        if(!pattern.matcher(value.toString()).matches()) {
            FacesMessage msg =
                    new FacesMessage(null,messagesBundle.getString("error.email.bad"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        if(userService.existEmail((String)value)){
            FacesMessage msg =
                    new FacesMessage(null,messagesBundle.getString("error.email.exist"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
