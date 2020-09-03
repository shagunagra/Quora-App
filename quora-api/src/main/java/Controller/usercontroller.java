package Controller;


import com.upgrad.quora.service.dao.usersrepo;
import com.upgrad.quora.service.entity.users;
import org.springframework.beans.factory.annotation.Autowired;
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
public class usercontroller {
    @Autowired

    private usersrepo userRepository;
    public usercontroller(usersrepo userRepository){
        super();
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    Collection<users> users(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getusers(@PathVariable Long id){
        Optional<users> users = userRepository.findById(id);
        return users.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/users")
    ResponseEntity<users> createusers(@Valid @RequestBody users users) throws URISyntaxException {
        users result= userRepository.save(users);
        return ResponseEntity.created(new URI("/api/users" + result.getUuid())).body(result);

    }

    @PutMapping("/users/{id}")
    ResponseEntity<users> updateusers(@Valid @RequestBody users users){
        users result= userRepository.save(users);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteusers(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
