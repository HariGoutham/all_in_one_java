package com.example.demo.utilities;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class SetterGetterUtil {

    /*
    This method is used to set fields from one object to other object
     */
    public static <T> void setFields(T fromObject, T toObject) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = fromObject.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (Objects.nonNull(callGetter(f.getName(), fromObject))) {
                callSetter(toObject, f.getName(), callGetter(f.getName(), fromObject));
            }
        }
    }

    /*
    This is a getter method which gives the value with field name as parameter
     */
    public static Object callGetter(String fieldName, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
        return pd.getReadMethod().invoke(obj);
    }

    /*
    This is a setter method which sets the value with field name as parameter
     */
    public static void callSetter(Object obj, String fieldName, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
        pd.getWriteMethod().invoke(obj, value);
    }
}
