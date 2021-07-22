package com.shree.ecom.contacts.activityContactUs.model.repository;

import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;
import com.shree.ecom.contacts.activityContactUs.services.ContactUsApiService;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public class ContactUsRepositoryIMPL implements ContactUsRepository {
    private ContactUsApiService contactUsApiService;

    public ContactUsRepositoryIMPL(ContactUsApiService contactUsApiService) {
        this.contactUsApiService = contactUsApiService;
    }

    @Override
    public Observable<ContactUsResponseEntity> saveQuery(String name, String email, String subject, String message) {
        return contactUsApiService.sendQuery(name, email, subject, message);
    }
}
