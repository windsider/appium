var client = require('./client');
var Screen = require('./screenClass');
var appItem = '~App';
var devadminItem = "~Device Admin";
var encr = '/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup';
var initScn;
var secScn;

var initialScreen = new Screen(appItem, client);
var secondScreen = new Screen(devadminItem, client);


initialScreen.isInitialized(appItem, client);
initScn = initialScreen.submitScreen(appItem, client);

secondScreen.isInitialized(devadminItem, initScn);
secScn = secondScreen.submitScreen(devadminItem, initScn);

initialScreen.finalAssertion(encr, secScn);