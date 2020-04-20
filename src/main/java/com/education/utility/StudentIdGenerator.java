package com.education.utility;

import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class StudentIdGenerator {

    public Integer guidGenerator() {
        Random random=new Random();
        Integer generateId=random.nextInt(10000);
        return generateId;
    }

    public String guidGeneratorGroupId() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString().replace("-", "").substring(1, 5);
        return randomUUIDString;
    }


}
