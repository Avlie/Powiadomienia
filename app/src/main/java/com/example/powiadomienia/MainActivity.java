package com.example.powiadomienia;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "my_channel_id";
    private static final int NOTIFICATION_ID = 1;
    private static int ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Notificationhelper.createNotificationChannel(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }

            Button button = findViewById(R.id.button);
            button.setOnClickListener(v -> {
                Notificationhelper.setNotification(ID, Notificationhelper.CHANNEL_ID_LOW, this, "Nowe", "ВСЕ ПЛОХА", 1);
                ID++;
            });
            Button button1 = findViewById(R.id.button1);
            button1.setOnClickListener(v -> {
                Notificationhelper.setNotification(ID, Notificationhelper.CHANNEL_ID_DEFAULT, this, "Nowe", "ВСЕ ПЛОХА МИР ВЗАРВЕТСА", 2);
                ID++;
            });
            Button ButtonPicture = findViewById(R.id.PictureButton);
            ButtonPicture.setOnClickListener(v -> {
                Notificationhelper.setNotification(ID, Notificationhelper.CHANNEL_ID_HIGH, this, "Nowe", "ВСЕ ПЛОХА МИР ВЗАРВЕТСА 228", 3);
                ID++;
            });
            Button Addline = findViewById(R.id.Addline);
            Addline.setOnClickListener(v -> {
                Notificationhelper.setNotification(ID, Notificationhelper.CHANNEL_ID_HIGH, this, "Nowe", "танцювала риба з раком", 3);
                ID++;
            });
        }

    }
}



