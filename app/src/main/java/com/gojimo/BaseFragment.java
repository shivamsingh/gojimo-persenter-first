package com.gojimo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.io.IOException;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.android.app.AppObservable;

public class BaseFragment extends Fragment {
    PublishSubject<Void> detached = PublishSubject.create();
    private AsyncLoader asyncLoader;
    private boolean isInit = false;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncLoader = AsyncLoader.dialog(getActivity());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        detached.onNext(null);
    }

    protected <T> Observable<T> bindObservable(Observable<T> in) {
        return AppObservable.bindFragment(this, in).takeUntil(detached);
    }

    public void showLoader() {
        try {
            asyncLoader.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void hideLoader() {
        try {
            asyncLoader.hide();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void error(final Throwable throwable) {
        throwable.printStackTrace();
        new Handler(Looper.getMainLooper()).post(() -> genericError(throwable));
    }

    private void genericError(final Throwable throwable) {
        String errorMessage =
                isNetworkError(throwable) ? "Network error" : "Some error occurred. Try again.";
        if (getActivity() != null) {
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
            hideLoader();
        }
    }

    private boolean isNetworkError(final Throwable throwable) {
        return throwable instanceof IOException;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isInit)
            hideLoader();
        isInit = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dismissLoader();
    }

    private void dismissLoader() {
        try {
            asyncLoader.dismiss();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
