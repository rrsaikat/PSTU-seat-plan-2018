package rezwan.pstu.cse12.pstuseatplan2018.data.factory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import rezwan.pstu.cse12.pstuseatplan2018.data.StudentDAO;
import rezwan.pstu.cse12.pstuseatplan2018.model.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDAO studentDAO();

}
