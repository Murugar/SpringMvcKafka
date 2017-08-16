package com.iqmsoft.kafka.mvc.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerService {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        logger.info("===============================================processMessage===============");
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            logger.info("============Topic:" + entry.getKey());
            System.err.println("============Topic:" + entry.getKey());
            LinkedHashMap<Integer, String> messages = (LinkedHashMap<Integer, String>) entry.getValue();
            Set<Integer> keys = messages.keySet();
            for (Integer i : keys){
            	 logger.info("======Partition:" + i);
            	 System.err.println("======Partition:" + i);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("======Partition is error!======");
                }
            }
            Collection<String> values = messages.values();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
                String message = "["+iterator.next()+"]";
                logger.info("=====message:" + message);
                System.err.println("=====message:" + message);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("======message is error!======");
                }
            }
        }
        
       
    }
}
