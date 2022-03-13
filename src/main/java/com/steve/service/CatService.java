package com.steve.service;

import com.google.gson.Gson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.steve.util.RequestUtil;

@ApplicationScoped
public class CatService {

    @Inject
    RequestUtil util;

    public static final String CAT_URL = "https://catfact.ninja/fact";

    public CatFact retrieveRandomCatFact() {
        return new Gson().fromJson(util.getResource(CAT_URL), CatFact.class);
    }
}
