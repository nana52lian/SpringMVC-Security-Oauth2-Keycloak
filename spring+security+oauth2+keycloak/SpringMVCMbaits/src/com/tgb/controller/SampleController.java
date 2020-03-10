package com.tgb.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.*;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

@Controller
@PropertySource(value="classpath:config/oauth2.properties")
public class SampleController {
    public static final Logger logger = Logger.getLogger(SampleController.class);

	@Value("${accessTokenUri}")
    public String ACCESS_TOKEN_URI;
	@Value("${userAuthorizationUri}")
    public String USER_AUTHORIZATION_URI;
	@Value("${userInfoUri}")
    public String USER_INFO_URL;

	public String ACCOUNT_SERVICE="http://localhost:8080/auth/realms/spring-security-oauth2/account";
	public String END_SESSION_ENDPOINT="http://localhost:8080/auth/realms/spring-security-oauth2/protocol/openid-connect/logout";
    private RestOperations restTemplate;

    @RequestMapping(value = "/index", method = GET)
    public String top() {
        return "index";
    }

    @RequestMapping(value="/userinfo", method = GET)

    public String index(Model model) throws JsonParseException, JsonMappingException, IOException {

    	// RestTemplateでリソースの取得を行う
    	String result = restTemplate.getForObject(ACCOUNT_SERVICE, String.class);
    	logger.info(result);
    	ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = mapper.readValue(result, HashMap.class);
        model.addAttribute("informations", map);
        return "userinfo";
    }
//    @RequestMapping(value="/logout", method = POST)
//    public String logout(Model model) throws JsonParseException, JsonMappingException, IOException {
//    	// RestTemplateでリソースの取得を行う
//    	String result = restTemplate.getForObject(END_SESSION_ENDPOINT, String.class);
//    	logger.info(result);
//        return "index";
//    }

    public void setRestTemplate(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}