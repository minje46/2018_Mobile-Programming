package com.example.kwak.android_study1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    public static final String TAG = "SmsReceiver";
    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(TAG, "onReceive() 메소드 호출됨");

        // 인텐트 안에 들어 있는 SMS 메시지를 파싱한다.
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages != null && messages.length > 0){
            // SMS 발신 번호 확인
            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG,"SMS sender : "+sender);

            // SMS 메시지 확인
            String contents = messages[0].getMessageBody().toString();
            Log.i(TAG,"SMS contents : "+contents);

            // SMS 수신 시간 확인
            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.i(TAG, "SMS received date : " + receivedDate.toString());

            sendToActivity(context, sender, contents, receivedDate);
        }
        throw new UnsupportedOperationException("Not yet implemented");

    }
    // Intent 객체 안에 있는 SMS  데이터를 확인하고 Sms message 객체로 변환하는 API. (나중에 동일하게 코드 이용 가능.)
    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];

        int smsCount = objs.length;
        for (int i = 0; i < smsCount; i++) {
            // PDU 포맷으로 되어 있는 메시지를 복원한다.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // API 23 이상
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }
        return messages;
    }

    private void sendToActivity(Context context, String sender, String contents, Date receivedDate){
        // 메시지를 보여줄 엑티비티를 띄워준다.
        Intent myIntent = new Intent(context, MainActivity.class);

        // 플래그를 이용한다.
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("sender", sender);
        myIntent.putExtra("contents", contents);
        myIntent.putExtra("receiveDate", format.format(receivedDate));

        context.startActivity(myIntent);
    }
}
