package ru.sigaevaleksandr.armorsutemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.service.ArmorService;
import ru.sigaevaleksandr.armorsutemanager.exeption.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/armor")
public class ArmorController {

    private final ArmorService armorService;

    public ArmorController(final ArmorService armorService) {
        this.armorService = armorService;
    }

    @GetMapping("/")
    public List<Armor> findAll() {
        return new ArrayList<>(this.armorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Armor> findById(@PathVariable int id) {
        Optional<Armor> armor = this.armorService.findById(id);
        return new ResponseEntity<>(
                armor.orElse(new Armor()),
                armor.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Armor> create(@RequestBody Armor armor) throws ServiceException {
        return new ResponseEntity<Armor>(
                this.armorService.save(armor),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Armor armor) throws ServiceException {
        this.armorService.update(armor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Armor armor = new Armor();
        armor.setId(id);
        this.armorService.delete(armor);
        return ResponseEntity.ok().build();
    }


}
