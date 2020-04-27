# TLIB.00-StartingCode

## Finding Libraries

Finding a library that fits your needs starts where all the rest of your questions have been answered so far: that's right, [stackoverflow](http://stackoverflow.com/).

Libraries are useful for solving problems that appear over and over again in different applications. 
If you search Stack Overflow, often the accepted solution to the problem you are trying to solve will be a third party library that does exactly what you're looking for.

I'd also like to mention two more resources for finding libraries: The first one is [Android Arsenal](https://android-arsenal.com/), which is a large library of libraries (aha) that just about anyone can add to. 
There are literally thousands of libraries on here, of highly varied quality. 
The second resource is this [Github](https://github.com/codepath/android_guides/wiki/Must-Have-libraries) page, which lists some of the most commonly used android libraries.

## But Wait!

A word of caution: just because there is a library that seems like a perfect fit for your need, do not be too hasty in adding it to your application. 
Using a library that is not well maintained or documented comes with a host of other issues and is likely to cause more of a headache than it cures. 
The next video will be devoted to figuring out whether a library is a good candidate for your application.
[64K Method Limit](https://developer.android.com/studio/build/multidex.html)

Another consideration in deciding whether or not to use a library is to be aware of how it will affect the size of your app. 
When your app, including the libraries it uses, reaches a certain size, you encounter build errors that indicate your app has reached a limit of the Android app build architecture ([64K Method Limit](https://developer.android.com/studio/build/multidex.html)). 
Libraries are commonly used and without a doubt efficient, but do be aware of theses considerations.

## Instructor Notes
   
For more information on licenses and which licenses to use, check out this [link](https://choosealicense.com/)


## Google Motion Vision Library

## Starter Code

__```resamplePic()```__: This method gets the height and width of the device screen in pixels, and resamples the passed in image to fit the screen.

__```createTempImageFile()```__: This method creates a temporary file in the external cache directory and returns the new temp file.

__```deleteImageFile()```__: This method attempts to delete the image at the passed in path. 
If it fails, it shows a toast.

__```galleryAddPic()```__: This method cause the image content provider to add the image from the passed in path to the system gallery, so it can be found by other app. 
It is only called inside the saveImage() described below.

__```saveImage()```__: This method saves the passed in Bitmap in the External Storage, in the subdirectory called "Emojify". 
It also adds the image to the system gallery by calling the above ```galleryAddPic()```.

__```shareImage()```__: This method creates a share implicit intent, which will bring up the system chooser with apps that handle sharing an image.


