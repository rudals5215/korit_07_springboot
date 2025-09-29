package com.example.cardatabased4.service;

import com.example.cardatabased4.domain.Owner;
import com.example.cardatabased4.domain.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    // 1. 전체 조회
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }
    // 2. id 별 조회
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }
    // 3. Owner 객체 추가
    public Owner addOwner (Owner owner){
        return ownerRepository.save(owner);
    }
    // 4. Owner 객체 삭제
    public boolean deleteOwner(Long id) {
        if (ownerRepository.existsById(id)){
            ownerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // 5. Owner 객체 수정
    public Optional<Owner> updateOwner(Long id, Owner ownerDetails) {
        return ownerRepository.findById(id)
                .map(owner -> {
                   owner.setFirstName(ownerDetails.getFirstName());
                   owner.setLastName(ownerDetails.getLastName());
                   return owner;
                });
    }
}
