package ru.sigaevaleksandr.armorsutemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/costume")
public class CostumeController {

    private final CostumeService costumeService;

    public CostumeController(final CostumeService costumeService) {
        this.costumeService = costumeService;
    }

    @GetMapping("/")
    public List<Costume> findAll() {
        return new ArrayList<>(this.costumeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costume> findById(@PathVariable int id) {
        Optional<Costume> costume = this.costumeService.findById(id);
        return new ResponseEntity<>(
                costume.orElse(new Costume()),
                costume.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Costume> create(@RequestBody Costume costume) {
        return new ResponseEntity<>(
                this.costumeService.save(costume),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Costume costume) {
        this.costumeService.save(costume);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Costume costume = new Costume();
        costume.setId(id);
        this.costumeService.delete(costume);
        return ResponseEntity.ok().build();
    }
}
