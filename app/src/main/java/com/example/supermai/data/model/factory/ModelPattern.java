package com.example.supermai.data.model.factory;
import com.google.gson.Gson;
import java.io.Serializable;

public abstract class ModelPattern implements Serializable {
    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
