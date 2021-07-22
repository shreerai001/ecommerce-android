package com.shree.ecom.contacts.activityContactUs.model.repository;

import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public interface ContactUsRepository {
    Observable<ContactUsResponseEntity> saveQuery(String name, String email, String subject, String message);
}
