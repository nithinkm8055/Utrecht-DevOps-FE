import com.hcl.ing.stpl.Checkout
import com.hcl.ing.stpl.fe.NGBuild
import com.hcl.ing.stpl.fe.NGSonarScan
import com.hcl.ing.stpl.flow.Flow


def call(Map<String, String> projectConfig) {

    Flow flow = new Flow(this, 'STPL_FE')
    def config = flow.initConfig(projectConfig)

    flow.run {

        Checkout.run(this, config)
        NGBuild.run(this, config)
        NGSonarScan.run(this, config)

    }
}

