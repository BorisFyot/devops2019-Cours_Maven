#!/bin/bash
#######################################################################################################################
#	V1 28/03/2019 : création du programme.                                                                        #
#	                                                                                                              #
#	                                                                                                              #
#	                                                                                                              #
#	                                                                                                              #
#	                                                                                                              #
#	                                                                                                              #
#######################################################################################################################

##Déclaration des variables.


#Indicator for download source
havetowget=0
#adresse des sources 
adresse=`pwd`

#wget
if !(wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo)
then
	echo "probleme wget"
	exit 201
fi
#rpm
if !(rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key)
then
	echo "probleme rpm"
	exit 202
fi
#install jenkins
if !(yum install jenkins)
then
	echo "probleme rpm"
	exit 203
fi
#copy
if !(cp $adresse/ressource/jenkins /etc/init.d/jenkins)
then
	echo "probleme copie du jenkins"
	exit 204
fi
