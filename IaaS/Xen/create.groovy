vg=debian-vg	# LVM Volume Group
lv=windows

createStorage(){
	if exists: /dev/$vg/$lv
		lvremove /dev/$vg/$lv
	if
	lvcreate -L 25G -n $lv /dev/$vg
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
