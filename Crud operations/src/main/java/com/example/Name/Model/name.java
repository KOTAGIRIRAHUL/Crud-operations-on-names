package com.example.Name.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class name {



        @Id
        private String namesId;
        private String namesName;
        private String namesGender;
        private String location;
        private String namesEmail;

        public String getNamesId() {

            return namesId;
        }
        public void setProductId(String namesId) {
            this.namesId = namesId;
        }
        public String getNamesName() {
            return namesName;
        }
        public void setNamesName(String namesName) {
            this.namesName = namesName;
        }
        public String getNamesGender() {
            return namesGender;
        }
        public void setNamesGender(String namesGender) {
            this.namesGender = namesGender;
        }

        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }


        public String getnamesEmail() {
            return namesEmail;
        }
        public void setFarmerEmail(String namesEmail) {
            this.namesEmail = namesEmail;
        }
        public name(String namesId, String namesName, String namesGender, String location,
                    String namesEmailEmail) {
            super();
            this.namesId = namesId;
            this.namesName = namesName;
            this.namesGender = namesGender;
            this.location = location;
            this.namesEmail = namesEmail;
        }
        public name() {
            super();
        }



    }
