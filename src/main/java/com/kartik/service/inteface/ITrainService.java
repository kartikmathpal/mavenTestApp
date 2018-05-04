package com.kartik.service.inteface;

import com.kartik.entity.Train;

import java.util.List;

public interface ITrainService {
    public List<Train> requestUserInput() throws Exception;
    public List<Train> getTrainsByUserInput(Integer userInput) throws Exception;
}

