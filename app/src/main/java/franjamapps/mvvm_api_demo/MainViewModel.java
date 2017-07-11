package franjamapps.mvvm_api_demo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

public class MainViewModel extends BaseObservable {
    private static final String TAB = "\t";

    private final ObservableField<String> updatedTextFromObservable = new ObservableField<>();
    private String updatedTextFromNotify;

    private Context context;
    private int clicksCounter;
    private String labelForObservable;
    private String labelForNotify;

    public MainViewModel(@NonNull Context context) {
        this.context = context;
        this.labelForObservable = getTextFromId(R.string.observable_text);
        this.labelForNotify = getTextFromId(R.string.notify_text_tag);
    }

    @Bindable
    public String getUpdatedTextFromNotify() {
        return this.updatedTextFromNotify;
    }

    @Bindable
    public ObservableField<String> getUpdatedTextFromObservable() {
        return updatedTextFromObservable;
    }

    public void onClickWithObservableText() {
        clicksCounter++;
        String clickType = getTextFromId(R.string.odd);

        if (clicksCounter % 2 == 0) {
            clickType = getTextFromId(R.string.even);
        }
        updateObservableText(labelForObservable + TAB + clickType);
    }

    public void onClickWithNotifiedText() {
        clicksCounter++;
        updatedTextFromNotify = labelForNotify + TAB + clicksCounter;
        notifyPropertyChanged(BR.updatedTextFromNotify);
    }

    @VisibleForTesting
    void updateObservableText(final String input) {
        updatedTextFromObservable.set(input);
    }

    private String getTextFromId(int id) {
        if (context == null) return "";

        return context.getString(id);
    }
}