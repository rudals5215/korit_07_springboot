package com.example.shoppinglist.web;

import com.example.shoppinglist.domain.Item;
import com.example.shoppinglist.dto.ItemRequestDto;
import com.example.shoppinglist.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getItemsForCurrentUser());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDto requestDto) {
        Item createdTodo = itemService.createItem(requestDto);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateTodo(@PathVariable Long id, @RequestBody ItemRequestDto updateDto) throws AccessDeniedException {
        return ResponseEntity.ok(itemService.updateItemContent(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) throws AccessDeniedException {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
