/**
 * 
 */
package com.saiMsg.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saiMsg.Model.Message;

/**
 * @author Saikrishna Gudla
 *
 */

@RestController
public class HelloMessageController {
	
	@Value("${slackUri:unknown}")
    private String slackUri;
    
    @Value("${gmailUri:unknown}")
    private String gmailUri;
	
	@PostMapping(path="/notify")
	public @ResponseBody String postMsg(@RequestBody Message msg){
		restCall(slackUri,msg);
        restCall(gmailUri,msg);
		return "sucess";
		
	}
	
	@GetMapping(path="/notify")
	public @ResponseBody String getMsg(){
		return "sucess";
		
	}
	
	 public String restCall(String uri,Message msg){
	    	RestTemplate restTemplate = new RestTemplate();
	    	return restTemplate.postForObject(uri,msg,String.class);
	    		
	    }

}
