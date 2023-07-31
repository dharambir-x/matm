package com.dharamart.plugins.matm;

import android.content.Context;
import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.service.finopayment.Hostnew;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

@CapacitorPlugin(name = "veer")
public class veerPlugin extends Plugin {
    char[] chars = new char[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
    private veer implementation = new veer();
    @PluginMethod()
    public void echo(PluginCall call) {
        Context context = getContext();
        String txntype = call.getString("txntype");
        String amount = call.getString("amount");
        Intent intent = new Intent(context, Hostnew.class);
        intent.putExtra("partnerId", "PS0031");
        intent.putExtra("apiKey", "UFMwMDMxYTFjOGVmYjRhYjA0MGI0MWVmY2Q0MzY0YzRkZjg1NTM=");
        intent.putExtra("transactionType", txntype);
        intent.putExtra("amount", amount);
        intent.putExtra("merchantCode", "dharam1234");
        intent.putExtra("remarks", "Test Transaction");
        intent.putExtra("mobileNumber", "9892510989");
        intent.putExtra("referenceNumber", getRandomString(5, chars));
        intent.putExtra("latitude", "22.572646");
        intent.putExtra("longitude", "88.363895");
        intent.putExtra("subMerchantId", "dharam1234");
        intent.putExtra("deviceManufacturerId", "3");
        startActivityForResult(call, intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
    @Override
    protected void onActivityResult(PluginCall call, Intent data) {
        if (data != null) {
            boolean status = data.getBooleanExtra("status", false);
            int response = data.getIntExtra("response", 0);
            String message = data.getStringExtra("message");
            if (status) {
                try {
                    JSONObject jsonObject = new JSONObject(String.valueOf(data.getStringExtra("JSONDATA")));
                    JSObject result = new JSObject();
                    result.put("resultData", jsonObject);
                    call.resolve(result);
                } catch (JSONException jsonException) {
                    call.reject("Activity failed. ");
                }
            } else {
                call.reject("Activity failed  ");
            }
        }
    }
    public String getRandomString(int length, char[] characterSet) {
        StringBuilder sb = new StringBuilder();
        for (int loop = 0; loop < length; loop++) {
            int index = new Random().nextInt(characterSet.length);
            sb.append(characterSet[index]);
        }
        String nonce = sb.toString();
        return nonce;
    }
}
