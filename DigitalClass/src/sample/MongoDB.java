/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample;
import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.DB.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MongoDB {


    public  String session_user;
    public  String session_user_email;
    public  String session_user_cms;
    public  String session_user_password;
    public String session_user_status;
    public String session_user_availability;
    public static ArrayList<String[]> mongoarraylist;
    public static ArrayList<String[]> mongoarraypostlist;
    public static String[] user_profile_data = new String[6];
    public static ArrayList<String[]> all_users;
    static MongoClientURI connectionString = new MongoClientURI("mongodb://DigitalClass:seecs@ds016138.mlab.com:16138/digitalclass");
    static MongoClient mongoclient = new MongoClient(connectionString);
    static MongoDatabase database = mongoclient.getDatabase("digitalclass");
    static MongoCollection<Document> collection4 = database.getCollection("Post");
    static MongoCollection<Document> collection = database.getCollection("UserData");
    static MongoCollection<Document> collection1 = database.getCollection("Important_Data");
    static DB db1 = mongoclient.getDB("digitalclass");
    static DBCollection coll1 = db1.getCollection("UserData");
    static DB db = mongoclient.getDB( "digitalclass" );
    static DBCollection coll = db.getCollection("UserData");
    static DBCollection coll2 = db.getCollection("Post");
    static Showsinglepostcontroller[] posts;



    public static String[] getUser_profile_data() {
        return user_profile_data;
    }

    public ArrayList<String[]> getMongoarraylist() {
        return mongoarraylist;
    }

    public ArrayList<String[]> getMongoarraypostlist() {
        return mongoarraypostlist;
    }

    public String getSession_user() {
        return session_user;
    }

    public String getSession_user_status() {
        return session_user_status;
    }

    public String getSession_user_cms() {
        return session_user_cms;
    }

    public void Register_User(String name , String email , String password , String cmsid , String securityQ) {

        Document doc = new Document("Name", name)
                .append("Cms" , cmsid)
                .append("Email" , email)
                .append("Password", password)
                .append("Security_Question", securityQ).append("Status","Hi! I'm using DigitalClass")
                .append("Available","false")
                .append("Notification","false")
                .append("No_of_Notifications","0");
        Document doc1 = new Document("Email" , email)
                .append("Password", password);


        collection.insertOne(doc);
        collection1.insertOne(doc1);
    }

    public boolean Login_User(String a , String b) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Email",a);
        searchQuery.put("Password",b);
        MongoCursor<Document> cursor1 = collection1.find(searchQuery).iterator();
        if (cursor1.hasNext()) {
            DB db = mongoclient.getDB( "digitalclass" );
            DBCollection coll = db.getCollection("UserData");
            DBCursor cursor = coll.find(searchQuery);
            this.user_profile_data = my_profile(a);
                BasicDBObject newDocument = new BasicDBObject();
                newDocument.append("$set", new BasicDBObject().append("Available", "true"));

                coll.update(new BasicDBObject().append("Name",user_profile_data[0]), newDocument);
                this.user_profile_data = my_profile(a);
            System.out.println(user_profile_data[5]);
            return true;
        }
        else {
            return false;
        }}
    public String Change_Password(String email , String answer) {



        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Email", email);


        MongoCursor<Document> cursor1 = collection.find(searchQuery).iterator();


        if (cursor1.hasNext()) {

            BasicDBObject searchQuery1 = new BasicDBObject();
            searchQuery.put("Security_Question", answer);
            DB db = mongoclient.getDB("digitalclass");
            DBCollection coll = db.getCollection("UserData");

            DBCursor cursor2 = coll.find(searchQuery);

            if (cursor2.hasNext()) {
                DBObject main = cursor2.next();
                String current_password = main.get("Password").toString();
                return "Your Password is: " + current_password;
            } else {
                return "Wrong Answer or Invalid Credentials";
            }
        } else
            return "Username Doesn't Exist";
    }

    public void Class_Mates(){

        ArrayList<String[]> class_mates = new ArrayList<String[]>();


        DBCursor cursor1 = coll1.find();
        while (cursor1.hasNext()){
            String[] interior_list = new String[4];
            DBObject main1 = cursor1.next();
            interior_list[0] = main1.get("Name").toString();
            interior_list[1] = main1.get("Email").toString();
            interior_list[2] = main1.get("Status").toString();
            interior_list[3] = main1.get("Available").toString();
            class_mates.add(interior_list);

        }
        mongoarraylist = class_mates;
    }
    public void update_status(String status,String email)
    {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("Status", status));

        coll.update(new BasicDBObject().append("Email",email), newDocument);
        this.user_profile_data = my_profile(email);
    }
    public void post( String username ,String title, String post){
        Date d = new Date();
        Document doc = new Document("Date",d.toString()).append("UserName",username).append("Post",post).append("Title",title).append("likes",0);
        collection4.insertOne(doc);

        PostShow();
    }
    public void logout(String user , String value)
    {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("Available", value));

        coll.update(new BasicDBObject().append("Name",user), newDocument);
    }
    public void PostShow(){

        ArrayList<String[]> allposts = new ArrayList<String[]>();


        DBCursor cursor1 = coll2.find();
        while (cursor1.hasNext()){
            String[] interior = new String[4];
            DBObject main1 = cursor1.next();
            interior[1] = main1.get("Date").toString();
            interior[0] = main1.get("UserName").toString();
            interior[2] = main1.get("Title").toString();
            interior[3] = main1.get("Post").toString();
            allposts.add(0,interior);
        }
        this.mongoarraypostlist = allposts;



    }

    public String[] my_profile(String email)
    {
        String[] my_list = new String[8];
        BasicDBObject searchQuery1 = new BasicDBObject();
        searchQuery1.put("Email",email);
        DB db = mongoclient.getDB( "digitalclass" );
        DBCollection coll = db.getCollection("UserData");
        DBCursor cursor = coll.find(searchQuery1);

        while(cursor.hasNext()){
            DBObject main = cursor.next();
            my_list[0] = main.get("Name").toString();
            my_list[1] = main.get("Email").toString();
            my_list[2] = main.get("Password").toString();
            my_list[3] = main.get("Cms").toString();
            my_list[4] = main.get("Status").toString();
            my_list[5] = main.get("Available").toString();
            my_list[6] = main.get("Notification").toString();
            my_list[7] = main.get("No_of_Notifications").toString();


        }
        return  my_list;
    }

    public void users()
    {
        ArrayList<String[]> users = new ArrayList<String[]>();


        DBCursor cursor4 = coll1.find();
        while (cursor4.hasNext()){
            String[] interior_list = new String[2];
            DBObject main1 = cursor4.next();
            interior_list[0] = main1.get("Cms").toString();
            interior_list[1] =  main1.get("No_of_Notifications").toString();

            users.add(interior_list);

        }
        all_users = users;


    }





}

