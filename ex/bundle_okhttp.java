package com.example.test_example;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.IOException;
import java.io.Serializable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class Student implements Parcelable{
    private String name;
    private int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       dest.writeString(name);
       dest.writeInt(age);
    }
    public static final Parcelable.Creator<Student> CREATOR = new Creator<Student>(){
        @Override
        public Student createFromParcel(Parcel source) {
            Student student = new Student(32,"nobody");
            student.name = source.readString();
            student.age = source.readInt();
            return student;
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[0];
        }
    };
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Book implements Serializable{
    private String name;
    private String Author;

    public Book(String author, String name) {
        Author = author;
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class MainActivity extends AppCompatActivity {
    private final static String url = "https://www.baidu.com";
    private OkHttpClient client = new OkHttpClient();
    private String body;
    private Student student;
    private Book book;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            body = bundle.getString("value");
            Log.d("jeff",body == null?"body=null":body);
            student = bundle.getParcelable("student");
            Log.d("jeff",student.getName() == null?"getName = null":student.getName());
            Log.d("jeff",student.getAge() + "");
            book = (Book)bundle.getSerializable("book");
            Log.d("jeff",book.getName()==null?"book's name is null" : book.getName());
            Log.d("jeff",book.getAuthor()==null?"book's author is null" : book.getAuthor());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
               Request request = new Request.Builder().url(url).build();
                try {
                    Response response = client.newCall(request).execute();
                    body = response.body().string();
                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("value",body);
                    Student student = new Student(23,"xiaoming");
                    Book book = new Book("xiehuan","do you know it?");
                    bundle.putSerializable("book",book);
                    bundle.putParcelable("student",student);
                    message.setData(bundle);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
