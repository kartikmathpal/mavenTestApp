package com.kartik.dao.interfaces;

import com.kartik.entity.Train;

import java.util.List;

public interface ITrainDao {
      Train searchTrainByName(String trainName) throws Exception;
      List<Train> searchByStation(String source, String destination) throws Exception;
}
