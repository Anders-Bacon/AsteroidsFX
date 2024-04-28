package dk.sdu.mmmi.cbse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequestMapping("/attributes")
@RestController
@CrossOrigin

public class    ScoreSystem {

    private long totalScore = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoreSystem.class, args);
    }
    @GetMapping("/score")
    public long getScore() {
        return totalScore;
    }

    @GetMapping("/score/update/{score}")
    public Long updateScore(@PathVariable(value = "score") long score) {
        totalScore += score;
        return totalScore;
    }

}
