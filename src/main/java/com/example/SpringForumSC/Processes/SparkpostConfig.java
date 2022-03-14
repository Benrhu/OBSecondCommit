package com.example.SpringForumSC.Processes;

import com.sparkpost.Client;

public class SparkpostConfig {
    private String apiKey = "1fa4af9d40fe71086d6d1d7b8b8a1156497f269f";
    Client client;


    public SparkpostConfig(){
        this.client = new Client(apiKey);
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}