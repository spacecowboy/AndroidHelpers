DualPaneLayout - A simple implementation of a tablet friendly layout
====================================================================

This is a simple demonstration on how to structure your application using fragments and
variable layout files depending on screen width.
This allows you to take advantage of the screen of tablets while still fully supporting phones.

## Features

* Small screens (phones) will display each fragment full screen

<img src="http://i.imgur.com/4GaV9.png" height="50%"/> 
<img src="http://i.imgur.com/frAx4.png" height="50%"/>

* Medium screens (tablet portrait mode) will display both fragments but the left fragment
can be hidden. When the left fragment is visible, the right fragment is 50% drawn off screen.
Clicking inside the right fragment will hide the left fragment by sliding it out of the screen.
Clicking the application icon will bring the list back.

<img src="http://i.imgur.com/MSiIQ.png" height="50%"/>
<img src="http://i.imgur.com/ir97R.png" height="50%"/>

* Large screens (tablet landscape mode) will display both fragments always

<img src="http://i.imgur.com/Z1w7p.png" height="50%"/>

To use this in your own application, use my demo app as a base for how to override the
necessary methods and make sure to
change the class names in the **layout.xml** files as well. If you want to change the relative widths
of the fragments, change the weights in **layout_constants.xml**

Feel free to use this code any way you please.