package com.ntt.app.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ntt.app.vo.ActividadVO;
import com.ntt.app.vo.integration.UserResponse;

/**
 * The Class NotifModel.
 */
@Component
public class NotifModel {

	/**
	 * Crea response generico.
	 *
	 * @param mensaje the mensaje
	 * @return the user response
	 */
	public UserResponse creaResponseGenerico(String mensaje) {
		UserResponse userResponse = new UserResponse();
		userResponse.setMessage(mensaje);
		return userResponse;
	}

	/**
	 * Crea response entity.
	 *
	 * @param userResponse the user response
	 * @param actividadVO the actividad VO
	 * @return the response entity
	 */
	public ResponseEntity<UserResponse> creaResponseEntity(UserResponse userResponse, ActividadVO actividadVO) {
		ResponseEntity<UserResponse> responseEntity = null;
		if(actividadVO.isCreo()) {
			responseEntity = new ResponseEntity<>(userResponse, HttpStatus.CREATED);	
		}else if (actividadVO.isActualizo()) {
			responseEntity = new ResponseEntity<>(userResponse, HttpStatus.OK);
		}else if(actividadVO.isEncontro()) {
			responseEntity = new ResponseEntity<>(userResponse, HttpStatus.OK);	
		}else if(actividadVO.isMalRequest()) {
			responseEntity = new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
		}else {
			responseEntity = new ResponseEntity<>(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return responseEntity;
	}

}
