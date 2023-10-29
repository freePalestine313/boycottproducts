package com.freepalesting313.boycottproducts.dataservices;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class FileReader {

    public Flux<String> getDataStream() {
        ClassPathResource resource = new ClassPathResource("boycott.json");

        return Flux.create(emitter -> {
            try {
                InputStream inputStream = resource.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    emitter.next(line);
                }
                emitter.complete();
            } catch (IOException e) {
                emitter.error(e);
            }
        });
    }
}
