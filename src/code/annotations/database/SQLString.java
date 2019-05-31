package code.annotations.database;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {

    int value() default  0;

    String name() default "";

    Constraints constraints() default @Constraints/*(unique = true)*/; // 引入别的注解变量，并默认值为注解类变量默认值(嵌套注解)


}
