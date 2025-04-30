package com.example.myapplication;
import com.google.gson.annotations.SerializedName;


public class User_data {

        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("email")
        public String email;

        public User_data(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


}
