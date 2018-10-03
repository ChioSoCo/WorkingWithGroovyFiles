node { //allocates a Jenkins executor and the workspace for the Pipeline
	stage ('Clone second git repository'){ //Define a stage/step of the pipeline called "Clone second git repository"
		try { //using try/catch structure to get the errors
			repoclone() //executes the repoclone function
			def responder //define a variable 
			println responder //prints the variable			responder.hello('hello')
		} catch (Exception err){ //using try/catch structure to get the errors
			println err
		}
	}
}

def repoclone(){ //defines a function called "repoclone"
	checkout([$class: 'GitSCM', branches: [[name: '*/'+'master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory'], [$class: 'MessageExclusion', excludeMessage: '(?s).*JENKINS_IGNORE.*']], submoduleCfg: [], userRemoteConfigs: [[url:"https://github.com/ChioSoCo/WorkingWithGroovyFiles.git"]]])
	}
