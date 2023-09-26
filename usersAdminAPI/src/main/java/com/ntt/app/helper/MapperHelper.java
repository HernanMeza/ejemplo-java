package com.ntt.app.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ntt.app.vo.entity.PhoneEntity;
import com.ntt.app.vo.entity.UserEntity;
import com.ntt.app.vo.integration.Phone;
import com.ntt.app.vo.integration.UserRequest;

/**
 * The Class MapperHelper.
 */
@Component
public class MapperHelper {

	/**
	 * Mapea objeto DB.
	 *
	 * @param userRequest the user request
	 * @return the user entity
	 */
	public UserEntity mapeaObjetoDB(UserRequest userRequest) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setName(userRequest.getName());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setPassword(userRequest.getPassword());
		userEntity.setCreated(timestamp);
		userEntity.setLastLogin(timestamp);
		userEntity.setModified(timestamp);
		userEntity.setUsuarioActivo(true);
		List<PhoneEntity> phonesEntityList = new ArrayList<PhoneEntity>();
		for (Phone tmp : userRequest.getPhones()){
			PhoneEntity tmp2 = new PhoneEntity(tmp.getNumber(), tmp.getCitycode(), tmp.getCountrycode(), userEntity);			
			tmp2.setCreated(timestamp);
			tmp2.setLastLogin(timestamp);
			tmp2.setModified(timestamp);
			phonesEntityList.add(tmp2);	
		}
		
		userEntity.setPhones(phonesEntityList);
		
		return userEntity;
	}
}
