package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice/{n}")
    public String diceGame(@PathVariable int n) {
        int rando = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        if (n == rando) {
            return "You Win!";
        } else {
            return "You Lose!";
        }
        return "roll-dice";
    }
}
