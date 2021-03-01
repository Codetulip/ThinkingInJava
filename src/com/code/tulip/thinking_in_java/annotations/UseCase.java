/**
 * @AnnotationName Test
 * @Description 新注解创建基础
 * @author code-tulip
 * @Date 2019/5/26 10:15 PM
 * @Version 1.0
 */

package com.code.tulip.thinking_in_java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // 元注解，定义注解的使用地方
@Retention(RetentionPolicy.RUNTIME) // 元注解，定义注解保留程度RUNTIME程度表示可以利用反射机制读取注解信息
public @interface UseCase {

    int id() default -1;

    String description() default "";  // null不能作为默认值
}
