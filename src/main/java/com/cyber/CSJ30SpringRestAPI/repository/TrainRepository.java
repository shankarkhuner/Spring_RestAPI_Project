package com.cyber.CSJ30SpringRestAPI.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cyber.CSJ30SpringRestAPI.entity.Train;
@Repository
public interface TrainRepository extends CrudRepository<Train, Integer>{
 @Transactional
 @Modifying
@Query("update Train t set t.trainName=:tname, t.sourceStation=:tsource, t.destinationStation= :tdestination, t.trainPrice= :tprice where t.trainNumber= :tno")
public int updateTrain(@Param("tno")int tno,@Param("tname")String tname,@Param("tsource")String tsource,@Param("tdestination")String tdestination,@Param("tprice")double tprice);

}

