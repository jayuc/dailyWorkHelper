package com.github.jayuc.daily.iter;

import java.lang.annotation.*;

/**
 * Created by 余杰 on 2020/3/31 14:27
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataKeyFieldName {
    String value() default "";
}
