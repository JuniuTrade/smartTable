package com.bin.david.smarttable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.ArrayColumn;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.table.TableData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyd
 * @date 18/5/9
 * @desription
 */

public class TestActivity extends AppCompatActivity {

    private SmartTable smartTable;
    private List<Teacher> teacherList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        smartTable = (SmartTable) findViewById(R.id.table);
        initDate();
        Column<String> teacherName = new Column<String>("老师名称", "name");
        teacherName.setFixed(true);
        ArrayColumn<String> studenName1 = new ArrayColumn<String>("学生名称1", "studentList.name");
        studenName1.setSingleTarget(0,2);
        ArrayColumn<String> studenName2 = new ArrayColumn<String>("学生名称2", "studentList.name");
        studenName2.setSingleTarget(1,2);
        ArrayColumn<String> studenName3 = new ArrayColumn<String>("学生名称3", "studentList.name");
        studenName3.setSingleTarget(2,2);
        ArrayColumn<String> studenName4 = new ArrayColumn<String>("学生名称4", "studentList.name");
        studenName4.setSingleTarget(3,2);
        TableData<Teacher> tableData = new TableData<Teacher>("", teacherList, teacherName, studenName1, studenName2, studenName3, studenName4);
        smartTable.setTableData(tableData);
    }

    private void initDate() {
        teacherList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Student> studentList = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                Student student = new Student();
                student.setName("学生" + (j + 1));
                studentList.add(student);
            }
            Teacher teacher = new Teacher();
            teacher.setName("老师" + (i + 1));
            teacher.setStudentList(studentList);
            teacherList.add(teacher);
        }
    }

    class Teacher {

        String name;

        List<Student> studentList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Student> getStudentList() {
            return studentList;
        }

        public void setStudentList(List<Student> studentList) {
            this.studentList = studentList;
        }
    }

    class Student {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
