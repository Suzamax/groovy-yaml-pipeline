package one.suzamax

import groovy.yaml.YamlSlurper

class YamlPipeline implements Serializable {
    def agent
    def env
    def stages
    def post
    YamlPipeline(file) {
        def pipelineFile = new File(file)
        def pipeline = new YamlSlurper().parse(pipelineFile)
        this.agent = new Agent(pipeline.agent)
        this.env = new Environment(pipeline.env)
        this.stages = []
        for (stage in pipeline.stages) {
            this.stages.add(new Stage(stage))
        }
        this.post = pipeline.post
    }

    def getPipeline() {
        def agentStr = this.agent.getAgent()
        def envStr = this.env.getEnv()
        def stagesStr = this.getStages(this.stages)
        def postStr = 
        return """pipeline {
            ${agentStr}
            ${envStr}
            ${stages}
            ${post}
        }"""
    }

    def getStages(stages) {
        String flatten = stages.keySet().stream()
            .map(key -> key + "=" + map.get(key))
            .collect(Collectors.joining("\n"))
        return """stages {
            ${flatten}
        }
        """
    }
}