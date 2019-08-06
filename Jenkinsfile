pipeline {
   //Donde se va a ejecutar el Pipeline
   agent {
       label 'Slave_Induccion'
   }
   
   //Opciones especÃƒÂ­ficas de Pipeline dentro del Pipeline
   options {
       //Mantener artefactos y salida de consola para el # especÃƒÂ­fico de ejecucionesrecientes del Pipeline.
       buildDiscarder(logRotator(numToKeepStr: '3'))
       //No permitir ejecuciones concurrentes de Pipeline
       disableConcurrentBuilds()
   }
   
   //Una secciÃƒÂ³n que define las herramientas para Ã¢â‚¬Å“autoinstalarÃ¢â‚¬ï¿½ y poner en la PATH
   tools {
       jdk 'JDK8_Centos'
       //Preinstalada en la ConfiguraciÃƒÂ³n del Master
       gradle 'Gradle4.5_Centos'
       //Preinstalada en la ConfiguraciÃƒÂ³n del Master
   }
   
   //AquÃƒÂ­ comienzan los Ã¢â‚¬Å“itemsÃ¢â‚¬ï¿½ del Pipeline
   stages{
       stage('Checkout') {
           steps{ 
               echo "------------>Checkout<------------"
               checkout([$class: 'GitSCM',
                        branches: [[name: '*/master']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        gitTool:'Git_Centos',
                        submoduleCfg: [],
                        userRemoteConfigs: [[credentialsId:'Github_fercho2000',
                        url:'https://github.com/fercho2000/PARQUEAERO-CEIBA']]])
           }  
       }
       stage('Unit Tests') {
           steps{
               echo "------------>Unit Tests<------------"
               sh 'gradle --b ./infraestructura/build.gradle test'
               sh 'gradle --b ./aplicacion/build.gradle test'
               sh 'gradle --b ./dominio/build.gradle test'
           }
       }
       stage('Integration Tests') {
           steps {
               echo "------------>Integration Tests<------------"
           }
       }
       stage('Static Code Analysis') {
           steps{
               echo '------------>AnÃƒÂ¡lisis de cÃƒÂ³digo estÃƒÂ¡tico<------------'
               withSonarQubeEnv('Sonar') {
                   sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"}
           }
       }
   
       stage('Build') {
           steps {
               echo "------------>Build<------------"
               sh 'gradle --b ./infraestructura/build.gradle build -x test'
               sh 'gradle --b ./aplicacion/build.gradle build -x test'
               sh 'gradle --b ./dominio/build.gradle build -x test'
           } 
       }
   }
 
	   post {
	         always {
	             echo 'This will always run'
	         }
	         success {
	             echo 'This will run only if successful'
	             junit '**/build/test-results/test/*.xml'
	         }
		         failure {
	 		echo 'This will run only if failed' 
	 		mail (to: 'jose.usuga@ceiba.com.co',subject: "Fallo Pipeline:${currentBuild.fullDisplayName}",
	 		body: "Algo est� mal con ${env.BUILD_URL}")
	 		}
		 }
	       
  }