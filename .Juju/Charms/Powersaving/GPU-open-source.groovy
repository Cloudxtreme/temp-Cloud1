#	"I'm getting as low as 62.0°C with 'profile'!"
#	http://xorg.freedesktop.org/wiki/RadeonFeature

Info(){
	# Check info
	cat /proc/cmdline
	cat /sys/kernel/debug/dri/0/radeon_pm_info

	# Which method?
	cat /sys/class/drm/card0/device/power_method

	# dpm
	cat /sys/class/drm/card0/device/power_dpm_state
	cat /sys/class/drm/card0/device/power_dpm_force_performance_level

	# profile
	cat /sys/class/drm/card0/device/power_profile
}

Temperature(){
	# Temperature & Benchmark
	dnf -y install lm_sensors glmark2
	glmark2 &

	watch sensors
}


On(){
	# https://wiki.archlinux.org/index.php/ATI#Powersaving
	# https://wiki.archlinux.org/index.php/ATI#Persistent_configuration
	# Keep!  http://askubuntu.com/questions/65570/radeon-hd-6950-temperature-is-way-too-hot
	#	su required

	Grub_dpm_onoff(){
		if off:
			ansible! *add radeon.dpm=0 to /etc/default/grub
		if on:
			ansible! *add radeon.dpm=1 to /etc/default/grub

		# update-grub
		grub2-mkconfig -o /boot/grub2/grub.cfg
		reboot
	}

	dpm(){
		# Dynamic power management - hardware based
		# Grub radeon.dpm on
		echo battery > /sys/class/drm/card0/device/power_dpm_state
		echo low > /sys/class/drm/card0/device/power_dpm_force_performance_level

	}
	
	dynpm(){
		# Dynamic frequency switching
		echo dynpm > /sys/class/drm/card0/device/power_method
		echo '''w /sys/class/drm/card0/device/power_method - - - - dynpm''' | tee /etc/tmpfiles.d/radeon-pm.conf
		
		# Persistent configuration
	}

	profile(){
		# Profile-based frequency switching
		echo profile > /sys/class/drm/card0/device/power_method
		echo low > /sys/class/drm/card0/device/power_profile
		
		# Persistent configuration
		echo '''KERNEL=="dri/card0", SUBSYSTEM=="drm", DRIVERS=="radeon", ATTR{device/power_method}="profile", ATTR{device/power_profile}="low"''' | tee /etc/udev/rules.d/30-radeon-pm.rules
		
	}
}
