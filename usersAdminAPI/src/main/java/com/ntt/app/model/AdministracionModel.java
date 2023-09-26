package com.ntt.app.model;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntt.app.constant.Constantes;
import com.ntt.app.helper.MapperHelper;
import com.ntt.app.repository.UserRepository;
import com.ntt.app.vo.ActividadVO;
import com.ntt.app.vo.entity.UserEntity;
import com.ntt.app.vo.integration.UserRequest;
import com.ntt.app.vo.integration.UserResponse;

/**
 * The Class AdministracionModel.
 */
@Component
public class AdministracionModel {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministracionModel.class);

	/** The user repository. */
	@Autowired
	UserRepository userRepository;
	
	/** The mapper helper. */
	@Autowired
	MapperHelper mapperHelper;
	
	/** The notif model. */
	@Autowired
	NotifModel notifModel;
	
	/**
	 * Administra usuario.
	 *
	 * @param userRequest the user request
	 * @param actividadVO the actividad VO
	 * @return the user response
	 */
	public UserResponse administraUsuario(UserRequest userRequest, ActividadVO actividadVO) {
		
		UserResponse userResponse = new UserResponse();
		UserEntity buscadoEnDB = userRepository.findByEmail(userRequest.getEmail()); 
		try {		
	
			if(null == buscadoEnDB) {
				
				UserEntity userEntity = mapperHelper.mapeaObjetoDB(userRequest);
				LOGGER.info("Insertando...");
				userRepository.save(userEntity);
				userResponse = notifModel.creaResponseGenerico(Constantes.S_MSJ_INSERT_EXITO);
				userResponse.setCreated(userEntity.getCreated());
				userResponse.setLastLogin(userEntity.getLastLogin());
				userResponse.setModified(userEntity.getModified());
				userResponse.setUsuarioActivo(userEntity.isUsuarioActivo());
				actividadVO.setCreo(true);
				LOGGER.info("Cliente insertado en DB: " + userRequest.getEmail());
	
			}else {
				
				userResponse = notifModel.creaResponseGenerico(Constantes.S_MSJ_YA_EXISTE);
				
				Timestamp lastLogin = new Timestamp(new Date().getTime());
				LOGGER.info("Actualizando...");
				buscadoEnDB.setLastLogin(lastLogin);
				
				userRepository.save(buscadoEnDB);
				
				LOGGER.info("Cliente actualizado en DB: " + userRequest.getEmail());	
				userResponse.setCreated(buscadoEnDB.getCreated());
				userResponse.setLastLogin(lastLogin);
				userResponse.setModified(buscadoEnDB.getModified());
				userResponse.setUsuarioActivo(buscadoEnDB.isUsuarioActivo());
				actividadVO.setEncontro(true);	
				
			}
		}catch (Exception e) {
			LOGGER.error("Error en la integracion de DB");
			actividadVO.setEncontro(true);
		}
		
		return userResponse;
	}

}
