vm=windows
sudo lvcreate -L 40G -n $vm /dev/xenv

createDisk(){
	sudo lvremove /dev/xenv/$vm
}

run(){
	vm=$1
	cfg=$2
	sudo cp /media/rfs/data/xen/${vm}${cfg}.cfg /etc/xen/$vm.cfg
	sudo xl create /etc/xen/$vm.cfg
	sleep 7
	vncviewer localhost:0
}

run windows -ins

lvSnapshot(){
	vm=$1
	sudo lvcreate -L10G -s -n $vm-snap /dev/xenv/$vm
	sudo lvs
}

lvSnapshot fedora
