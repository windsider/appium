var client = require('./client');
var Screen = require('./screenClass');
var appItem = '~App';
var devadminItem = "~Device Admin";
var encr = "android.widget.FrameLayout";

var initialScreen = new Screen(appItem, client);
initialScreen.isInitialized(appItem, client);

var secondScreen = initialScreen.submitScreen(appItem, client);
initialScreen.isInitialized(devadminItem, secondScreen);

finalScreen = initialScreen.submitScreen(devadminItem, secondScreen);
initialScreen.finalAssertion(encr, finalScreen);







