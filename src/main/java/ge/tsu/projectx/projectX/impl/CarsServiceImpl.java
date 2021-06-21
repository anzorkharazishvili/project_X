package ge.tsu.projectx.projectX.impl;

import ge.tsu.projectx.projectX.CarView;
import ge.tsu.projectx.projectX.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarsServiceImpl implements CarsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CarView> getCars() {
        return jdbcTemplate
                .queryForList("select * from public.cars")
                .stream()
                .map(this::map)
                .collect(Collectors.toList());    }

    private CarView map(Map<String, Object> map) {
        CarView carView = new CarView();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "car_name":
                    carView.setCarName(entry.getValue().toString());
                    break;
                case "make":
                    carView.setMake(entry.getValue().toString());
                    break;
                case "color":
                    carView.setColor(entry.getValue().toString());
                    break;
                case "id_number":
                    carView.setIdNumber(entry.getValue().toString());
                    break;
                case "year":
                    carView.setYear(Integer.parseInt(entry.getValue().toString()));
                    break;
                case "external_id":
                    carView.setExternalId(entry.getValue().toString());
                    break;
            }
        }
        return carView;
    }
}
