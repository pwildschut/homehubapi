package homehub.homehubapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException {
    private String resourceName;
    private Object fieldValue;

    public ResourceExistsException(String resourceName,  Object fieldValue) {
        super(String.format("%s exists already with id : '%s'", resourceName,fieldValue));
        this.resourceName= resourceName;
        this.fieldValue=fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
