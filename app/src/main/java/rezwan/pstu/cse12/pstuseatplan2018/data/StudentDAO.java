package rezwan.pstu.cse12.pstuseatplan2018.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import rezwan.pstu.cse12.pstuseatplan2018.model.Student;

@Dao
public interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertStudent(Student student);

    @Update
    int updateStudent(Student student);

    @Delete
    int deleteStudent(Student student);

    @Query("SELECT * FROM student")
    Student[] selectAllStudents();

    @Query("SELECT * FROM student WHERE id = :id LIMIT 1")
    Student selectStudentDetail(long id);
}
