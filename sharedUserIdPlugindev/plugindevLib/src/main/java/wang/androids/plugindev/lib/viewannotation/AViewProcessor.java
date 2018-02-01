package wang.androids.plugindev.lib.viewannotation;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/14.
 */

public class AViewProcessor {
    Object controller;
    static AViewProcessor processor;

    public static void init(Object controller) {
        if (processor == null) {
            processor = new AViewProcessor();
        }
        processor.controller = controller;
        processor.parseMethod(controller.getClass());
    }

    public void parseMethod(final Class<?> clazz) {
        Object obj = null;
        try {
            obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
//        final Method[] methods = clazz.getDeclaredMethods();
        if (clazz.isAnnotationPresent(AView.class)) {
            final AView my = clazz.getAnnotation(AView.class);
            int i = my.layoutResID();
            if (controller instanceof Activity) {
                ((Activity) controller).setContentView(i);
            }

        }
//        for (final Method method : methods) {
//            final AView my = method.getAnnotation(AView.class);
//            if (null != my) {
//                try {
//                    int i = my.layoutResID();
//                    if (controller instanceof Activity) {
//                        ((Activity) controller).setContentView(i);
//                    }
//                    if (controller instanceof AppCompatActivity) {
//                        ((Activity) controller).setContentView(i);
//                        LayoutXMLParser pa = new LayoutXMLParser();
//                        pa.parser(((AppCompatActivity) controller).getApplication().getApplicationContext(), i);
//                    }
//                    break;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
    }
}
