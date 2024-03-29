package com.codeup.other;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String rollPage() {
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String guessPage(@PathVariable int guess, Model model) {
        int rand = getRandInt();
        model.addAttribute("roll", rand)
                .addAttribute("guess", guess)
                .addAttribute("result", rand == guess);
        return "/dice-results";
    }

    public int getRandInt() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 6 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }

}
