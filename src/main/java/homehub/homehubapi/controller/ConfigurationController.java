package homehub.homehubapi.controller;

import homehub.homehubapi.exception.ResourceExistsException;
import homehub.homehubapi.exception.ResourceNotFoundException;
import homehub.homehubapi.model.Configuration;
import homehub.homehubapi.repository.HomehubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigurationController {

    @Autowired
    HomehubRepository homehubRepository;

    @GetMapping("/keys")
    public List<Configuration> getAllKeys(){
        return homehubRepository.findAll();
    }

    @GetMapping("/value")
    public String getValue(@Valid @RequestParam(value="key") String key){
        Configuration config = homehubRepository.findById(key)
                .orElseThrow(() -> new ResourceNotFoundException("Configuration", "key" , key));
        return config.getValue();
    }

    @PostMapping("/value")
    public Configuration updateValue(@Valid @RequestParam(value="key") String key, @RequestParam(value = "value") String value){
        Configuration config = homehubRepository.findById(key).orElseThrow(() -> new ResourceNotFoundException("Configuration", "key" , key));
        config.setValue(value);
        homehubRepository.save(config);
        return config;
    }

    @PostMapping("/newConfig")
    public Configuration addConfiguration(@Valid @RequestBody Configuration config){
        if(homehubRepository.existsById(config.getKeyString())){
            throw new ResourceExistsException("Configuration", config.getKeyString());
        }
        else {
            return homehubRepository.save(config);
        }
    }



}
