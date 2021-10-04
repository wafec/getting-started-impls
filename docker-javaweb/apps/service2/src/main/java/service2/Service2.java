package service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.client.WebClient.UriSpec;
import static org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import static org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import static org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@RestController
public class Service2 {
    @GetMapping("/")
    public String index() {
        return WebClient.builder()
                .baseUrl("http://service1.apps.internal:8080")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s%n", name);
    }
}