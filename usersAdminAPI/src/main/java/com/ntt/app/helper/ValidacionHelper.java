package com.ntt.app.helper;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ntt.app.vo.integration.UserRequest;

import jakarta.validation.Valid;

/**
 * The Class ValidacionHelper.
 */
@Component
public class ValidacionHelper {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidacionHelper.class);
	
    /** The s regex email. */
    @Value("${custom.app.regex.email}")
	public String S_REGEX_EMAIL;
	
    /** The s regex pass. */
    @Value("${custom.app.regex.pass}")
	public String S_REGEX_PASS;
	
	/**
	 * Valida request.
	 *
	 * @param userRequest the user request
	 * @param bindingResult the binding result
	 * @return true, if successful
	 */
	public boolean validaRequest(@Valid UserRequest userRequest, BindingResult bindingResult) {
		
		LOGGER.info("Validando request...");
		boolean peticionOK = false; 
		boolean emailConFormato = false;
		boolean passwordConFormato = false;
		boolean camposInformados = false;
		boolean listaTelefonosInformada = false;
		
		try {
		
			listaTelefonosInformada = !userRequest.getPhones().isEmpty();
			camposInformados = !bindingResult.hasErrors() && listaTelefonosInformada;
	    
			emailConFormato = Pattern.compile(this.S_REGEX_EMAIL).matcher(userRequest.getEmail()).matches();
			passwordConFormato = Pattern.compile(this.S_REGEX_PASS).matcher(userRequest.getPassword()).matches();
			LOGGER.info("Formato Email: " + emailConFormato);
			LOGGER.info("Formato Password: " + passwordConFormato);
			LOGGER.info("Campos informados: " + camposInformados);
			peticionOK =  emailConFormato && passwordConFormato && camposInformados;
			LOGGER.info("Peticion OK: " + peticionOK);		
		
		}catch (Exception e) {
			LOGGER.error("Error durante la validacion del request");
			peticionOK = false;
		}
		
		return peticionOK;
		
	}

}
