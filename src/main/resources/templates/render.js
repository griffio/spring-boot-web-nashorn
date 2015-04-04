function render(template, model) {
    var compiledTemplate = Handlebars.compile(template)
    return compiledTemplate(model);
}
