package com.dev.startproject.library.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;



public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private String firstFieldName;
    private String secondFieldName;
    private String message;
    
    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
    	firstFieldName = constraintAnnotation.first();
    	secondFieldName = constraintAnnotation.second();
    	message = constraintAnnotation.message();
    }
    
	@Override
	public boolean isValid(final Object value,final ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean valid= true;
		try {
			final Object firstObject=new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
			final Object secondObject = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
			
			valid = firstObject==null && secondObject==null || firstObject!=null && firstObject.equals(secondObject);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(!valid) {
			 context.buildConstraintViolationWithTemplate(message)
             .addPropertyNode(firstFieldName)
             .addConstraintViolation()
             .disableDefaultConstraintViolation();
		}
		return valid;
	}

}
