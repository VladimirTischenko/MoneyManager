package moneyManager.web.user;

import com.fasterxml.jackson.annotation.JsonView;
import moneyManager.View;
import moneyManager.model.User;
import moneyManager.to.UserTo;
import moneyManager.util.UserUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdate(@Valid UserTo userTo) {
        if (userTo.isNew()) {
            super.create(UserUtil.createNewFromTo(userTo));
        } else {
            super.update(userTo, userTo.getId());
        }
    }

    @PostMapping(value = "/{id}")
    public void enabled(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        super.enable(id, enabled);
    }
}
