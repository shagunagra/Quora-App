package Controller;


import com.upgrad.quora.service.dao.user_authrepo;
import com.upgrad.quora.service.entity.user_auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class user_authcontroller {

    private user_authrepo user_authRepository;
    public user_authcontroller(user_authrepo user_authRepository){
        super();
        this.user_authRepository=user_authRepository;
    }

    @GetMapping("/user_auth")
    Collection<user_auth> user_auth(){
        return user_authRepository.findAll();
    }

    @GetMapping("/user_auth/{id}")
    ResponseEntity<?> getuser_auth(@PathVariable Long id){
        Optional<user_auth> user_auth = user_authRepository.findById(id);
        return user_auth.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user_auth")
    ResponseEntity<user_auth> createuser_auth(@Valid @RequestBody user_auth user_auth) throws URISyntaxException {
        user_auth result= user_authRepository.save(user_auth);
        return ResponseEntity.created(new URI("/api/user_auth" + result.getUuid())).body(result);

    }

    @PutMapping("/user_auth/{id}")
    ResponseEntity<user_auth> updateuser_auth(@Valid @RequestBody user_auth user_auth){
        user_auth result= user_authRepository.save(user_auth);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/user_auth/{id}")
    ResponseEntity<?> deleteuser_auth(@PathVariable Long id){
        user_authRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
