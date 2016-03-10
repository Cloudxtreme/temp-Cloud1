#!/bin/bash

destroy(){
	sudo xl shutdown -F windows
	sudo xl destroy windows
}

create(){
	sudo xl create /etc/xen/windows.cfg
}

create