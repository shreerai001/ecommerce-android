package com.shree.ecom.utils.mvp;

public interface BaseView {
    //To display message on snackbar
    void displayMessage(String message);

    //To display message on toast
    void displayTransferMessage(String message);

    void progressOn(boolean progressState);

    void stop();

}
