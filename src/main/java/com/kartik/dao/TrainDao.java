package com.kartik.dao;

import com.kartik.dao.interfaces.ITrainDao;
import com.kartik.entity.Train;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("TrainRepo")
public class TrainDao implements ITrainDao {

//    private static List<Train> trains;
    private ArrayList<Train> matchedList = new ArrayList<Train>(); //Empty List

    @Autowired
    private SessionFactory sessionFactory;

    //    static {
//        trains = new ArrayList<Train>();
//
//        trains.add(new Train(112, "BangaloreExp","BLR","NDLS",290));
//        trains.add(new Train(114,"KarnatakExp","BLR","KPD",300));
//        trains.add(new Train(340,"LucknowExp","BLR","LCK",400));
//        trains.add(new Train(3401,"Rajdhani","BLR","NDLS",400));
//    }
    //@Override
    public Train searchTrainByName(String trainName) throws Exception {

        Train foundTrain  = (Train)sessionFactory
                .getCurrentSession()
                .createQuery("from Train where trainName=:trainName")
                .setParameter("trainName", trainName)
                .uniqueResult();

        if(foundTrain == null){
            throw new Exception("No such train exists in DB!!!");
        }
        else {
            return foundTrain;
        }
//        Train foundTrain = new Train();
//        Boolean trainFound = false;
//        for (Train train1:trains) {
//            if(train1.getTrainName().equalsIgnoreCase(trainName))
//            {
//                trainFound = true;
//                foundTrain = train1;
//                break;
//            }
//        }
//        if(trainFound){
//         return foundTrain;}
//        else{
//            throw new Exception("Train Not Present"); //how to throw custom exceptions
//        }

            }

    //@Override
    public List<Train> searchByStation(String source, String destination) throws Exception {

        matchedList = (ArrayList<Train>)sessionFactory
                .getCurrentSession()
                .createQuery("from Train where source_station=:source_station and destination_station=:destination_station")
                .setParameter("source_station", source)
                .setParameter("destination_station", destination)
                .list();

        if(matchedList == null){
            throw new Exception("No entries found in DB\n");
        }
        else{
            return matchedList;
        }



//        for(int i= 0; i< trains.size();i++){
//
//            if((trains.get(i).getSourceStation().equalsIgnoreCase(source)) &&
//                    (trains.get(i).getDestinationStation().equalsIgnoreCase(destination)))
//            {
//
//                matchedList.add(trains.get(i));
//
//            }
//
//        }
//
//
//            return matchedList;
//

    }
}