package com.example.shoppinglist.service;

import com.example.shoppinglist.domain.User;
import com.example.shoppinglist.domain.UserRepository;
import com.example.shoppinglist.domain.Item;
import com.example.shoppinglist.domain.ItemRepository;
import com.example.shoppinglist.dto.ItemRequestDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public ItemService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("User를 찾을 수 없습니다."));
    }

    // 본인 확인 로직 (To-do 객체 내에 있는 User와, 지금 요청을 보내는 애가 동일한지를 확인하는 로직)
    private void checkOwnership(Item item) throws AccessDeniedException {
        if (!item.getUser().equals(getCurrentUser())) {
            throw new AccessDeniedException("해당 todo에 접근할 수 없습니다.");
        }
    }

    // 쇼핑리스트 목록 조회
    @Transactional
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    // 2. 현재 사용자의 모든 할 일 목록 조회
    @Transactional(readOnly = true)
    public List<Item> getItemsForCurrentUser() {
        User currentUser = getCurrentUser();
        return itemRepository.findByUserId(currentUser.getId());
    }

    // 쇼핑리스트 추가
    public Item createItem(ItemRequestDto itemRequestDto) {
        User currentUser = getCurrentUser();
        Item newItem = new Item(itemRequestDto.getProduct(), itemRequestDto.getAmount(), currentUser);

        return itemRepository.save(newItem);
    }

    @Transactional
    public Item updateItemContent(Long id, ItemRequestDto updateDto) throws AccessDeniedException {      // AccessDeniedException - 나의 것이 아닌 내용 수정 불가
        Item item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 todo가 없습니다. id : " + id));
        checkOwnership(item);
        item.setProduct(updateDto.getProduct());
        return itemRepository.save(item);
    }

    // 5. 할 일 삭제
    @Transactional
    public void deleteItem(Long id) throws AccessDeniedException {
        Item item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 id를 가진 todo가 없습니다. id : " + id));
        checkOwnership(item);
        itemRepository.delete(item);
    }
}
