package com.uncc.appventures.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Sanket on 2/17/2017.
 */

public class FirebaseService {

    public static DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    public static FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();


    public static DatabaseReference getRootRef(){
        return rootRef.child("Cabinet");
    }

    public static StorageReference getStorageRef() {
        return firebaseStorage.getReference("messageImages");
    }
}
