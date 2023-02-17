package com.noname.jobhub.h2storage.position;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionH2Repository extends CrudRepository<PersistentPosition, Integer> {
    List<PersistentPosition> findAllByNameLikeOrLocationLike(String name, String location);

    List<PersistentPosition> findAllByNameLikeAndLocationLike(String name, String location);
}
