package com.andreea.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 7/28/2017.
 */
@Repository
public interface LandRepository extends CrudRepository<Land, Integer> {
}
