package com.noname.jobhub.businessrules.position;

import java.util.List;

public class PositionService {
    private final PositionStorage positionStorage;

    public PositionService(PositionStorage positionStorage) {
        this.positionStorage = positionStorage;
    }

    public Position create(String name, String location) {
        Position position = new Position(name, location);
        positionStorage.save(position);
        return position;
    }

    public Position load(Integer id) {
        return positionStorage.load(id);
    }

    public List<Position> findAll() {
        return positionStorage.findAll();
    }

    public List<Position> findAllByNameLikeOrLocationLike(String name, String location) {
        return positionStorage.findAllByNameLikeOrLocationLike(name, location);
    }

    public List<Position> findAllByNameLikeAndLocationLike(String name, String location) {
        return positionStorage.findAllByNameLikeAndLocationLike(name, location);
    }
}
