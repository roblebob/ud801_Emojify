# Exercise: Overlay Emoji - Step 1

The ```whichEmoji()``` method already determines the proper Emoji based on the facial expression.

You should now use it in a switch statement to select the proper emoji drawable. Do the following:

- Change the return type of the ```whichEmoji()``` method to the __Emoji enum__.

- At the end of the method, return the proper Emoji.

- Rename the ```detectFaces()``` method to ```detectFacesAndOverlayEmoji()``` since this method will now overlay the proper drawable as well as detect the faces, and change it's return type from void to Bitmap. 

- Initialize an empty drawable inside the loop which iterates through the detected faces called emojiBitmap, used to hold the correct emoji drawable. 

- Create a switch statement using the result of the ```whichEmoji()``` method as the argument, with a case for each Emoji, and use the ```BitmapFactory.decodeResource()``` method to define the initialized drawable to be the appropriate Emoji based on the result of the switch.

You should now have the following components: 
- The original picture bitmap from the camera, passed into the ```detectFacesAndOverlayEmoji()``` method. 
- The appropriate Emoji bitmap for each face, defined inside the faces for loop. 
- The detected face, again defined inside the loop.

The next step involves creating a new method, ```addBitmapToFace()```, which takes the three components we just discussed (picture bitmap, Emoji bitmap, and Face object), and combines them, overlaying the Emoji bitmap over the detected face on each iteration of the loop and returning the resulting, combined bitmap.

Combining Bitmaps is straightforward, but outside of the scope of this lesson. 
You can copy the code for this method below, and I will step through the functionality in the next node. 
For a more detailed explanation on working with 2D graphics take a look at the [Developer Docs](https://developer.android.com/guide/topics/graphics/2d-graphics.html).


```
/**
* Combines the original picture with the emoji bitmaps
*
* @param backgroundBitmap The original picture
* @param emojiBitmap      The chosen emoji
* @param face             The detected face
* @return The final bitmap, including the emojis over the faces
*/
private static Bitmap addBitmapToFace(Bitmap backgroundBitmap, Bitmap emojiBitmap, Face face) {

   // Initialize the results bitmap to be a mutable copy of the original image
   Bitmap resultBitmap = Bitmap.createBitmap(backgroundBitmap.getWidth(),
           backgroundBitmap.getHeight(), backgroundBitmap.getConfig());

   // Scale the emoji so it looks better on the face
   float scaleFactor = EMOJI_SCALE_FACTOR;

   // Determine the size of the emoji to match the width of the face and preserve aspect ratio
   int newEmojiWidth = (int) (face.getWidth() * scaleFactor);
   int newEmojiHeight = (int) (emojiBitmap.getHeight() *
           newEmojiWidth / emojiBitmap.getWidth() * scaleFactor);


   // Scale the emoji
   emojiBitmap = Bitmap.createScaledBitmap(emojiBitmap, newEmojiWidth, newEmojiHeight, false);

   // Determine the emoji position so it best lines up with the face
   float emojiPositionX =
           (face.getPosition().x + face.getWidth() / 2) - emojiBitmap.getWidth() / 2;
   float emojiPositionY =
           (face.getPosition().y + face.getHeight() / 2) - emojiBitmap.getHeight() / 3;

   // Create the canvas and draw the bitmaps to it
   Canvas canvas = new Canvas(resultBitmap);
   canvas.drawBitmap(backgroundBitmap, 0, 0, null);
   canvas.drawBitmap(emojiBitmap, emojiPositionX, emojiPositionY, null);

   return resultBitmap;
}
```