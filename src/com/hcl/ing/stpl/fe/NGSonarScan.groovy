package com.hcl.ing.stpl.fe

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class NGSonarScan extends BuildingBlock implements Serializable {

    static def run(script, config) {
        BuildingBlock bb = new NGSonarScan(script)
        bb.initialize(config)
        bb.run()

    }

    NGSonarScan(script) {
        super(script)
        EXECUTOR_IMAGE = "emeraldsquad/sonar-scanner"
    }

    @Override
    def run() {

        script.stage("NG Sonar Scan") {
            script.withSonarQubeEnv(credentialsId: 'sonarqube-server') {
                script.withDockerContainer(EXECUTOR_IMAGE) {
                    script.sh "sonar-scanner"
                }
            }
        }

    }

}
