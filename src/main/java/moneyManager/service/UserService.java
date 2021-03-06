package moneyManager.service;

import moneyManager.model.User;
import moneyManager.to.UserTo;
import moneyManager.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Vladimir on 09.08.2018.
 */
public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void update(UserTo user);

    void evictCache();

    void enable(int id, boolean enable);

    User getWithCosts(int id);
}
