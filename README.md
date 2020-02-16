## Introduction

* **How to extend scope** the speed can be different for right and left moving particles. Small change is needed to support this.

* **Implementation** this is a sping boot web service implementation. Have been tested by curl command and postman. Web layer test is not provided, since it is not the focus.

* **Test** curl -X POST "http://localhost:8080/animate" -H "Content-Type: application/json" -d '{ "speed": 2, "init": "LR..RL" }'

* **Python version** in another branch, just same logic in python implementation.
