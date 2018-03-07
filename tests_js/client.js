const wdio = require('webdriverio');

var client;

function client() {
    this.title = 'client';
    const opts = {
        port: 4723,
        desiredCapabilities: {
            platformName: "Android",
            platformVersion: "8.1.0",
            deviceName: "Android Emulator",
            app: "C:/Users/ruvzherdev/Desktop/Appium/ApiDemos-debug.apk",
            automationName: "UiAutomator2"
        }
    }

    return client = wdio.remote(opts).init();

};



module.exports = client();