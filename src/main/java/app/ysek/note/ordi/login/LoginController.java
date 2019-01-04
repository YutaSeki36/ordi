package app.ysek.note.ordi.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(value="")
    public String loginForm() {
        return "login/loginForm";
    }
}
