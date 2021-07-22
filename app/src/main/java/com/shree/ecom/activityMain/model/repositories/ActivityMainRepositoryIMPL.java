package com.shree.ecom.activityMain.model.repositories;

import com.shree.ecom.activityMain.ActivityMainApiService;

public class ActivityMainRepositoryIMPL implements ActivityMainRepository {
    private ActivityMainApiService activityMainApiService;

    public ActivityMainRepositoryIMPL(ActivityMainApiService activityMainApiService) {
        this.activityMainApiService = activityMainApiService;
    }
}
