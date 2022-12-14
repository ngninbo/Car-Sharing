import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Field field;
        try {
            field = object.getClass().getDeclaredField(fieldName);
            if (Modifier.isPrivate(field.getModifiers())) {
                return null;
            } else {
                return field.get(object);
            }
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

}