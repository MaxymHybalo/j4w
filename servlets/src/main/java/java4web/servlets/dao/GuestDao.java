package java4web.servlets.dao;


import java4web.servlets.domain.Guest;

import java.util.List;

public interface GuestDao {

    void save(Guest guest);

    List<Guest> findAll();
}
