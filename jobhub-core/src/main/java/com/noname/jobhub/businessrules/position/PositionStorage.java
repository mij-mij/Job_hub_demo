package com.noname.jobhub.businessrules.position;

import java.util.List;

public interface PositionStorage {
    Position load(Integer id);

    void save(Position position);

    List<Position> findAll();

    List<Position> findAllByNameLikeOrLocationLike(String name, String location);

    List<Position> findAllByNameLikeAndLocationLike(String name, String location);
}
