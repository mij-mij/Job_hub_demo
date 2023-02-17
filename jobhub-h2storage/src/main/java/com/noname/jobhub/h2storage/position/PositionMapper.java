package com.noname.jobhub.h2storage.position;

import com.noname.jobhub.businessrules.position.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionMapper {

    public PersistentPosition fromPosition(Position position) {
        return new PersistentPosition(position.getId(), position.getName(), position.getLocation());
    }

    public Position fromEntity(PersistentPosition persistentClientApplication) {
        return new Position(persistentClientApplication.getId(), persistentClientApplication.getName(), persistentClientApplication.getLocation());
    }

    public List<PersistentPosition> fromPositions(Iterable<Position> clientApplications) {
        ArrayList<PersistentPosition> ret = new ArrayList<>();
        clientApplications.forEach(item -> ret.add(fromPosition(item)));
        return ret;
    }

    public List<Position> fromEntities(Iterable<PersistentPosition> persistentClientApplications) {
        ArrayList<Position> ret = new ArrayList<>();
        persistentClientApplications.forEach(item -> ret.add(fromEntity(item)));
        return ret;
    }


}
