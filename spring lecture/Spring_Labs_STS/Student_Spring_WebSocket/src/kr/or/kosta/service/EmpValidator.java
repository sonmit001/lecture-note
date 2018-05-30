package kr.or.kosta.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.dto.emp;

public class EmpValidator implements Validator{

   @Override
   public boolean supports(Class<?> clazz) {
      return emp.class.isAssignableFrom(clazz);
   }

   @Override
   public void validate(Object target, Errors errors) {
      emp emp=(emp) target;
      
      if(emp.getEname()==null || emp.getEname().trim().isEmpty())
         errors.rejectValue("ename", "required");
   
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mgr", "required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sal", "required");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comm", "required");
      
      if(emp.hasDeptno()) {
         System.out.println(emp.getDeptno());
         if(!emp.getDeptno().equals("10") && !emp.getDeptno().equals("20") && !emp.getDeptno().equals("30"))
         errors.rejectValue("deptno", "depterror");
      }else
         errors.rejectValue("deptno", "nullcheck");
      
   }

}