package vn.com.imic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import vn.com.imic.model.Giaovien;

@Component
public class GiaovienValidator	implements Validator {

	@Autowired
	@Qualifier("emailValidator")
	emailValidator emailValidator;



	@Override
	public boolean supports(Class<?> clazz) {
		
		return  Giaovien.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Giaovien giaovien = (Giaovien) target;
		ValidationUtils.rejectIfEmpty(errors, "ten", "giaovien.form.empty.ten");
		ValidationUtils.rejectIfEmpty(errors, "diachi", "giaovien.form.empty.diachi");
		ValidationUtils.rejectIfEmpty(errors,"ngaysinh","giaovien.form.empty.ngaysinh");
		ValidationUtils.rejectIfEmpty(errors, "quequan", "giaovien.form.empty.quequan");
		ValidationUtils.rejectIfEmpty(errors, "email", "giaovien.form.empty.email");
		ValidationUtils.rejectIfEmpty(errors, "sdt", "giaovien.form.empty.sdt");
		ValidationUtils.rejectIfEmpty(errors, "namvaonghe", "giaovien.form.empty.namvaonghe");
		ValidationUtils.rejectIfEmpty(errors,"trinhdo","giaovien.form.empty.trinhdo");

		if((giaovien.getTen().length()< 6) ||(giaovien.getTen().length()> 30)){
			errors.rejectValue("ten", "giaovien.form.error.ten");
		}


		if(!emailValidator.valid(giaovien.getEmail())){
			errors.rejectValue("email", "giaovien.userForm.email");
		}

		if ((giaovien.getSdt().length()< 9) ||(giaovien.getSdt().length()> 12)){
			errors.rejectValue("sdt","giaovien.userForm.phone");
		}


	}


}
