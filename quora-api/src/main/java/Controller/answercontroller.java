package Controller;

import com.upgrad.quora.service.dao.answerrepo;
import com.upgrad.quora.service.entity.answer;
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
public class answercontroller {

    private answerrepo answerRepository;
    public answercontroller(answerrepo answerRepository){
        super();
        this.answerRepository=answerRepository;
    }

    @GetMapping("/answer")
    Collection<answer> answer(){
        return answerRepository.findAll();
    }

    @GetMapping("/answer/{id}")
    ResponseEntity<?> getanswer(@PathVariable Long id){
        Optional<answer> answer = answerRepository.findById(id);
        return answer.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/answer")
    ResponseEntity<answer> createanswer(@Valid @RequestBody answer answer) throws URISyntaxException {
        answer result= answerRepository.save(answer);
        return ResponseEntity.created(new URI("/api/answer" + result.getUuid())).body(result);

    }

    @PutMapping("/answer/{id}")
    ResponseEntity<answer> updateanswer(@Valid @RequestBody answer answer){
        answer result= answerRepository.save(answer);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/answer/{id}")
    ResponseEntity<?> deleteanswer(@PathVariable Long id){
        answerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
