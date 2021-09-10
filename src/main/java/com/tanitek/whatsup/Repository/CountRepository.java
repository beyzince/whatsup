package com.tanitek.whatsup.Repository;

import com.tanitek.whatsup.Model.Count;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountRepository extends MongoRepository<Count,String> {
}
