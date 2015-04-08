// These are required by reactJs and should be provided by environment
global = {};
console = {};
console.debug = print;
console.warn = print;
console.log = print;

function render(template, model) {
    var data = {};
    for(var k in model) data[k]=model[k];
    var element = React.createElement(eval(template), data);
    // renderToStaticMarkup removes any react markup attributes (e.g data-reactid=".ho906m2sqd.1.0.0.3" from rendered markup
    return React.renderToStaticMarkup(element);
}

function renderJsx(template, model) {
    var jsTemplate = JSXTransformer.transform(template).code;
    return render(jsTemplate, model);
}