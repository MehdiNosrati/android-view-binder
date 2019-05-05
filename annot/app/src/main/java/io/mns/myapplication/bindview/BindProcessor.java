package io.mns.myapplication.bindview;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class BindProcessor {
    public static void bind(Activity act) {
        try {
            Field[] fields = act.getClass().getFields();
            for (Field field : fields) {
                if (!View.class.isAssignableFrom(field.getType())) continue;
                BindWithId annot = field.getAnnotation(BindWithId.class);
                if (annot != null) {
                    field.setAccessible(true);
                    field.set(act, act.findViewById(annot.value()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void bindDeclared(Activity act) {
        try {
            Field[] fields = act.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!View.class.isAssignableFrom(field.getType())) continue;
                BindWithId annot = field.getAnnotation(BindWithId.class);
                if (annot != null) {
                    field.setAccessible(true);
                    field.set(act, act.findViewById(annot.value()));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
