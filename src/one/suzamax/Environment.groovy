package one.suzamax

class Environment {
    def envVars = [:]
    Environment(env) {
        for (envVar in env) {
            this.envVars[envVar.name] = envVar.value
        }
    }

    def getEnv() {
        String flatten = envVars.keySet().stream()
            .map(key -> key + "=" + map.get(key))
            .collect(Collectors.joining("\n"))
        return """environment {
            ${flatten}
        }"""
    }
}