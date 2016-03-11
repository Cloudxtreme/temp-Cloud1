vm=windows
lvm=debian-vg	# LVM Volume Group

sudo lvcreate -L 25G -n $vm /dev/$lvm

createDisk(){
	sudo lvremove /dev/$lvm/$vm
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
