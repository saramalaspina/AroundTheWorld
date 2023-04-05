package com.example.aroundtheworld.dao;

import com.example.aroundtheworld.connection.ConnectionDB;
import com.example.aroundtheworld.dao.queries.SimpleQueries;
import com.example.aroundtheworld.exception.ConnectionDbException;
import com.example.aroundtheworld.exception.NotFoundException;
import com.example.aroundtheworld.model.Animal;
import com.example.aroundtheworld.model.City;
import com.example.aroundtheworld.model.Residence;
import com.example.aroundtheworld.model.School;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CityDAO {

    private static final String PHOTO = "photo";
    private static final String LANGUAGE = "language";
    private static final String ACT1 = "activity1";
    private static final String ACT2 = "activity2";
    private static final String ACT3 = "activity3";
    private static final String IMGACT1 = "imgActivity1";
    private static final String IMGACT2 = "imgActivity2";
    private static final String IMGACT3 = "imgActivity3";

    private CityDAO(){}
    public static City retrieveCity(String name) throws NotFoundException {

        Statement stmt;
        City city = null;
        Residence residence = null;
        School school = null;

        try{
            stmt = ConnectionDB.getConnection();

            ResultSet resultSet = SimpleQueries.retrieveCity(stmt, name);

            if(!resultSet.first()) {
                throw new NotFoundException("No city found with name: " + name);
            }

            resultSet.first();
            do{
                String photo = resultSet.getString(PHOTO);
                String language = resultSet.getString(LANGUAGE);
                String act1 = resultSet.getString(ACT1);
                String imgAct1 = resultSet.getString(IMGACT1);
                String act2 = resultSet.getString(ACT2);
                String imgAct2 = resultSet.getString(IMGACT2);
                String act3 = resultSet.getString(ACT3);
                String imgAct3 = resultSet.getString(IMGACT3);

                residence = ResidenceDAO.retrieveResidence(name);
                school = SchoolDAO.retrieveSchool(name);

                city = new City(name,photo,language,act1,imgAct1,act2,imgAct2,act3,imgAct3,residence,school);

            } while(resultSet.next());

            resultSet.close();

        } catch(SQLException | ConnectionDbException e){
            e.printStackTrace();
        }
        return city;
    }
}

