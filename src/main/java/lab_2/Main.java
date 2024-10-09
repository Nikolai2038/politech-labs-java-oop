package lab_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        // Create object instance
        MyClass obj = new MyClass();

        // Get all object methods (private included)
        Method[] methods = MyClass.class.getDeclaredMethods();

        for (Method method : methods) {
            // If method has not our annotation - skip it
            if (!method.isAnnotationPresent(MyAnnotation.class)) {
                continue;
            }

            // Skip, if method not protected or private
            if (!Modifier.isProtected(method.getModifiers()) && !Modifier.isPrivate(method.getModifiers())) {
                continue;
            }

            // Make method callable
            method.setAccessible(true);

            // Get annotation parameter
            int timesToExecute = method.getAnnotation(MyAnnotation.class).timesToExecute();

            // Call the method specified number of times
            for (int executionId = 0; executionId < timesToExecute; executionId++) {
                Class<?>[] parameterTypes = method.getParameterTypes();

                // Generate parameters based on their type
                Object[] parameters = new Object[parameterTypes.length];
                for (int parameterId = 0; parameterId < parameterTypes.length; parameterId++) {
                    Class<?> parameterType = parameterTypes[parameterId];
                    if (parameterType == int.class) {
                        parameters[parameterId] = 5;
                    } else if (parameterType == double.class) {
                        parameters[parameterId] = 7.4;
                    } else if (parameterType == float.class) {
                        parameters[parameterId] = 8.3f;
                    } else if (parameterType == boolean.class) {
                        parameters[parameterId] = true;
                    } else if (parameterType == String.class) {
                        parameters[parameterId] = "Lalala";
                    } else {
                        throw new RuntimeException("Parameter type " + parameterType.getName() + " not supported!");
                    }
                }

                // Method call
                try {
                    method.invoke(obj, parameters);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
