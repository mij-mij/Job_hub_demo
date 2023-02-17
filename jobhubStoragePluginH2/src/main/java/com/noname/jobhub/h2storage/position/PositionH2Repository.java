package com.noname.jobhub.h2storage.position;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionH2Repository extends CrudRepository<PersistentPosition, Integer> {
    List<PersistentPosition> findAllByNameLikeOrLocationLike(String name, String location);

    List<PersistentPosition> findAllByNameLikeAndLocationLike(String name, String location);
}
