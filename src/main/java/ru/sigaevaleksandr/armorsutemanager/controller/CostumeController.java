package ru.sigaevaleksandr.armorsutemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sigaevaleksandr.armorsutemanager.exeption.NotFoundException;
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

    @GetMapping("/find_by_artifact")
    public List<Costume> findByArtifact(@RequestParam(name = "param") String param) {
        return new ArrayList<>(this.costumeService.getCostumesByArtifact(param));
    }

    @GetMapping("/find_by_type")
    public List<Costume> findByCostumeType(@RequestParam(name = "type") String param) {
        return new ArrayList<>(this.costumeService.getCostumesByType(param));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costume> completeCostumeById(@PathVariable int id) throws NotFoundException {
        Optional<Costume> costume = this.costumeService.getCostume(id);
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
