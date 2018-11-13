package rezwan.pstu.cse12.pstuseatplan2018.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "student")
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "start_roll")
    public int start_roll;

    @ColumnInfo(name = "end_roll")
    public int end_roll;

    @ColumnInfo(name = "unit")
    public String unit;

    @ColumnInfo(name = "building")
    public String building;

    @ColumnInfo(name = "floor")
    public String floor;

    @ColumnInfo(name = "hall_number")
    public String hall_number;

    @ColumnInfo(name = "room_number")
    public String room_number;

    @ColumnInfo(name = "room_name")
    public String room_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_roll() {
        return start_roll;
    }

    public void setStart_roll(int start_roll) {
        this.start_roll = start_roll;
    }

    public int getEnd_roll() {
        return end_roll;
    }

    public void setEnd_roll(int end_roll) {
        this.end_roll = end_roll;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHall_number() {
        return hall_number;
    }

    public void setHall_number(String hall_number) {
        this.hall_number = hall_number;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
