package one.suzamax

class Stage implements Serializable {
    def name
    def steps
    def when

    Stage(stg) {
        this.name = stg.name
        this.steps = new Step(stg.steps)
        this.when = stg.when || null
    }

    def getStage() { 
        def whenStr = stringifyWhen(this.when, this.steps)
        return """stage (${name}) {
            ${whenStr}
        }
        """
    }

    def stringifyWhen(when, steps) {
        if (when) return """
            when (${when}) {
                steps {
                    ${steps}
                }
            }
        """
        return """
            steps {
                ${steps}
            }
        """
    }
}