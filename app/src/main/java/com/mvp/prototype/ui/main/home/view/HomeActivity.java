package com.mvp.prototype.ui.main.home.view;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsMessage;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mvp.prototype.Constants;
import com.mvp.prototype.R;
import com.mvp.prototype.data.local.PreferencesHelper;
import com.mvp.prototype.data.model.LocationResponse;
import com.mvp.prototype.ui.base.BaseActivity;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;


public class HomeActivity extends BaseActivity implements HomeView {
    private static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 100;
    @Inject
    HomePresenter mHomePresenter;
    private BroadcastReceiver mSmsReceiver = null;
    private IntentFilter mSmsFilter;
    private Context mContext;
    private String uri;
    @Bind(R.id.app_bar)
    Toolbar mToolbar;
    @Bind(R.id.name)
    EditText mNameEditText;
    @Bind(R.id.latitude)
    EditText mLatEditText;
    @Bind(R.id.longitude)
    EditText mLongEditText;
    @Bind(R.id.loading_spinner)
    ProgressBar mProgressBar;
    @Bind(R.id.enter_no)
    Button mEnterNo;
    private String latitude;
    private String longitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mSmsFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        mSmsReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                processReceive(context, intent);
            }
        };
        // registerReceiver(mSmsReceiver, mSmsFilter);
        mContext = this;
        activityComponent().inject(this);
        mHomePresenter.attachView(this);
        ButterKnife.bind(this);
        if (PreferencesHelper.getSharedPreferenceString(mContext, Constants.FROM_FLAG) == null) {
            showEnterNoDialog(mContext);
        }
        mProgressBar.setVisibility(View.VISIBLE);
        mHomePresenter.getLocation();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.title_activity_dashboard);
    }

    private void showEnterNoDialog(final Context mContext) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.phone_no);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton(R.string.dialog_action_save,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!input.getText().toString().isEmpty()) {
                            PreferencesHelper.setSharedPreferenceString(mContext, Constants.FROM, input.getText().toString());
                            PreferencesHelper.setSharedPreferenceString(mContext, Constants.FROM_FLAG, Constants.TRUE);
                            if (ContextCompat.checkSelfPermission(mContext,
                                    Manifest.permission.RECEIVE_SMS)
                                    != PackageManager.PERMISSION_GRANTED) {
                                // Should we show an explanation? Yes using "shouldShowRequestPermissionRationale()"
                                ActivityCompat.requestPermissions(HomeActivity.this,
                                        new String[]{Manifest.permission.RECEIVE_SMS},
                                        MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
                            } else {
                                registerReceiver(mSmsReceiver, mSmsFilter);
                            }
                        } else {
                            Toast.makeText(HomeActivity.this, R.string.enter_number, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void processReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = null;
        String strMessage = "";
        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            messages = new SmsMessage[pdus.length];
            for (int i = 0; i < messages.length; i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = bundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                } else {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                String senderNo = messages[i].getOriginatingAddress();
                String savedNo = PreferencesHelper.getSharedPreferenceString(mContext, Constants.FROM);
                if (savedNo != null) {
                    if (senderNo.equals(savedNo) || senderNo.contains(savedNo)) {
                        String messageBody = messages[i].getMessageBody();
                        if (messageBody.contains("mvp-demo-")) {
                            String name = messageBody.substring(messageBody.indexOf("mvp-demo-") + "mvp-demo-".length());
                            mNameEditText.setText(name);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mSmsReceiver, mSmsFilter);
        clearFields();
    }

    private void clearFields() {
        mNameEditText.setText(Constants.EMPTY_STRING);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mSmsReceiver);
    }

    @OnClick(R.id.locate)
    void onLocate() {
        if (!mNameEditText.getText().toString().isEmpty() && !mLatEditText.getText().toString().isEmpty() && !mLongEditText.getText().toString().isEmpty()) {
            uri = String.format(Locale.ENGLISH, Constants.MAP_URI, Double.parseDouble(latitude), Double.parseDouble(longitude), mNameEditText.getText().toString(), Constants.MAP_ZOOM_LEVEL);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                Toast.makeText(HomeActivity.this, R.string.no_map_app, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(HomeActivity.this, "Name Unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.enter_no)
    void onEnterNo() {
        showEnterNoDialog(mContext);
    }

    @Override
    public void onSuccess(LocationResponse locationResponse) {
        latitude = locationResponse.getPoint().getLatitude();
        longitude = locationResponse.getPoint().getLongitude();
        mProgressBar.setVisibility(View.GONE);
        mLatEditText.setText(latitude);
        mLongEditText.setText(longitude);

    }

    @Override
    public void onFailure(RetrofitError error) {
        Toast.makeText(HomeActivity.this, R.string.unexpected_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    registerReceiver(mSmsReceiver, mSmsFilter);
                } else {
                    Toast.makeText(HomeActivity.this, R.string.permission_message, Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }

}
