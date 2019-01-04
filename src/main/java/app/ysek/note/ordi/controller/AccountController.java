package app.ysek.note.ordi.controller;

import app.ysek.note.ordi.domain.Account;
import app.ysek.note.ordi.domain.form.AccountForm;
import app.ysek.note.ordi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ModelAttribute
    public AccountForm setupForm() {
        return new AccountForm();
    }

    @RequestMapping(value="account")
    String accountForm() {
        return "account/accountForm";
    }

    @RequestMapping(value = "account", method = RequestMethod.POST)
    String create(@Validated AccountForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account/accountForm";
        }
        Account account = new Account();
        account.setEmail(form.getEmail());
        accountService.create(account, form.getPassword());
        return "redirect:/acount/complete";
    }

    @RequestMapping(value = "account/complete", method = RequestMethod.GET)
    String createFinish() {
        return "account/accountComplete";
    }
}
