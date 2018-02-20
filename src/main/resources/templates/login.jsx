createReactClass({
    render: function() {
        return <html><head><title>{this.props.title}</title></head>
        <body><div>
        <form>
            <label>Username</label>
            <input type="text" name="username"/>
            <label>Password</label>
            <input type="text" name="password"/>
        </form>
        </div></body>
        </html>
    }
});