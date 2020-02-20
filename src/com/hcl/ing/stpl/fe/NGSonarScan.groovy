package com.hcl.ing.stpl.fe

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class NGSonarScan extends BuildingBlock implements Serializable{

    static def run(script, config) {
        BuildingBlock bb = new MavenBuild(script)
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

            script.withDockerContainer(EXECUTOR_IMAGE) {
                script.withCredentials([script.usernamePassword(credentialsId: 'sonarqube', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    script.sh "sonar-scanner -Dsonar.host.url=http://35.180.103.243:9000/ -Dsonar.login=$user -Dsonar.password=$pass"
                }

            }
        }

    }

}
