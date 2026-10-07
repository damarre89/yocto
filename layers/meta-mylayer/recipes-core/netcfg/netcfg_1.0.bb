SUMMARY = "Static IP and NTP config"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://10-eth0.network file://ntp.conf"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${UNPACKDIR}/10-eth0.network ${D}${sysconfdir}/systemd/network/
    install -d ${D}${sysconfdir}/systemd/timesyncd.conf.d
    install -m 0644 ${UNPACKDIR}/ntp.conf ${D}${sysconfdir}/systemd/timesyncd.conf.d/
}
FILES:${PN} = "${sysconfdir}/systemd/network ${sysconfdir}/systemd/timesyncd.conf.d"