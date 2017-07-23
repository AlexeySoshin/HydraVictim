package me.soshin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam final String login,
                                        @RequestParam("passw") final String password) {

        logger.info(String.format("%s %s", login, password));

        if ("admin".equals(login) && "0723".equals(password) ||
                "administrator".equals(login) && "qwer1234".equals(password)) {
            logger.info("All good!");
            return new ResponseEntity<>("User logged in", HttpStatus.OK);
        }

        return new ResponseEntity<>("<html><body><div style = 'color: red;'>Bad credentials</div></html>", HttpStatus.OK);
    }

    @GetMapping("/login")
    public void dummy() {
        logger.error("If you hit this, you're doing something wrong");
    }
}
