package one.suzamax

class Agent {
    def node

    Agent(agent) {
        if (!agent) this.node + "none"
        if (!agent.node) this.node = "any"
        if (agent.node) {
            def label = agent.node
            this.node = "{ node { label '${label}' } }"
        }
    }

    def getAgent() {
        return "agent ${node}"
    }
}