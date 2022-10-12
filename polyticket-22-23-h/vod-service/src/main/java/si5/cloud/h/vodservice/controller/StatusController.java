package si5.cloud.h.vodservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping()
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body("VOD service is up.");
    }
}