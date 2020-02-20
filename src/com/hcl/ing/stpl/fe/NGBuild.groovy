package com.hcl.ing.stpl.fe

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class NGBuild extends BuildingBlock implements Serializable {


    static def run(script, config) {
        BuildingBlock bb = new NGBuild(script)
        bb.initialize(config)
        bb.run()

    }

    NGBuild(script) {
        super(script)
        EXECUTOR_IMAGE = "teracy/angular-cli"
    }

    @Override
    def run() {

        script.stage("NG Build") {
            script.withDockerContainer(EXECUTOR_IMAGE) {
                script.sh "npm install"
                script.sh "ng build"
            }
        }

    }


}
