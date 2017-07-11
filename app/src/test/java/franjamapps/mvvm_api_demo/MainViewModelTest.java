package franjamapps.mvvm_api_demo;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainViewModelTest {

    private MainViewModel spyViewModel;

    @Before
    public void setup() throws Exception {
        Context mockContext = mock(Context.class);
        MainViewModel mainViewModel = new MainViewModel(mockContext);
        spyViewModel = spy(mainViewModel);
    }

    @Test
    public void onClickWithObservableTest() throws Exception {
        spyViewModel.onClickWithObservableText();

        verify(spyViewModel, times(1)).updateObservableText(anyString());
    }

    @Test
    public void onClickWithNotifyTest() throws Exception {
        spyViewModel.onClickWithNotifiedText();

        verify(spyViewModel, times(1)).notifyPropertyChanged(BR.updatedTextFromNotify);
    }
}