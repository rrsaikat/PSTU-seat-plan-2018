package rezwan.pstu.cse12.pstuseatplan2018;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rezwan.pstu.cse12.pstuseatplan2018.data.factory.AppDatabase;
import rezwan.pstu.cse12.pstuseatplan2018.model.Student;

public class RoomReadAndSearch {
    private String searchKey;
    private Context context;
    private AppDatabase db;
    private ArrayList<Student> allItem;

    private ArrayList startRoll;
    private ArrayList endRoll;
    private ArrayList unit;
    private ArrayList building;
    private ArrayList floor;
    private ArrayList hallNumber;
    private ArrayList roomNumber;
    private ArrayList room_name;

    public RoomReadAndSearch() {

    }

    public RoomReadAndSearch(String searchKey, Context context) {
        this.searchKey = searchKey;
        this.context = context;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public ArrayList<String> searchInDatabase(){
        ArrayList<String> result = new ArrayList<>();
        prepareData();
        String res="";
        int strtR = 0, endR = 0, key = 0;

        for (int i = 0; i<startRoll.size(); i++){
            strtR = Integer.parseInt(startRoll.get(i).toString());
            endR = Integer.parseInt(endRoll.get(i).toString());
            key = Integer.parseInt(searchKey);

            if(key >= strtR && key <=endR){
                result.add(searchKey);
                result.add(unit.get(i).toString());
                result.add(building.get(i).toString());
                result.add(floor.get(i).toString());
                result.add(hallNumber.get(i).toString());
                result.add(roomNumber.get(i).toString());
                result.add(room_name.get(i).toString());

                break;
            }

        }

        return result;
    }

    private void prepareData() {
        allItem = new ArrayList<>();
        startRoll = new ArrayList<String>();
        endRoll = new ArrayList<String>();
        unit = new ArrayList<String>();
        building = new ArrayList<String>();
        floor = new ArrayList<String>();
        hallNumber = new ArrayList<String>();
        roomNumber = new ArrayList<String>();
        room_name = new ArrayList<String>();

        /**
         * Initialize database
         * allow main thread queries
         */
        db = Room.databaseBuilder(getContext(), AppDatabase.class, "studentdb").allowMainThreadQueries().build();

        /**
         * Add all data to arraylist
         */
        allItem.addAll(Arrays.asList(db.studentDAO().selectAllStudents()));

        for(Student item: allItem){
            startRoll.add(item.getStart_roll());
            endRoll.add(item.getEnd_roll());
            unit.add(item.getUnit());
            building.add(item.getBuilding());
            floor.add(item.getFloor());
            hallNumber.add(item.getHall_number());
            roomNumber.add(item.getRoom_number());
            room_name.add(item.getRoom_name());
        }
    }


}
