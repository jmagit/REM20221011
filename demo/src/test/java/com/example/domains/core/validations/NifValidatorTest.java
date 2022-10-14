package com.example.domains.core.validations;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import lombok.Data;

class NifValidatorTest {

	@Nested
	public class ComoClase {
		@ParameterizedTest
		@ValueSource(strings = { "12345678z", "12345678Z", "4g" })
		@NullSource
		void testIsValidOK(String nif) {
			var val = new NifValidator();
			var actual = val.isValid(nif, null);
			assertTrue(actual);
		}

		@ParameterizedTest
		@ValueSource(strings = { "12345678", "Z", "5555g" })
		@EmptySource
		void testIsValidKO(String nif) {
			var val = new NifValidator();
			var actual = val.isValid(nif, null);
			assertFalse(actual);
		}
	}
	@Nested
	public class ComoAnotacion {
		@Data
		static class Demo {
			@NIF
			String nif;
		}
		
		@Test
		void valida() {
			var demo = new Demo();
			demo.setNif("12345678z");
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			var rslt = validator.validate(demo);
			assertEquals(0, rslt.size());
		}
		
		@Test
		void invalida() {
			var demo = new Demo();
			demo.setNif("12345678");
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			var rslt = validator.validate(demo);
			assertEquals(1, rslt.size());
		}
	}

}
