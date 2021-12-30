package com.lrtbl.helloworld.profiles;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnviroment implements EnviromentService{
    @Override
    public String getEnviroment() {
        return "QA";
    }
}
