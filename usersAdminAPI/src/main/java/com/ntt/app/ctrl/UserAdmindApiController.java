package com.ntt.app.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ntt.app.constant.Constantes;
import com.ntt.app.helper.LogHelper;
import com.ntt.app.helper.ValidacionHelper;
import com.ntt.app.model.AdministracionModel;
import com.ntt.app.model.NotifModel;
import com.ntt.app.vo.ActividadVO;
import com.ntt.app.vo.integration.UserRequest;
import com.ntt.app.vo.integration.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;



/**
 * The Class UserAdmindApiController.
 */
@Controller
@RestController
public class UserAdmindApiController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAdmindApiController.class);

	/** The administracion model. */
	@Autowired
	private AdministracionModel administracionModel;
	
	/** The notif model. */
	@Autowired
	private NotifModel notifModel;
	
	/** The validacion helper. */
	@Autowired
	private ValidacionHelper validacionHelper;
		
	/** The lh. */
	@Autowired
	private LogHelper lh;
	
	/**
	 * Alta usuario.
	 *
	 * @param userRequest the user request
	 * @param bindingResult the binding result
	 * @return the response entity
	 */
	@Operation(summary = "En caso de que no exista, crea un nuevo usuario en base de datos")
	@ApiResponses(value = { 
			@ApiResponse(responseCode =  Constantes.S_COD_201, description = "Ingresado correctamente",
				content = { 
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,  
			    		schema = @Schema(implementation = UserResponse.class))
				}),
			@ApiResponse(responseCode = Constantes.S_COD_200, description = "El correo ya esta registrado",  
				content = { 
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,  
				    	schema = @Schema(implementation = UserResponse.class))
				}), 
			@ApiResponse(responseCode = Constantes.S_COD_400, description = "Request mal llenado",  
				content = { 
					@Content(
						mediaType = MediaType.APPLICATION_JSON_VALUE,  
						schema = @Schema(implementation = UserResponse.class))
				}),
			@ApiResponse(responseCode = Constantes.S_COD_500, description = "Error durante el procesamiento",  
			content = { 
				@Content(
					mediaType = MediaType.APPLICATION_JSON_VALUE,  
					schema = @Schema(implementation = UserResponse.class))
			}),
	})
	@PostMapping(value = "adminUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<UserResponse> altaUsuario(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
    	
    	LOGGER.info("POST - adminUsuarios");
    	LOGGER.info(lh.neutralize("Request: " + new Gson().toJson(userRequest)));
    	ActividadVO actividadVO = new ActividadVO();
    	UserResponse userResponse = null;
		
		if(validacionHelper.validaRequest(userRequest, bindingResult)) {

			userResponse = administracionModel.administraUsuario(userRequest, actividadVO);
		
		}else {
			
			userResponse = notifModel.creaResponseGenerico(Constantes.S_MSJ_BAD_REQUEST);
			actividadVO.setMalRequest(true);
		}

		return notifModel.creaResponseEntity(userResponse, actividadVO);
		
    }

	
}
