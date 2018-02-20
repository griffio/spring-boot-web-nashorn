// These are required by reactJs and should be provided by environment
global = {};
console = {};
console.debug = print;
console.warn = print;
console.log = print;
console.error = print;
//https://wiki.openjdk.java.net/display/Nashorn/Nashorn+extensions - map support
function render(template, model) {
    var data = {};
    for (var k in model) {
        if (model[k] instanceof Java.type("java.lang.Iterable")) {
            data[k] = Java.from(model[k]);
        } else {
            data[k] = model[k];
        }
    }
    var element = React.createElement(eval(template), data);
    // renderToStaticMarkup removes any react markup attributes (e.g data-reactid=".ho906m2sqd.1.0.0.3" from rendered markup
    return ReactDOMServer.renderToStaticMarkup(element);
}

function renderJsx(template, model) {
    var jsTemplate = Babel.transform(template, { presets: ['react'] }).code;
    return render(jsTemplate, model);
}