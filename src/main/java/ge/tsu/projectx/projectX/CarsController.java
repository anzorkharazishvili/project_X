package ge.tsu.projectx.projectX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/cars")
    public List<CarView> getCars() {
        return carsService.getCars();
    }

}
