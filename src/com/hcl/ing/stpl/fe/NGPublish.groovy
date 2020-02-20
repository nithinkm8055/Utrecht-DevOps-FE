package com.hcl.ing.stpl.fe

import com.hcl.ing.stpl.buildingblock.BuildingBlock

class NGPublish extends BuildingBlock implements Serializable{

    static def run(script, config) {
        BuildingBlock bb = new NGPublish(script)
        bb.initialize(config)
        bb.run()

    }

    NGPublish(script) {
        super(script)
        EXECUTOR_IMAGE = "teracy/angular-cli"
    }

    @Override
    def run() {

        script.stage("NG Publish") {
            script.echo "NG Publish"
        }

    }
}
