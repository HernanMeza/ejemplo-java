package com.ntt.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.google.gson.Gson;
import com.ntt.app.helper.ValidacionHelper;
import com.ntt.app.vo.integration.UserRequest;

/**
 * The Class ValidacionHelperTest.
 */
@SpringBootTest
public class ValidacionHelperTest {

    /** The validacion helper. */
    @Autowired
    private ValidacionHelper validacionHelper;

    /**
     * Test valida request valid user request returns true.
     */
    @Test
    public void testValidaRequest_ValidUserRequest_ReturnsTrue() {
         
        String json = "{\r\n"
        		+ "    \"name\": \"Hernan Meza Rivera\",\r\n"
        		+ "    \"email\": \"hernan.meza.ri@gmail.com\",\r\n"
        		+ "    \"password\": \"Mip@ssw0rd\",\r\n"
        		+ "    \"phones\": [\r\n"
        		+ "      {\r\n"
        		+ "        \"number\": \"966002658\",\r\n"
        		+ "        \"citycode\": \"1\",\r\n"
        		+ "        \"countrycode\": \"57\"\r\n"
        		+ "      }\r\n"
        		+ "    ]\r\n"
        		+ "}";
        
        UserRequest userRequest = new Gson().fromJson(json, UserRequest.class); 
        BindingResult bindingResult = new BeanPropertyBindingResult(userRequest, "userRequest");
        boolean result = validacionHelper.validaRequest(userRequest, bindingResult);
        assertTrue(result);
    }

    /**
     * Test valida request invalid user request returns false.
     */
    @Test
    public void testValidaRequest_InvalidUserRequest_ReturnsFalse() {

    	String json = "{\r\n"
        		+ "    \"name\": \"Hernan Meza Rivera\",\r\n"
        		+ "    \"email\": \"hernan.meza.ri@gmail.com\",\r\n"
        		+ "    \"password\": \"Mip@ssw0rd\",\r\n"
        		+ "    \"phones\": [\r\n"
        		+ "      {\r\n"
        		+ "        \"number\": \"966002658\",\r\n"
        		+ "        \"citycode\": \"1\",\r\n"
        		+ "        \"countrycode\": \"57\"\r\n"
        		+ "      }\r\n"
        		+ "    ]\r\n"
        		+ "}";
        
        UserRequest userRequest = new Gson().fromJson(json, UserRequest.class);

        BindingResult bindingResult = new BeanPropertyBindingResult(userRequest, "userRequest");
        bindingResult.reject("fieldName", "Error message");

        boolean result = validacionHelper.validaRequest(userRequest, bindingResult);
        assertFalse(result);
    }
}
