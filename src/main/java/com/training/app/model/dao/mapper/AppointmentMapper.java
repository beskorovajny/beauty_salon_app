package com.training.app.model.dao.mapper;

import com.training.app.model.entity.Appointment;
import com.training.app.model.entity.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Appointment mapper.
 *
 * @author besko
 */
public class AppointmentMapper implements ObjectMapper<Appointment> {
    @Override
    public Appointment extractFromResultSet(ResultSet resultSet) throws SQLException {
        Map<Integer, Appointment> appointmentMap = new HashMap<>();
        Appointment appointment = Appointment.newBuilder().
                setId(resultSet.getInt("id")).
                setPrice(resultSet.getBigDecimal("price")).
                setActionDateTime(resultSet.getTimestamp("time").toLocalDateTime()).
                setStatus(Appointment.Status.valueOf(resultSet.getString("status"))).
                setEstimate(resultSet.getInt("estimate")).
                build();
        appointmentMap.put(appointment.getId(), appointment);
        appointment = this.makeUnique(appointmentMap, appointment);
        return appointment;
    }

    @Override
    public Appointment makeUnique(Map<Integer, Appointment> cache, Appointment appointment) {
        cache.putIfAbsent(appointment.getId(), appointment);
        return cache.get(appointment.getId());
    }
}
