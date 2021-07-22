package com.shree.ecom.contacts.activityContactUs.model;

import com.shree.ecom.contacts.activityContactUs.contract.ContactUsContract;
import com.shree.ecom.contacts.activityContactUs.model.dto.ContactUsResponseEntity;
import com.shree.ecom.contacts.activityContactUs.model.repository.ContactUsRepository;

import io.reactivex.Observable;

/**
 * Created by shree on 16,May,2019
 */
public class ContactUsModel implements ContactUsContract.Model {

    private ContactUsRepository contactUsRepository;

    public ContactUsModel(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    @Override
    public Observable<ContactUsResponseEntity> saveQuery(String name, String email, String subject, String message) {
        return contactUsRepository.saveQuery(name, email, subject, message);
    }
}
