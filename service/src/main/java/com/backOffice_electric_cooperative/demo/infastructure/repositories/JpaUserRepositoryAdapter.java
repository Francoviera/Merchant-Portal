package com.backOffice_electric_cooperative.demo.infastructure.repositories;

import com.backOffice_electric_cooperative.demo.domain.models.User;
import com.backOffice_electric_cooperative.demo.domain.ports.output.UserRepositoryPort;
import com.backOffice_electric_cooperative.demo.infastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainInModel(user);
        UserEntity userEntitySaved = jpaUserRepository.save(userEntity);

        return userEntitySaved.toDomainModel();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.jpaUserRepository.findById(id)
                .map(UserEntity::toDomainModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.jpaUserRepository.findByEmail(email)
                .map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return this.jpaUserRepository.findAll()
                .stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> update(User user) {
        if(jpaUserRepository.existsById(user.getId())){
            UserEntity userEntity = UserEntity.fromDomainInModel(user);
            UserEntity userEntitySaved = jpaUserRepository.save(userEntity);
            return Optional.of(userEntitySaved.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if(jpaUserRepository.existsById(id)){
            this.jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
