package com.training.app.model.dao;

import com.training.app.model.entity.Appointment;
import com.training.app.model.entity.Card;
import com.training.app.model.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The interface User dao.
 *
 * @author besko
 */
public interface UserDAO extends GenericDAO<User> {

    /**
     * Register user user.
     *
     * @param user the user
     * @return the user
     * @throws DaoException the dao exception
     */
    User registerUser(User user) throws DaoException;

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     * @throws DaoException the dao exception
     */
    User findById(int id) throws DaoException;

    /**
     * Find by login user.
     *
     * @param login the login
     * @return the user
     * @throws DaoException the dao exception
     */
    User findByLogin(String login) throws DaoException;

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     * @throws DaoException the dao exception
     * @throws SQLException the sql exception
     */
    User findByName(String name) throws DaoException, SQLException;

    /**
     * Find by rating list.
     *
     * @param rating the rating
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findByRating(int rating) throws DaoException;

    /**
     * Find all users list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<User> findAllUsers() throws DaoException;

    /**
     * Find all cards set.
     *
     * @return the set
     * @throws DaoException the dao exception
     */
    Set<Card> findAllCards() throws DaoException;

    /**
     * Find all appointments list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Appointment> findAllAppointments() throws DaoException;

    /**
     * Update user.
     *
     * @param userId the user id
     * @param user   the user
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateUser(int userId, User user) throws DaoException;

    /**
     * Remove user by id.
     *
     * @param userId the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean removeUserById(int userId) throws DaoException;

}
