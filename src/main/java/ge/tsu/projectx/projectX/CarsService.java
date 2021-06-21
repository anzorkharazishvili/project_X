package ge.tsu.projectx.projectX;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public interface CarsService {

    List<CarView> getCars();

}
