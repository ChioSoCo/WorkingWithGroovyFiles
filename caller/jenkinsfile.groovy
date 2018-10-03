def gitUser = ''

node {
	stage ('Clone second git repository'){
		try {
			repoclone()
			def responder
			println responder
			responder = load 'responder.groovy'
			println responder
			responder.hello('hello')
		} catch (Exception err){
			println err
		}
	}
}

def repoclone(){
	checkout([$class: 'GitSCM', branches: [[name: '*/'+'master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory'], [$class: 'MessageExclusion', excludeMessage: '(?s).*JENKINS_IGNORE.*']], submoduleCfg: [], userRemoteConfigs: [[url:"https://github.com/ChioSoCo/WorkingWithGroovyFiles.git"]]])
	}
