package com.tanitek.whatsup.Repository;

import com.tanitek.whatsup.Model.Phonenumber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhoneRepository extends MongoRepository <Phonenumber,String> {
}
