package util;

import model.annotation.Id;
import model.annotation.Positive;
import model.annotation.MaxLength;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationValidator {

    public static String[] validate(Object obj) {
        List<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(Positive.class)) {
                    Positive positive =
                            field.getAnnotation(Positive.class);

                    if (value instanceof Number number
                            && number.doubleValue() <= 0) {
                        errors.add(positive.message());
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength maxLength =
                            field.getAnnotation(MaxLength.class);

                    if (value instanceof String str
                            && str.length() > maxLength.value()) {
                        errors.add("maximum length is " +
                                maxLength.value());
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Unable to validate field: " +
                        field.getName());
            }
        }

        return errors.toArray(new String[0]);
    }
}