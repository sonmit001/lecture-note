package kr.or.kosta.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.dto.emp;

public class JoinCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empno", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ename", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mgr", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hiredate", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sal", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deptno", "required");
		System.out.println("여기는 JoinCommandValidator");
	}

}
