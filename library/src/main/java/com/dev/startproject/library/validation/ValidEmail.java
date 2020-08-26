package com.dev.startproject.library.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.TYPE ,ElementType.ANNOTATION_TYPE ,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {

	String message() default "Duplicate Email Id";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
	
}
