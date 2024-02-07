package com.example.electronicdevicesservice.dao;

import com.example.electronicdevicesservice.dto.FactoryDto;
import com.example.electronicdevicesservice.dto.StatisticDto;
import com.example.electronicdevicesservice.dto.TopFiveDeviceResponseDto;
import com.example.electronicdevicesservice.dto.TopFiveFactoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElectronicDeviceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TopFiveDeviceResponseDto> getTopFiveDeviseDto() {
        String sqlQuery = "SELECT device.id, device.date_release, device.supervisior, factory.name AS factory_name " +
                "FROM device " +
                "INNER JOIN factory ON device.factory_id = factory.id " +
                "ORDER BY device.date_release DESC " +
                "LIMIT 5";

        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            TopFiveDeviceResponseDto topFiveDeviceResponseDto = new TopFiveDeviceResponseDto();
            topFiveDeviceResponseDto.setName(resultSet.getString("factory_name"));
            topFiveDeviceResponseDto.setDateRelease(resultSet.getDate("date_release"));
            topFiveDeviceResponseDto.setNameSupervisor(resultSet.getString("supervisior"));
            return topFiveDeviceResponseDto;
        });
    }


    public List<StatisticDto> getInfoDevice() {
        String sqlQuery = "SELECT date_release::date AS release_date," +
                "            COUNT(*) AS devices_count" +
                "            FROM device" +
                "            WHERE date_release >= CURRENT_DATE - INTERVAL '30 days'" +
                "            GROUP BY release_date" +
                "            ORDER BY release_date";


        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            StatisticDto statisticDto = new StatisticDto();
            statisticDto.setDateRelease(resultSet.getDate("release_date").toLocalDate());
            statisticDto.setCount(resultSet.getInt("devices_count"));
            return statisticDto;

        });

    }
    public List<TopFiveFactoryDto> getTopFiveFactory() {
        String sqlQuery = "SELECT factory.id, factory.name AS factory_name, factory.address,factory.date_addition, factory.date_construction ,COUNT(device.id) totalCount\n" +
                "FROM device\n" +
                "INNER JOIN factory ON device.factory_id = factory.id\n" +
                "WHERE now() - interval '7 day' <= device.date_release\n" +
                "GROUP BY factory.id, factory.name, factory.address, factory.date_addition, factory.date_construction\n" +
                "ORDER BY totalCount DESC\n" +
                "LIMIT 5";


        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            TopFiveFactoryDto topFiveFactoryDto = new TopFiveFactoryDto();
            topFiveFactoryDto.setName(resultSet.getString("factory_name"));
            return topFiveFactoryDto;

        });
    }

}
