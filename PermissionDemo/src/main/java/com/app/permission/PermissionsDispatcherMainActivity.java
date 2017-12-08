package com.app.permission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

//需添加v4包支持
@RuntimePermissions
public class PermissionsDispatcherMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //下面一行代码是添加 本类首注解@RuntimePermissions后重新build后自动生成
                PermissionsDispatcherMainActivityPermissionsDispatcher.callWithPermissionCheck(PermissionsDispatcherMainActivity.this);
//                PermissionsDispatcherMainActivityPermissionsDispatcher.toCallWithPermissionCheck(PermissionsDispatcherMainActivity.this);

            }
        });

    }


    //    NeedsPermission 表示 改方法需要那些权限
    @NeedsPermission(Manifest.permission.CALL_PHONE)
    void call() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18999999999"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }


    //    OnShowRationale 为什么需要当前权限  给用户一个解释
    @OnShowRationale(Manifest.permission.CALL_PHONE)
    void showRationaleForCamera(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("title")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        proceed 获取当前权限
                        request.proceed();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        cancel 取消当前权限的申请
                        request.cancel();
                    }
                })
                .show();
    }

    //    /OnPermissionDenied  权限被用户拒绝
    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
    void showDeniedForCamera() {
        Toast.makeText(this, "权限被拒绝", Toast.LENGTH_SHORT).show();
    }

    //    表示用户勾选了不再提示
    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
    void showNeverAskForCamera() {
        Toast.makeText(this, "不再提示", Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("NeedOnRequestPermissionsResult")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // 把授权的结果 让 PermissionsDispatcherMainActivityPermissionsDispatcher 处理
        PermissionsDispatcherMainActivityPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
    }
}

