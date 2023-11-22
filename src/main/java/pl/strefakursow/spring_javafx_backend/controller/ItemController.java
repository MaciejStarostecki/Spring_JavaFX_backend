package pl.strefakursow.spring_javafx_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strefakursow.spring_javafx_backend.dto.EmployeeDto;
import pl.strefakursow.spring_javafx_backend.dto.ItemDto;
import pl.strefakursow.spring_javafx_backend.dto.ItemEditViewDto;
import pl.strefakursow.spring_javafx_backend.dto.ItemSaveDto;
import pl.strefakursow.spring_javafx_backend.entity.Employee;
import pl.strefakursow.spring_javafx_backend.entity.Item;
import pl.strefakursow.spring_javafx_backend.repository.ItemRepository;
import pl.strefakursow.spring_javafx_backend.repository.QuantityTypeRepository;
import pl.strefakursow.spring_javafx_backend.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final QuantityTypeRepository quantityTypeRepository;

    @PostMapping("/items")
    public ItemDto newItem(@RequestBody ItemSaveDto dto) {
        if (dto.getIdItem() == null)
            return ItemDto.of(itemService.saveItem(dto));
        else {
            Item item = itemRepository.findById(dto.getIdItem()).get();
            item.setName(dto.getName());
            item.setQuantity(dto.getQuantity());
            item.setQuantityType(quantityTypeRepository.findById(dto.getIdQuantityType()).get());
            return ItemDto.of(itemRepository.save(item));
        }
    }

    @GetMapping("/items")
    public List<ItemDto> listItem() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::of)
                .toList();
    }

    @GetMapping("/item_edit_data/{idItem}")
    public ItemEditViewDto getItemEditViewDto(@PathVariable Long idItem) {
        Item item = itemRepository.findById(idItem).get();
        ItemEditViewDto dto = ItemEditViewDto.of(item, quantityTypeRepository.findAll());
        return dto;
    }

    @GetMapping("/items/{idItem}")
    public ItemDto getItem(@PathVariable Long idItem) {
        Optional<Item> optionalItem = itemRepository.findById(idItem);
        return ItemDto.of(optionalItem.get());
    }

    @DeleteMapping("/items/{idItem}")
    public ResponseEntity deleteItem(@PathVariable Long idItem) {
        itemRepository.deleteById(idItem);
        return ResponseEntity.ok().build();
    }

}
