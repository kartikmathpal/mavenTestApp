package com.kartik.service;

import com.kartik.dao.TrainDao;
import com.kartik.dao.interfaces.ITrainDao;
import com.kartik.entity.Train;
import com.kartik.service.inteface.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service("TrainService")
public class TrainService implements ITrainService {

    //static TrainDao trainDao = new TrainDao();
    @Autowired
    ITrainDao trainDao;


    //Train train = new Train();

    private static String trainName;
    private static String sourceStation;
    private static String destination;
    private static Scanner scanner;
    private static Integer userInput;

    static {
        scanner = new Scanner(System.in);
    }

    //@Override
    public List<Train> getTrainsByUserInput(Integer userInput) throws Exception {
        ArrayList<Train> matchedRecords = new ArrayList<Train>();



        switch (userInput) {
            case 1:
                System.out.println("Enter Train Name");
                scanner.nextLine();
                trainName = scanner.nextLine();
                System.out.println("Input Train Name : " + trainName);
                Train train = trainDao.searchTrainByName(trainName);
                if (train != null) {
                    //System.out.println(train);
                    matchedRecords.add(train);
                    return (matchedRecords);
                } else {
                    throw new Exception("qwerty");
                }
            case 2:
                System.out.print("\nEnter Source Station Name :");
                scanner.nextLine();
                sourceStation = scanner.nextLine();
                System.out.print("\nEnter Destination Station Name : ");
                destination = scanner.nextLine();
                try {
                    return trainDao.searchByStation(sourceStation, destination);
                }
                catch (Exception e){
                    throw new Exception(e);
              }
                //break;
            default:
                System.out.println("\nNot a Valid Option");
                break;

        }

        return null;
    }

    //@Override
    public List<Train> requestUserInput() throws Exception {
        System.out.println("\n1.Search By Train Name ");
        System.out.println("\n2.Search By Source Station and Destination Station");
        userInput = scanner.nextInt();
        try {
            List<Train> matchedTrains = getTrainsByUserInput(userInput);

            return matchedTrains;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("throw");
        }
    }
}
