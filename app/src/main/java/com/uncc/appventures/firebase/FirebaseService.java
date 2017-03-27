package com.uncc.appventures.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Sanket on 2/17/2017.
 */

public class FirebaseService {

    private static DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    //private static FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();


    public static DatabaseReference getRootRef(){
        return rootRef.child("Cabinet");
    }

    public static void isConnected() {
        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Log.d("LGL", "connected");
                } else {
                    Log.d("LGL", "not connected");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.d("LGL", "Listener was cancelled");
            }
        });
    }

    //public static StorageReference getStorageRef() {
    //    return firebaseStorage.getReference("messageImages");
   // }
}
