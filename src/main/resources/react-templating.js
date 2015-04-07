global = {};
console = {};
console.debug = print;
console.warn = print;
console.log = print;

function render(template, model) {
    var data = {};
    for(var k in model) data[k]=model[k];
    var element = React.createElement(eval(template), data);
    return React.renderToStaticMarkup(element);
}

function renderJsx(template, model) {
    var jsTemplate = JSXTransformer.transform(template).code;
    return render(jsTemplate, model);
}