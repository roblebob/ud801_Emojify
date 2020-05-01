package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

// TODO [✓] (1): Create a Java class called Emojifier
public class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    // TODO [✓] (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.
    public static void detectFaces( Context context, Bitmap bitmap) {

        // TODO [✓] (2a): Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector .Builder( context)

                // to improve performance by disabling tracking (which maintains an ID between consecutive frames if the same face exists in both of them
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                //

                .build();

        // TODO [✓] (2b):  Build the frame
        Frame frame = new Frame .Builder()
                .setBitmap( bitmap)
                .build();

        // TODO [✓] (2c): Detect the faces
        SparseArray< Face> faces = detector .detect( frame);

        // TODO [✓] (2d): Log the number of faces
        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());

        // TODO [✓] (2e): If there are no faces detected, show a Toast message
        if( faces.size() == 0){ Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show(); }

        // TODO [✓] (2f): Release the detector
        detector .release();
    }
}
