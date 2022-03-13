package com.steve.service;

import com.google.gson.Gson;

import javax.enterprise.context.ApplicationScoped;

import com.steve.util.RequestUtil;

@ApplicationScoped
public class CatService {

    private static final String CAT_URL = "https://catfact.ninja/fact";

    public CatFact retrieveRandomCatFact() {
        return new Gson().fromJson(RequestUtil.getResource(CAT_URL), CatFact.class);
    }
}
