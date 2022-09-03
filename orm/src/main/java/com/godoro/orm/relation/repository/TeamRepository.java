package com.godoro.orm.relation.repository;


import com.godoro.orm.relation.entity.Team;

public class TeamRepository extends BaseRepository <Team>{

    public TeamRepository() {
        super(Team.class);
    }
    
}
