# ETSF01 Project - Analogy-based effort estimation for software projects
A project in the course [ETSF01](http://cs.lth.se/english/course/etsf01/) Software Engineering Process - Economy and Quality at Lund University 2012 by group 17. The goal is to 

* connect theory  to  practice,
* give a concrete experience of developing and using a tool for software cost estimation,
* and to provide a group-learning setting focused on realistic problem.

For further documentation; visit [doc/](https://github.com/erikw/etsf01_project/tree/master/doc).

## How to build and run
Compile and run by typing the following commands:

	$cd etsf01_project/
	$ant distribute
	$./estimator.sh [<data filename>]
	$./config.sh | ./estimator.sh [<data filename>]

The first `estimator.sh` command will present an interactive interface where you will answer the questions about you project, enter threshold and you will get estimates for your project. In the seconds form a static configuration from the script `config.sh` will be fed to the program. You can edit the values in that script your self.


##Contributors

[Oscar Olsson](https://github.com/DrunkenInfant)

[Erik Westrup](https://github.com/erikw)

[Jonas Klauber](https://github.com/allanjonas)

[Simon Thörnqvist](https://github.com/drowzyorginal)

[Fredrik Petterson](https://github.com/hyperremix)

[Tommy Ivarsson](https://github.com/tomeo)
