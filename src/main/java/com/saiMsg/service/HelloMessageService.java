package com.saiMsg.service;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.saiMsg.Model.Message;

@Service
public class HelloMessageService {

    @Value("${slackUri:unknown}")
    private String slackUri;
    
    @Value("${gmailUri:unknown}")
    private String gmailUri;


    public String postMessage(Message msg) {
    	String sucess= null;
        restCall(slackUri,msg);
        restCall(gmailUri,msg);
        return sucess;
    }
    
    public String restCall(String uri,Message msg){
    	/*AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new ConcurrentTaskExecutor(Executors.newSingleThreadExecutor()));

        asyncRestTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(msg), String.class)
                .addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
                    @Override
                    public void onSuccess(ResponseEntity<String> result) {

                        System.out.println(result);
                    }

                    @Override
                    public void onFailure(Throwable ex) {

                        ex.printStackTrace();
                    }
                });
        return null;*/
    	RestTemplate restTemplate = new RestTemplate();
    	return restTemplate.postForObject(uri,msg,String.class);
    		
    }

}
