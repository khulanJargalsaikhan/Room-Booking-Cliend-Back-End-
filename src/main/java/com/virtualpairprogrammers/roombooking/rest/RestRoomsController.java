package com.virtualpairprogrammers.roombooking.rest;

import com.virtualpairprogrammers.roombooking.data.RoomRepository;
import com.virtualpairprogrammers.roombooking.model.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RestRoomsController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping()
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id){
        return roomRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room update(@RequestBody Room updatedRoom){
        return roomRepository.save(updatedRoom);
    }



}
