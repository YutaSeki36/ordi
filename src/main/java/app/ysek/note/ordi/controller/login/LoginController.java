package app.ysek.note.ordi.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value="")
    public String loginForm() {
        return "login/loginForm";
    }
}
