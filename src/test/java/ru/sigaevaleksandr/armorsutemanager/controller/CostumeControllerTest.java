package ru.sigaevaleksandr.armorsutemanager.controller;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeStatus;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeType;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CostumeController.class)
public class CostumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CostumeService costumeService;

    @Test
    public void whenFindAll() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1, 0, 1);
        Costume costume = new Costume(1, "MARK1", 3, CostumeType.WARRIOR,
                Lists.newArrayList(armor), CostumeStatus.RELEASE);
        given(this.costumeService.findAll())
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(costume)
                        )
                );

        this.mockMvc.perform(
                get("/costume/").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"type\":\"WARRIOR\","
                        + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                        + "\"unitMax\":1,\"unitLeft\":0,\"idCostume\":1,\"loadUnit\":0.0}],"
                        + "\"status\":\"RELEASE\",\"createDate\":null,\"loadArmor\":\"0\"}]")
        );

    }

    @Test
    public void whenFindByArtifact() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1, 0, 1);
        Costume costume = new Costume(1, "MARK1", 3, CostumeType.WARRIOR,
                Lists.newArrayList(armor), CostumeStatus.RELEASE);
        given(this.costumeService.getCostumesByArtifact("test"))
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(costume))
                );

        this.mockMvc.perform(
                get("/costume/find_by_artifact/").param("param", "test")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"type\":\"WARRIOR\","
                        + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                        + "\"unitMax\":1,\"unitLeft\":0,\"idCostume\":1,\"loadUnit\":0.0}],"
                        + "\"status\":\"RELEASE\",\"createDate\":null,\"loadArmor\":\"0\"}]")
        );
    }

    @Test
    public void whenFindByCostumeType() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1, 0, 1);
        Costume costume = new Costume(1, "MARK1", 3, CostumeType.WARRIOR,
                Lists.newArrayList(armor), CostumeStatus.RELEASE);
        given(this.costumeService.getCostumesByType("warrior"))
                .willReturn(
                        new ArrayList<>(Lists.newArrayList(costume))
                );

        this.mockMvc.perform(
                get("/costume/find_by_type/").param("type", "warrior")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("[{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"type\":\"WARRIOR\","
                        + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                        + "\"unitMax\":1,\"unitLeft\":0,\"idCostume\":1,\"loadUnit\":0.0}],"
                        + "\"status\":\"RELEASE\",\"createDate\":null,\"loadArmor\":\"0\"}]")
        );
    }

    @Test
    public void whenGetCostume() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1, 1, 1);
        Costume costume = new Costume(1, "MARK1", 1, CostumeType.WARRIOR,
                Lists.newArrayList(armor), CostumeStatus.RELEASE);
        given(this.costumeService.getCostume(1))
                .willReturn(
                        Optional.of(costume)
                );

        this.mockMvc.perform(
                get("/costume/1").accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":1,\"type\":\"WARRIOR\","
                        + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                        + "\"unitMax\":1,\"unitLeft\":1,\"idCostume\":1,\"loadUnit\":1}],"
                        + "\"status\":\"RELEASE\",\"createDate\":null,\"loadArmor\":\"100\"}")
        );
    }

    @Test
    public void whenCreate() throws Exception {
        Armor armor = new Armor(1, "test", "test", 1, 0, 1);
        Costume costume = new Costume(1, "MARK1", 3, CostumeType.WARRIOR,
                Lists.newArrayList(armor), CostumeStatus.RELEASE);
        given(this.costumeService.save(costume))
                .willReturn(costume);

        this.mockMvc.perform(
                post("/costume/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"type\":\"WARRIOR\","
                                + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                                + "\"unitMax\":1,\"unitLeft\":0,\"idCostume\":1,\"loadUnit\":0.0}],"
                                + "\"status\":\"RELEASE\",\"createDate\":null}")
        ).andExpect(
                status().isCreated()
        );
    }

    @Test
    public void whenUpdate() throws Exception {
        this.mockMvc.perform(
                put("/costume/").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"id\":1,\"nameCostume\":\"MARK1\",\"maxCountArmor\":3,\"type\":\"WARRIOR\","
                                + "\"armors\":[{\"id\":1,\"nameArmor\":\"test\",\"artifact\":\"test\","
                                + "\"unitMax\":1,\"unitLeft\":0,\"idCostume\":1,\"loadUnit\":0.0}],"
                                + "\"status\":\"RELEASE\",\"createDate\":null}")
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    public void whenDelete() throws Exception {
        this.mockMvc.perform(
                delete("/costume/1").accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        );
    }
}