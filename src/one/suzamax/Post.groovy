package one.suzamax

class Post implements Serializable {
    def always
    def failure
    def success
    def cleanup

    Post(post) {
        this.always = post.always
        this.failure = post.failure
        this.success = post.success
    }

    def getPost() { 
        def postStr = stringify(
            this.always,
            this.failure,
            this.success,
            this.cleanup
        )
        return """post {
            ${postStr}
        }
        """
    }

    def stringify(a, f, s, c) {
        def str = ""
        if (a) str += """
            always {
                ${a}
            }
        """

        if (f) str += """
            failure {
                ${f}
            }
        """

        if (s) str += """
            failure {
                ${s}
            }
        """
        if (c) str += """
            failure {
                ${c}
            }
        """
        return str
    }
}