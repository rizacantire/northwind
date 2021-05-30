package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import org.springframework.stereotype.Service;


import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
    DataResult<List<User>> getAll();
}
