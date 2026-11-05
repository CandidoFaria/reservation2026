package be.iccbxl.pid.reservationsspringboot.validation;

import be.iccbxl.pid.reservationsspringboot.dto.UserProfileDto;
import be.iccbxl.pid.reservationsspringboot.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Le validateur accepte les deux DTO (inscription et profil) qui portent l'annotation @PasswordMatches
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		String pwd;
		String confirm;

		if (obj instanceof UserRegistrationDto dto) {
			pwd = dto.getPassword();
			confirm = dto.getConfirmPassword();
		} else if (obj instanceof UserProfileDto dto) {
			pwd = dto.getPassword();
			confirm = dto.getConfirmPassword();
		} else {
			return true;
		}

		if (pwd == null || confirm == null) {
			return false;
		}
		return pwd.equals(confirm);
	}
}
