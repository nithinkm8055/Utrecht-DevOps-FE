**Utrecht-DevOps-FE**

This a standard pipeline for FE.
This pipeline follows all the standard and guidelines with appropriate build breakers implemented at each stage.
This is a dockerized pipeline and each stage runs isolated  in  it's own container.



**Pipeline Usage**

```
@Library(['stpl-pipeline-fe']) _

def config = [:]

frontendSTPL(config)

```
