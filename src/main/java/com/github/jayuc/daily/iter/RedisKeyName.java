package com.github.jayuc.daily.iter;

import java.lang.annotation.*;

/**
 * Created by 余杰 on 2020/3/31 14:23
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisKeyName {
    String value() default "";
}
