package Controller;


import com.upgrad.quora.service.dao.questionrepo;
import com.upgrad.quora.service.entity.question;
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
public class questioncontroller {

    private questionrepo questionRepository;
    public questioncontroller(questionrepo questionRepository){
        super();
        this.questionRepository=questionRepository;
    }

    @GetMapping("/question")
    Collection<question>question(){
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    ResponseEntity<?> getquestion(@PathVariable Long id){
        Optional<question> question = questionRepository.findById(id);
        return question.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/question")
    ResponseEntity<question> createquestion(@Valid @RequestBody question question) throws URISyntaxException {
        question result= questionRepository.save(question);
        return ResponseEntity.created(new URI("/api/question" + result.getUuid())).body(result);

    }

    @PutMapping("/question/{id}")
    ResponseEntity<question> updatequestion(@Valid @RequestBody question question){
        question result= questionRepository.save(question);
        return ResponseEntity.ok().body(result);
    }


    @DeleteMapping("/question/{id}")
    ResponseEntity<?> deletequestion(@PathVariable Long id){
        questionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
