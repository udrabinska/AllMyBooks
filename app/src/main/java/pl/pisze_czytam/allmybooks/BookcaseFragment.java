package pl.pisze_czytam.allmybooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import pl.pisze_czytam.allmybooks.databinding.BookcaseFragmentBinding;
import pl.pisze_czytam.allmybooks.databinding.BookcaseMainBinding;

public class BookcaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bookcase_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView bookcaseNumber = getView().findViewById(R.id.case_number);
        bookcaseNumber.setText("bla bla");
    }
}
