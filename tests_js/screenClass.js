var client = require('./client');
var colors = require('colors/safe');


function Screen(locator, pageObject) {

    this.locator = locator;
    this.pageObject = pageObject;

}

Screen.prototype.isInitialized = function(locator, pageObject) {
    pageObject.isVisible(locator).then(function(isVisible) {
        report = (isVisible) ? colors.green("The element " + locator + " is present") : colors.red("Failed: the element " + locator + " is NOT present!");
        console.log(report);
    })
};

Screen.prototype.submitScreen = function(locator, pageObject) {
    return pageObject.click(locator);
};

Screen.prototype.finalAssertion = function(locator, pageObject) {
    pageObject.isVisible(locator).then(function(isVisible) {
        report = (isVisible) ? colors.green("Passed") : colors.red("Failed: the element " + locator + " is NOT present!");
        console.log(report);
    })
};
module.exports = Screen; 
	
	