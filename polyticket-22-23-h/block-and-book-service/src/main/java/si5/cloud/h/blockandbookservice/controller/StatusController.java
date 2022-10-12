package si5.cloud.h.blockandbookservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/status")
public class StatusController {
    RestTemplate rest = new RestTemplate();
    private final String PAYMENT_SEVICE_URI = "https://7-dot-payment-service-dot-stately-command-311914.oa.r.appspot.com";

    @GetMapping()
    public ResponseEntity<String> status() {
        String paymentServiceStatus = rest.getForObject(PAYMENT_SEVICE_URI + "/status", String.class);
        return ResponseEntity.ok()
                .body("BlockAndBook service is up. Fetch Payment Service status: " + paymentServiceStatus);
    }

}