package com.core.eventdetails.service;

import com.core.eventdetails.dao.ICoreEventDetailsDAO;
import com.core.eventdetails.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoreEventDetailsServiceimpl implements ICoreEventDetailsService{

    private final ICoreEventDetailsDAO iCoreEventDetailsDAO;

    @Autowired
    public CoreEventDetailsServiceimpl(ICoreEventDetailsDAO iCoreEventDetailsDAO) {
        this.iCoreEventDetailsDAO = iCoreEventDetailsDAO;
    }

    @Override
    @Transactional
    public List<Event> getEvents() {
        return iCoreEventDetailsDAO.getEvents();
    }

    @Override
    @Transactional
    public Event getEventDetails(long eventId) {
        return iCoreEventDetailsDAO.getEventDetails(eventId);
    }
}
