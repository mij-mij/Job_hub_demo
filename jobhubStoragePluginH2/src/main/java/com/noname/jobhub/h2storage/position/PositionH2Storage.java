package com.noname.jobhub.h2storage.position;

import com.noname.jobhub.businessrules.position.Position;
import com.noname.jobhub.businessrules.position.PositionStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class PositionH2Storage implements PositionStorage {
    private PositionH2Repository positionH2Repository;
    private PositionMapper mapper;

    @Autowired
    public PositionH2Storage(PositionH2Repository positionH2Repository, PositionMapper positionMapper) {
        this.positionH2Repository = positionH2Repository;
        this.mapper = positionMapper;
    }

    public Position load(Integer id) {
        return mapper.fromEntity(positionH2Repository.findById(id).orElseThrow(() -> new IllegalStateException("Position not found")));
    }

    public void save(Position position) {
        PersistentPosition persistentPosition = positionH2Repository.save(mapper.fromPosition(position));
        if (position.getId() == null)
            position.setId(persistentPosition.getId());
    }

    public List<Position> findAll() {

        return mapper.fromEntities(positionH2Repository.findAll());
    }


    public List<Position> findAllByNameLikeOrLocationLike(String name, String location) {

        return mapper.fromEntities(positionH2Repository.findAllByNameLikeOrLocationLike(name, location));
    }

    public List<Position> findAllByNameLikeAndLocationLike(String name, String location) {

        return mapper.fromEntities(positionH2Repository.findAllByNameLikeAndLocationLike(name, location));
    }
}
