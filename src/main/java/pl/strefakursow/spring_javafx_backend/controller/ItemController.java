package pl.strefakursow.spring_javafx_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.dto.EmployeeDto;
import pl.strefakursow.spring_javafx_backend.dto.ItemDto;
import pl.strefakursow.spring_javafx_backend.dto.ItemSaveDto;
import pl.strefakursow.spring_javafx_backend.entity.Employee;
import pl.strefakursow.spring_javafx_backend.entity.Item;
import pl.strefakursow.spring_javafx_backend.repository.ItemRepository;
import pl.strefakursow.spring_javafx_backend.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @PostMapping("/items")
    public ItemDto newItem(@RequestBody ItemSaveDto dto) {
        return ItemDto.of(itemService.saveItem(dto));
    }

    @GetMapping("/items")
    public List<ItemDto> listItem() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::of)
                .toList();
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) {
        Optional<Item> optionalItem = itemRepository.findById(idItem);
        return ItemDto.of(optionalItem.get());
    }

    @DeleteMapping("/items")
    public ResponseEntity deleteItem(@RequestBody Long idItem) {
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
