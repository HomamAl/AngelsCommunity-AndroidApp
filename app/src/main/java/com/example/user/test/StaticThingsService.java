package com.example.user.test;

import java.util.ArrayList;
import java.util.List;

class StaticThingsService implements MyService {
    @Override
    public List<AThing> getThings() {
        ArrayList<AThing> aThings = new ArrayList<>();
        aThings.add(new AThing("test"));
        return aThings;
    }
}
