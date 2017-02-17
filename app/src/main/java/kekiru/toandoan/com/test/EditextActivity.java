package kekiru.toandoan.com.test;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kekiru.toandoan.com.test.databinding.ActivityEditextBinding;

public class EditextActivity extends AppCompatActivity {
    private ObservableField<String> mString = new ObservableField<>();
    private ActivityEditextBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_editext);
        mBinding.setActivity(this);
    }

    public ObservableField<String> getString() {
        return mString;
    }
}
