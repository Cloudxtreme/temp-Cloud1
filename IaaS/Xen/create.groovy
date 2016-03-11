vm=windows
lvm=debian-vg	# LVM Volume Group


sudo lvcreate -L 25G -n $vm /dev/$lvm

createStorage(){
	sudo lvremove /dev/$lvm/$vm
}

create(){
	vm=$1
	cfg=$2
	sudo cp /media/rfs/data/xen/${vm}${cfg}.cfg /etc/xen/$vm.cfg

	sudo xl create /etc/xen/$vm.cfg
	
	# Tmp
	sudo xl create /home/me/Desktop/Windows.cfg
	
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
